package com.jdframe.sys.biz.user;

import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.core.util.ByteUtils;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.jdframe.sys.dao.model.T_sys_user;

public class NewAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_dm())){
			setSystemMessage("�û����벻��Ϊ�գ�", false, "var.zzjg_dm");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getUser_name())){
			setSystemMessage("�û����Ʋ���Ϊ�գ�", false, "var.zzjg_name");
			return INPUT;
		}
		
		T_sys_user tmp  = sqlsession.selectOne("getUserByUserDm",var.getUser_dm());
		if(tmp == null){
			String newId = sqlsession.selectOne("getNewUserId");
			String newpwd = "123456";
			//init password to 123456
			Object __obj = CodesCache.findCode("00000000001", "DM_UPWD");
			if(__obj != null){
				newpwd = StringUtils.toString(newpwd);
			}
			var.setUser_pwd(ByteUtils.sha512Hex(newpwd));
			var.setUser_id(newId);
			int i = sqlsession.insert("insertUser", var);
			if(i>0){
				String user_zzjg_dm = var.getUser_zzjg_dm();
				var = null;
				var = new T_sys_user();
				var.setUser_zzjg_dm(user_zzjg_dm);
				setSystemMessage("������Ա�����ɹ������ֶ�ˢ�²�ѯ�����");
			}
		}else{
			setSystemMessage("������Ա����ʧ�ܣ�������Ա�Ѵ���!");
			return INPUT;
		}
 
    		 
        return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_zzjg_dm())){
			setSystemMessage("�û���֯��������Ϊ�գ�", true, "var.user_zzjg_dm");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INPUT;
	}

 
}
