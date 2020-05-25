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
			setSystemMessage("用户代码不能为空！", false, "var.zzjg_dm");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getUser_name())){
			setSystemMessage("用户名称不能为空！", false, "var.zzjg_name");
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
				setSystemMessage("操作人员创建成功，请手动刷新查询结果！");
			}
		}else{
			setSystemMessage("操作人员创建失败，操作人员已存在!");
			return INPUT;
		}
 
    		 
        return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_zzjg_dm())){
			setSystemMessage("用户组织机构不能为空！", true, "var.user_zzjg_dm");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INPUT;
	}

 
}
