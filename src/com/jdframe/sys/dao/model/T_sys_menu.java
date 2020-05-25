package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;



// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.dao.model.T_sys_menu.java
 * The Class T_sys_menu.
 * Last-Modified-Time : 2013-11-8 10:50:52
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class T_sys_menu implements T_vo {
	
	/** The menu_id. */
	private String menu_id;//菜单ID
	
	/** The menu_name. */
	private String menu_name;//菜单名称
	
	/** The menu_url. */
	private String menu_url;//菜单导航地址
	
	/** The menu_system. */
	private String menu_system;//菜单系统
	
	/** The menu_argument. */
	private String menu_argument;//菜单参数
	
	/** The menu_create. */
	private String menu_create;//菜单创建人
	
	/** The menu_create_date. */
	private String menu_create_date;//菜单创建时间
	
	/** The menu_privilege. */
	private String menu_privilege;//菜单权限
	
	/** The menu_isvalid. */
	private String menu_isvalid;//是否启用
	
	/** The menu_isleaf. */
	private String menu_isleaf;//是否叶子节点，如果不是忽略URL
	
	/** The menu_parent_id. */
	private String menu_parent_id;//父级菜单id
	
	 
	/**
	 * Gets the menu_id.
	 *
	 * @return the menu_id
	 */
	public String getMenu_id() {
		return menu_id;
	}
	
	/**
	 * Sets the menu_id.
	 *
	 * @param menu_id the new menu_id
	 */
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	
	/**
	 * Gets the menu_name.
	 *
	 * @return the menu_name
	 */
	public String getMenu_name() {
		return menu_name;
	}
	
	/**
	 * Sets the menu_name.
	 *
	 * @param menu_name the new menu_name
	 */
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	
	/**
	 * Gets the menu_url.
	 *
	 * @return the menu_url
	 */
	public String getMenu_url() {
		return menu_url;
	}
	
	/**
	 * Sets the menu_url.
	 *
	 * @param menu_url the new menu_url
	 */
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	
	/**
	 * Gets the menu_system.
	 *
	 * @return the menu_system
	 */
	public String getMenu_system() {
		return menu_system;
	}
	
	/**
	 * Sets the menu_system.
	 *
	 * @param menu_system the new menu_system
	 */
	public void setMenu_system(String menu_system) {
		this.menu_system = menu_system;
	}
	
	/**
	 * Gets the menu_argument.
	 *
	 * @return the menu_argument
	 */
	public String getMenu_argument() {
		return menu_argument;
	}
	
	/**
	 * Sets the menu_argument.
	 *
	 * @param menu_argument the new menu_argument
	 */
	public void setMenu_argument(String menu_argument) {
		this.menu_argument = menu_argument;
	}
	
	/**
	 * Gets the menu_create.
	 *
	 * @return the menu_create
	 */
	public String getMenu_create() {
		return menu_create;
	}
	
	/**
	 * Sets the menu_create.
	 *
	 * @param menu_create the new menu_create
	 */
	public void setMenu_create(String menu_create) {
		this.menu_create = menu_create;
	}
	
	/**
	 * Gets the menu_create_date.
	 *
	 * @return the menu_create_date
	 */
	public String getMenu_create_date() {
		return menu_create_date;
	}
	
	/**
	 * Sets the menu_create_date.
	 *
	 * @param menu_create_date the new menu_create_date
	 */
	public void setMenu_create_date(String menu_create_date) {
		this.menu_create_date = menu_create_date;
	}
	
	/**
	 * Gets the menu_privilege.
	 *
	 * @return the menu_privilege
	 */
	public String getMenu_privilege() {
		return menu_privilege;
	}
	
	/**
	 * Sets the menu_privilege.
	 *
	 * @param menu_privilege the new menu_privilege
	 */
	public void setMenu_privilege(String menu_privilege) {
		this.menu_privilege = menu_privilege;
	}
	
	/**
	 * Gets the menu_isvalid.
	 *
	 * @return the menu_isvalid
	 */
	public String getMenu_isvalid() {
		return menu_isvalid;
	}
	
	/**
	 * Sets the menu_isvalid.
	 *
	 * @param menu_isvalid the new menu_isvalid
	 */
	public void setMenu_isvalid(String menu_isvalid) {
		this.menu_isvalid = menu_isvalid;
	}
	
	/**
	 * Gets the menu_isleaf.
	 *
	 * @return the menu_isleaf
	 */
	public String getMenu_isleaf() {
		return menu_isleaf;
	}
	
	/**
	 * Sets the menu_isleaf.
	 *
	 * @param menu_isleaf the new menu_isleaf
	 */
	public void setMenu_isleaf(String menu_isleaf) {
		this.menu_isleaf = menu_isleaf;
	}
	
	/**
	 * Gets the menu_parent_id.
	 *
	 * @return the menu_parent_id
	 */
	public String getMenu_parent_id() {
		return menu_parent_id;
	}
	
	/**
	 * Sets the menu_parent_id.
	 *
	 * @param menu_parent_id the new menu_parent_id
	 */
	public void setMenu_parent_id(String menu_parent_id) {
		this.menu_parent_id = menu_parent_id;
	}
	
}
