package com.jdframe.sys.biz.station;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_station;

public class NewAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		//the Station Name is required
		 if(StringUtils.isEmptyOrNull(var.getStation_name())){
				setSystemMessage("��λ���Ʋ���Ϊ��!", false, "var.role_name");
				return INPUT;
		 } 
		
		
		String station_id  = sqlsession.selectOne("getNewStationId");
     
		var.setStation_id(station_id);
		var.setStation_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm());
		 
			 
		var.setStation_creater(getUserProfileFromSession().getUser().getUser_dm());
		var.setStation_create_date(DateUtils.newDateTime());
		//���ø�λ��Χ����ȡʱ������station_zzjg_dm��station_scopeȷ����Χ
		if(var.getStation_scope().equals("1") || var.getStation_scope().equals("2")){
			//���������¼�
			var.setStation_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm());
		}else if(var.getStation_scope().equals("3")){
			//������
			var.setStation_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg().getZzjg_dm());
		}
		var.setStation_order(var.getStation_id());
		int i = sqlsession.insert("insertStation", var);
		if(i > 0){
			int j = grant(sqlsession,var.getStation_id(),var.getStation_role_id(),GRANT_TYPE.GRANT_STATION_ASSO_ROLE);
			var = new T_sys_station();
			setSystemMessage("Save Item Success!");
		}else{
			setSystemMessage("Save Item Failed!");
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
		buildTree();
		return INITIAL;
	}

}
