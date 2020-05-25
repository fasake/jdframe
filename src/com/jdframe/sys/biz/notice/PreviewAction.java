package com.jdframe.sys.biz.notice;

import com.jdframe.sys.core.util.ValidateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.notice.PreviewAction.java
 * The Class PreviewAction.
 * Last-Modified-Time : 2014-1-2 17:32:26
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class PreviewAction extends Action {

	/* (�� Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		var =  sqlsession.selectOne("getNoticeByNoticeId", var.getNotice_id());
		return SUCCESS;
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
		return null;
	}

}
