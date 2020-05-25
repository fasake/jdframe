package com.jdframe.sys.biz.menu;


import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_menu;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.menu.MenuUpdateAction.java
 * The Class MenuUpdateAction.
 * Last-Modified-Time : 2013-11-8 10:42:19
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -1874224702642474771L;
	 
	
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if( ValidateUtils.isNullOrEmpty(var.getMenu_name())){
			setSystemMessage( "菜单名称不能为空", true, "");
			return INPUT;
		}else if(var.getMenu_isleaf().equalsIgnoreCase("Y") && ValidateUtils.isNullOrEmpty(var.getMenu_url())){
			setSystemMessage( "菜单节点URL不能为空", false, "");
			return INPUT;
		}
		 
		int i = sqlsession.update("updateMenu", var);
		if(i>0){
			String menu_parent_id = var.getMenu_parent_id();
			var = null;
			var = new T_sys_menu();
			var.setMenu_parent_id(menu_parent_id);
			setSystemMessage("Update Item Success!");
		}else{
			setSystemMessage("Update Item Failed!");
			return INPUT;
		}
		return SUCCESS;
	}
	
 
	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
        if(ValidateUtils.isNullOrEmpty(var.getMenu_id())){
        	setSystemMessage("菜单节点Id不能为空！",true,"");
        }
        
	}

 
	/* (非 Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		//初始化
		var = sqlsession.selectOne("getMenuByMenuId", var.getMenu_id());
		return INITIAL;
	}

}
