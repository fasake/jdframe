package com.jdframe.sys.biz.role;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_role;

public class DeleteAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		int i = sqlsession.delete("deleteRoleById", var);
		if(i>0){
			revoke(sqlsession,var.getRole_id(),GRANT_TYPE.GRANT_ROLE_ASSO_MENU);
			var = new T_sys_role();
			setSystemMessage("Delete Item Success!");
		}else{
			setSystemMessage("Delete Item Fail!");
			return INPUT;
		}
		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		 if(StringUtils.isEmptyOrNull(var.getRole_id())){
				setSystemMessage("角色ID不能为空！", false, "var.role_id");
		} 
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
