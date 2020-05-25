package com.jdframe.sys.biz.role;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_menu;
import com.jdframe.sys.dao.model.T_sys_role;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.role.RoleAction.java
 * The Class RoleAction.
 * Last-Modified-Time : 2013-11-8 10:44:55
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
	/** The role. */
	protected T_sys_role var = new T_sys_role();
 
	//系统菜单树信息
    /** The menu tree. */
	private String menuTree = "";
	 
	 
	/**
	 * Gets the menu tree.
	 *
	 * @return the menu tree
	 */
	public String getMenuTree() {
		return menuTree;
	}
 
	/**
	 * Sets the menu tree.
	 *
	 * @param menuTree the new menu tree
	 */
	public void setMenuTree(String menuTree) {
		this.menuTree = menuTree;
	}
    
   
	/**
	 * Gets the var.
	 *
	 * @return the var
	 */
	public T_sys_role getVar() {
		return var;
	}

	/**
	 * Sets the var.
	 *
	 * @param var the new var
	 */
	public void setVar(T_sys_role var) {
		this.var = var;
	}

	/**
	 * Builds the tree.
	 *
	 * @return the string
	 */
	protected String buildTree(){
		// TODO Auto-generated method stub
				String menuTree = "  d = new dTree('d');\r\n"+" d.add(1,-1,'系统菜单'); \r\n";
				menuTree +=  getChildNodes();
				menuTree +=  "document.write(d);";
				this.setMenuTree(menuTree);
				return menuTree;
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
			ArrayList<T_sys_menu> list  = (ArrayList) ss.selectList("buildMenuTree");
			T_sys_menu menu = null;
			for (int i = 0; i < list.size(); i++) {
				menu = list.get(i);
				childNodesInnerHTML.append(menu.getMenu_name());
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
