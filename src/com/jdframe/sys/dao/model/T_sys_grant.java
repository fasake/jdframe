package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.dao.model.T_sys_grant.java
 * The Class T_sys_grant.
 * Last-Modified-Time : 2013-11-8 10:51:05
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class T_sys_grant implements T_vo {
	
	/** The grant_id. */
	private String grant_id;//授权ID
	
	/** The grant_fid. */
	private String grant_fid;//授权关联的ID
	
	/** The grant_type. */
	private String grant_type;//授权类型
	
	/** The grant_create_date. */
	private String grant_create_date;//授权日期
	
	/** The grant_creater. */
	private String grant_creater;//授权人员
	
	/**
	 * Gets the grant_id.
	 *
	 * @return the grant_id
	 */
	public String getGrant_id() {
		return grant_id;
	}
	
	/**
	 * Sets the grant_id.
	 *
	 * @param grant_id the new grant_id
	 */
	public void setGrant_id(String grant_id) {
		this.grant_id = grant_id;
	}
	
	/**
	 * Gets the grant_fid.
	 *
	 * @return the grant_fid
	 */
	public String getGrant_fid() {
		return grant_fid;
	}
	
	/**
	 * Sets the grant_fid.
	 *
	 * @param grant_fid the new grant_fid
	 */
	public void setGrant_fid(String grant_fid) {
		this.grant_fid = grant_fid;
	}
	
	/**
	 * Gets the grant_type.
	 *
	 * @return the grant_type
	 */
	public String getGrant_type() {
		return grant_type;
	}
	
	/**
	 * Sets the grant_type.
	 *
	 * @param grant_type the new grant_type
	 */
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	
	/**
	 * Gets the grant_create_date.
	 *
	 * @return the grant_create_date
	 */
	public String getGrant_create_date() {
		return grant_create_date;
	}
	
	/**
	 * Sets the grant_create_date.
	 *
	 * @param grant_create_date the new grant_create_date
	 */
	public void setGrant_create_date(String grant_create_date) {
		this.grant_create_date = grant_create_date;
	}
	
	/**
	 * Gets the grant_creater.
	 *
	 * @return the grant_creater
	 */
	public String getGrant_creater() {
		return grant_creater;
	}
	
	/**
	 * Sets the grant_creater.
	 *
	 * @param grant_creater the new grant_creater
	 */
	public void setGrant_creater(String grant_creater) {
		this.grant_creater = grant_creater;
	}
    
	
	 
}
