package com.jdframe.sys.biz.org;



import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_organization;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.org.OrganizationAction.java
 * The Class OrganizationAction.
 * Last-Modified-Time : 2013-11-8 10:43:04
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
	
	//T_sys_organization
	protected T_sys_organization var = new T_sys_organization();
	
	public T_sys_organization getVar() {
		return var;
	}
	public void setVar(T_sys_organization var) {
		this.var = var;
	}
	  
	
	 

	
	
}
