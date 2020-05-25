package com.jdframe.sys.biz.notice;

import java.io.File;

import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_notice;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.notice.NewAction.java
 * The Class NewAction.
 * Last-Modified-Time : 2014-1-2 17:32:33
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class NewAction extends Action {

	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(var.getNotice_title()) ){
			setSystemMessage("系统公告标题不能为空",false,"var.notice_title");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_expire_date()) ){
			setSystemMessage("系统公告到期时间不能为空",false,"var.notice_expire_date");
			return INPUT;
		}else if(ValidateUtils.isNullOrEmpty(var.getNotice_content()) ){
			setSystemMessage("系统公告内容不能为空不能为空",false,"var.notice_content");
			return INPUT;
		}
		
		var.setNotice_expire_date(var.getNotice_expire_date().substring(0, 10).concat(" 00:00:00"));
		var.setNotice_creater(getUserProfileFromSession().getUser().getUser_dm());
		var.setNotice_create_date(DateUtils.newDateTime());
		var.setNotice_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg_dm());
		String notice_id = sqlsession.selectOne("getNewNoticeId");
		var.setNotice_id(notice_id);
		if (attachImpl(var)) {
			int i = sqlsession.insert("insertNotice", var);
			if (i > 0) {
				setSystemMessage("Save Item Success!");
				var = null;
				var = new T_sys_notice();
				return SUCCESS;
			}else{
				setSystemMessage("Save Item Failed!");
				return INPUT;
			}
			
		} else {
			setSystemMessage("Save Item Failed!");
			return INPUT;
		}
	}

	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub

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
		return INITIAL;
	}

	
}
