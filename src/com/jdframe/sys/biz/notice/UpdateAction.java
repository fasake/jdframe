package com.jdframe.sys.biz.notice;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_notice;
 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.notice.UpdateAction.java
 * The Class UpdateAction.
 * Last-Modified-Time : 2014-1-2 17:32:41
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	*/
	private static final long serialVersionUID = -1874224702642474771L;
	 
	
	/* (�� Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(var.getNotice_id()) ){
			setSystemMessage("ϵͳ����id����Ϊ��",false,"var.notice_id");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_title()) ){
			setSystemMessage("ϵͳ������ⲻ��Ϊ��",false,"var.notice_title");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_expire_date()) ){
			setSystemMessage("ϵͳ���浽��ʱ�䲻��Ϊ��",false,"var.notice_expire_date");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_zzjg_dm()) ){
			setSystemMessage("ϵͳ����������벻��Ϊ��",false,"var.notice_zzjg_dm");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_content()) ){
			setSystemMessage("ϵͳ�������ݲ���Ϊ�ղ���Ϊ��",false,"var.notice_content");
			return INPUT;
		}
		 
		var.setNotice_expire_date(var.getNotice_expire_date().substring(0,10).concat(" 00:00:00"));
		
		deleteAttachBeforSave(var,sqlsession);
		attachImpl(var);
		int i = sqlsession.update("updateNotice", var);
		if(i>0){
			var = new T_sys_notice();
			setSystemMessage("Update Item Success!");
			return SUCCESS;
		}else{
		     setSystemMessage("Update Item Failed!");
		     return INPUT;
		}
			 
	}


	
	
	 
	/* (�� Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
        if(ValidateUtils.isNullOrEmpty(var.getNotice_id())){
        	setSystemMessage("����ID����Ϊ�գ�",true,"");
        }
        
	}

 
	/* (�� Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		//��ʼ��������Ϣ
		var =  sqlsession.selectOne("getNoticeByNoticeId", var.getNotice_id());
		return INITIAL;
	}
	
	 


	
	
}
