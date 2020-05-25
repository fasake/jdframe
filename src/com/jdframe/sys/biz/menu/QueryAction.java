package com.jdframe.sys.biz.menu;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_menu;

// TODO: Auto-generated Javadoc
 
/**
 * The Path : com.jdframe.sys.biz.menu.QueryAction.java
 * The Class QueryAction.
 * Last-Modified-Time : 2014-1-2 9:45:34
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class QueryAction extends Action {
	
    
   /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 4415715493903744460L;

/**
    * 
    */
    @Override
    protected String initial(){
    	return INITIAL;
    }
    
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		ArrayList<T_sys_menu> list  = (ArrayList) sqlsession.selectList("getMenu_listPage", var);
		this.setPagenationList(list);
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
		String menu_parent_id = var.getMenu_parent_id();
    	if(ValidateUtils.isNullOrEmpty(menu_parent_id)){
    		this.setSystemMessage("菜单管理模块初始化失败！",true,"");
    	}
    	
	}
	
	

}
