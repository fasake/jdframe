package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.dao.model.T_sys_notice.java
 * The Class T_sys_notice.
 * Last-Modified-Time : 2013-11-8 10:50:48
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class T_sys_notice implements T_vo {
	
	/** The notice_id. */
	private String notice_id;//公告ID
	
	/** The notice_title. */
	private String notice_title;//公告标题
	
	/** The notice_content. */
	private String notice_content;//公告内容
	
	/** The notice_creater. */
	private String notice_creater;//公告发布者
	
	/** The notice_create_date. */
	private String notice_create_date;//公告发布时间
	
	
	
	/** The notice_level. */
	private String notice_level;//公告紧急级别
	
	/** The notice_expire_date. */
	private String notice_expire_date;//公告到期时间
	
	/** The notice_zzjg_dm. */
	private String notice_zzjg_dm;//公告组织机构显示范围
    
    /** The notice_attach_uri. */
    private String notice_attach_uri;//文件附件uri
    
    /** The notice_attach_name. */
    private String notice_attach_name;//文件附件名称
    
    /** The notice_attach_content_type. */
    private String notice_attach_content_type;//文件附件类型
	
    //query contition.
    private String notice_create_date_start;
	private String notice_create_date_end;
	/**
	 * Gets the notice_id.
	 *
	 * @return the notice_id
	 */
	public String getNotice_id() {
		return notice_id;
	}
	
	/**
	 * Sets the notice_id.
	 *
	 * @param notice_id the new notice_id
	 */
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	
	/**
	 * Gets the notice_title.
	 *
	 * @return the notice_title
	 */
	public String getNotice_title() {
		return notice_title;
	}
	
	/**
	 * Sets the notice_title.
	 *
	 * @param notice_title the new notice_title
	 */
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	/**
	 * Gets the notice_content.
	 *
	 * @return the notice_content
	 */
	public String getNotice_content() {
		return notice_content;
	}
	
	/**
	 * Sets the notice_content.
	 *
	 * @param notice_content the new notice_content
	 */
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
	/**
	 * Gets the notice_creater.
	 *
	 * @return the notice_creater
	 */
	public String getNotice_creater() {
		return notice_creater;
	}
	
	/**
	 * Sets the notice_creater.
	 *
	 * @param notice_creater the new notice_creater
	 */
	public void setNotice_creater(String notice_creater) {
		this.notice_creater = notice_creater;
	}
	
	/**
	 * Gets the notice_create_date.
	 *
	 * @return the notice_create_date
	 */
	public String getNotice_create_date() {
		return notice_create_date;
	}
	
	/**
	 * Sets the notice_create_date.
	 *
	 * @param notice_create_date the new notice_create_date
	 */
	public void setNotice_create_date(String notice_create_date) {
		this.notice_create_date = notice_create_date;
	}
	
	/**
	 * Gets the notice_level.
	 *
	 * @return the notice_level
	 */
	public String getNotice_level() {
		return notice_level;
	}
	
	/**
	 * Sets the notice_level.
	 *
	 * @param notice_level the new notice_level
	 */
	public void setNotice_level(String notice_level) {
		this.notice_level = notice_level;
	}
	
	/**
	 * Gets the notice_expire_date.
	 *
	 * @return the notice_expire_date
	 */
	public String getNotice_expire_date() {
		return notice_expire_date;
	}
	
	/**
	 * Sets the notice_expire_date.
	 *
	 * @param notice_expire_date the new notice_expire_date
	 */
	public void setNotice_expire_date(String notice_expire_date) {
		this.notice_expire_date = notice_expire_date;
	}
	
	/**
	 * Gets the notice_zzjg_dm.
	 *
	 * @return the notice_zzjg_dm
	 */
	public String getNotice_zzjg_dm() {
		return notice_zzjg_dm;
	}
	
	/**
	 * Sets the notice_zzjg_dm.
	 *
	 * @param notice_zzjg_dm the new notice_zzjg_dm
	 */
	public void setNotice_zzjg_dm(String notice_zzjg_dm) {
		this.notice_zzjg_dm = notice_zzjg_dm;
	}

	/**
	 * Gets the notice_attach_uri.
	 *
	 * @return the notice_attach_uri
	 */
	public String getNotice_attach_uri() {
		return notice_attach_uri;
	}

	/**
	 * Sets the notice_attach_uri.
	 *
	 * @param notice_attach_uri the new notice_attach_uri
	 */
	public void setNotice_attach_uri(String notice_attach_uri) {
		this.notice_attach_uri = notice_attach_uri;
	}

	/**
	 * Gets the notice_attach_name.
	 *
	 * @return the notice_attach_name
	 */
	public String getNotice_attach_name() {
		return notice_attach_name;
	}

	/**
	 * Sets the notice_attach_name.
	 *
	 * @param notice_attach_name the new notice_attach_name
	 */
	public void setNotice_attach_name(String notice_attach_name) {
		this.notice_attach_name = notice_attach_name;
	}

	/**
	 * Gets the notice_attach_content_type.
	 *
	 * @return the notice_attach_content_type
	 */
	public String getNotice_attach_content_type() {
		return notice_attach_content_type;
	}

	/**
	 * Sets the notice_attach_content_type.
	 *
	 * @param notice_attach_content_type the new notice_attach_content_type
	 */
	public void setNotice_attach_content_type(String notice_attach_content_type) {
		this.notice_attach_content_type = notice_attach_content_type;
	}

	public String getNotice_create_date_start() {
		return notice_create_date_start;
	}

	public void setNotice_create_date_start(String notice_create_date_start) {
		this.notice_create_date_start = notice_create_date_start;
	}

	public String getNotice_create_date_end() {
		return notice_create_date_end;
	}

	public void setNotice_create_date_end(String notice_create_date_end) {
		this.notice_create_date_end = notice_create_date_end;
	}

	 
	
    
	
   
	
	 
}
