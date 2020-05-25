package com.jdframe.sys.biz.station;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.dao.model.T_sys_station;

public class DeleteAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		int i = sqlsession.delete("deleteStationById", var);
		if(i>0){
			revoke(sqlsession, var.getStation_id(), GRANT_TYPE.GRANT_STATION_ASSO_ROLE);
			var = new T_sys_station();
			setSystemMessage("Delete Item Success!");
			return SUCCESS;
		}else{
			setSystemMessage("Delete Item Fail!");
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
