package com.jdframe.sys.biz.notice;

import java.io.File;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_role;
import com.jdframe.sys.dao.model.T_sys_notice;
 
 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.notice.Action.java
 * The Class Action.
 * Last-Modified-Time : 2014-1-2 17:32:57
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
	/** The notice. */
	protected T_sys_notice var = new T_sys_notice();
	 
	
	//附件
	/** The attach. */
	private File attach;
	
	/** The attach file name. */
	private String attachContentType,attachFileName;
	
	 

	/**
	 * Gets the var.
	 *
	 * @return the var
	 */
	public T_sys_notice getVar() {
		return var;
	}

	/**
	 * Sets the var.
	 *
	 * @param var the new var
	 */
	public void setVar(T_sys_notice var) {
		this.var = var;
	}

	/**
	 * Gets the attach.
	 *
	 * @return the attach
	 */
	public File getAttach() {
		return attach;
	}

	/**
	 * Sets the attach.
	 *
	 * @param attach the new attach
	 */
	public void setAttach(File attach) {
		this.attach = attach;
	}

	/**
	 * Gets the attach content type.
	 *
	 * @return the attach content type
	 */
	public String getAttachContentType() {
		return attachContentType;
	}
    
	
	/**
	 * Sets the attach content type.
	 *
	 * @param attachContentType the new attach content type
	 */
	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}

	/**
	 * Gets the attach file name.
	 *
	 * @return the attach file name
	 */
	public String getAttachFileName() {
		return attachFileName;
	}

	/**
	 * Sets the attach file name.
	 *
	 * @param attachFileName the new attach file name
	 */
	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}
 
	/**
	 * Attach impl.
	 * 
	 * @param notice
	 *            the notice
	 * @return true, if successful
	 */
	protected boolean attachImpl(T_sys_notice notice) {
		if (getAttach() != null) {
			File attach = getAttach();
			String notice_attach_content_type = getAttachContentType();
			String notice_attach_name = getAttachFileName();

			String newfilename = saveAttach(attach);
			if (newfilename == null) {
				return false;
			}
			notice.setNotice_attach_uri($PATH_ATTACH + File.separator
					+ newfilename);
			notice.setNotice_attach_name(notice_attach_name);
			notice.setNotice_attach_content_type(notice_attach_content_type);
		} else {
			notice.setNotice_attach_uri("");
			notice.setNotice_attach_name("");
			notice.setNotice_attach_content_type("");
		}
		return true;
	}

	/**
	 * Delete attach befor save.
	 *
	 * @param notice the notice
	 * @param sqlsession the sqlsession
	 * @return true, if successful
	 */
	protected boolean deleteAttachBeforSave(T_sys_notice notice,SqlSession sqlsession) {
		T_sys_notice oldnotice  = sqlsession.selectOne("getNoticeByNoticeId",notice.getNotice_id());
		 if(oldnotice!=null){
			 String attach_uri = oldnotice.getNotice_attach_uri();
			 return deleteAttach(attach_uri);
		 }
		 
		 return true;
	}

}
