package com.jdframe.sys.biz.org;

import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_organization;

public class DeleteAction extends Action {

	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		//getOrgBySwjgDm
		
		String zzjg_dm = var.getZzjg_dm();
		var = sqlsession.selectOne("getOrgBySwjgDm", zzjg_dm);
		
		String zzjg_dm_sj = var.getZzjg_dm_sj();
		int i = sqlsession.delete("deleteOrgByZzjgDm", zzjg_dm);
		if(i>0){
			var = null;
			var = new T_sys_organization();
			var.setZzjg_dm_sj(zzjg_dm_sj);
			
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
		if(ValidateUtils.isNullOrEmpty(var.getZzjg_dm())){
			setSystemMessage("组织机构dm不能为空",true,"");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INITIAL;
	}


}
