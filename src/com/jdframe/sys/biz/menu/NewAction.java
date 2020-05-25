package com.jdframe.sys.biz.menu;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_menu;

public class NewAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		
		if(ValidateUtils.isNullOrEmpty(var.getMenu_name())  ){
			setSystemMessage("�˵����Ʋ���Ϊ��",false,"var.menu_name()");
			return INPUT;
		}else if(var.getMenu_isleaf().equalsIgnoreCase("Y") && ValidateUtils.isNullOrEmpty(var.getMenu_url())){
			setSystemMessage("�˵���������ж�Ӧ��url",false,"var.menu_name()");
			return INPUT;
		}
		
		
		String menu_id = sqlsession.selectOne("getNewMenuId");
		var.setMenu_id(menu_id);
		var.setMenu_privilege(getUserProfileFromSession().getUser()
				.getUser_zzjg_sj().getZzjg_dm());

		var.setMenu_create(getUserProfileFromSession().getUser().getUser_dm());
		var.setMenu_create_date(DateUtils.newDateTime());
		int i = sqlsession.insert("insertMenu", var);
		if (i > 0) {
			String menu_parent_id = var.getMenu_parent_id();
			var = null;
			var = new T_sys_menu();
			var.setMenu_parent_id(menu_parent_id);
			setSystemMessage("ϵͳ�˵������ɹ������ֶ�ˢ���б�");
		} else {
			setSystemMessage("ϵͳ�˵�����ʧ�ܣ�");
			return INPUT;
		}

		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(var.getMenu_parent_id())  ){
			setSystemMessage("�˵��ϼ��ڵ㲻��Ϊ��",true,null);
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		T_sys_menu tmp = sqlsession.selectOne("getMenuByMenuId", var.getMenu_parent_id());
		if(tmp != null){
			
		}
		return INITIAL;
	}

}
