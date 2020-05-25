package com.jdframe.sys.biz.station;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_role;
import com.jdframe.sys.dao.model.T_sys_station;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.station.StationAction.java
 * The Class StationAction.
 * Last-Modified-Time : 2013-11-8 10:44:41
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public abstract class Action extends JdframeAction {
	
    
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 8181675709525823206L;
	//通用对象
	/** The station. */
	protected T_sys_station var = new T_sys_station();
 
	//系统菜单树信息
    /** The role tree. */
	private String roleTree = "";
	
 
   
	public T_sys_station getVar() {
		return var;
	}

	public void setVar(T_sys_station var) {
		this.var = var;
	}

	/**
	 * Gets the role tree.
	 *
	 * @return the role tree
	 */
	public String getRoleTree() {
		return roleTree;
	}
	
	/**
	 * Sets the role tree.
	 *
	 * @param roleTree the new role tree
	 */
	public void setRoleTree(String roleTree) {
		this.roleTree = roleTree;
	}
	
	/**
	 * Builds the tree.
	 *
	 * @return the string
	 */
	protected String buildTree(){
		// TODO Auto-generated method stub
				String roleTree = "  d = new dTree('d');\r\n"+" d.add(1,-1,'系统角色'); \r\n";
				roleTree +=  getChildNodes();
				roleTree +=  "document.write(d);";
				this.setRoleTree(roleTree);
				return roleTree;
	}
	
	/**
	 * Gets the child nodes.
	 *
	 * @return the child nodes
	 */
	public String getChildNodes(){
		StringBuffer childNodesInnerHTML = new StringBuffer("");
		SqlSession ss = buildSession();
		try{
			ArrayList<T_sys_role> list  = (ArrayList) ss.selectList("buildRoleTree",getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm());
			T_sys_role role = null;
			for (int i = 0; i < list.size(); i++) {
				role = list.get(i);
				childNodesInnerHTML.append(role.getRole_name());
			}
			return childNodesInnerHTML.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		 
			ss.close();
		}
		return "";
	}
}
