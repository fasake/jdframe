package com.jdframe.sys.biz.menu;

import java.util.HashMap;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.dao.model.T_sys_menu;
 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.menu.MenuAction.java
 * The Class MenuAction.
 * Last-Modified-Time : 2013-11-8 10:42:05
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
	/** The menu. */
	protected T_sys_menu var = new T_sys_menu();
	//菜单系统-下拉列表
	protected HashMap system = new HashMap();
	
	public T_sys_menu getVar() {
		return var;
	}
	public void setVar(T_sys_menu var) {
		this.var = var;
	}
	public HashMap getSystem() {
		if(system.isEmpty()){
			system = CodesCache.findCode("DM_SYSTEM");
		}
		return system;
	}
	
	
}
