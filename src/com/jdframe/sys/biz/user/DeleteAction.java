package com.jdframe.sys.biz.user;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.dao.model.T_sys_user;

public class DeleteAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		//check user is exists
		T_sys_user tmp = sqlsession.selectOne("getUserByUserId", var.getUser_id());
		if(tmp == null){
			setSystemMessage("Delete Item Failed, Item Not Found!");
			return INPUT;
		}
		
		int i = sqlsession.delete("deleteUserById", var);
		if(i>0){
			revoke(sqlsession,var.getUser_id(),GRANT_TYPE.GRANT_USER_ASSO_STATION);
			var = null;
			var = new T_sys_user();
			var.setUser_zzjg_dm(tmp.getUser_zzjg_dm());
			tmp = null;
			
			setSystemMessage("Delete Item Success!");
		}else{
			setSystemMessage("Delete Item Failed!");
			return INPUT;
		}
		return SUCCESS;
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
