package com.jdframe.sys.biz.notice;

import com.jdframe.sys.dao.model.T_sys_notice;

public class DeleteAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		int i = sqlsession.delete("deleteNoticeById", var);
		if(i>0){
			deleteAttachBeforSave(var, sqlsession);
			var = new T_sys_notice();
			setSystemMessage("Delete Item Success!");
			return SUCCESS;
		}else{
			setSystemMessage("Delete Item Failed!");
			return INPUT;
		}
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return null;
	}

}
