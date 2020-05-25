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
			setSystemMessage("菜单名称不能为空",false,"var.menu_name()");
			return INPUT;
		}else if(var.getMenu_isleaf().equalsIgnoreCase("Y") && ValidateUtils.isNullOrEmpty(var.getMenu_url())){
			setSystemMessage("菜单项必须是有对应的url",false,"var.menu_name()");
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
			setSystemMessage("系统菜单创建成功，请手动刷新列表！");
		} else {
			setSystemMessage("系统菜单创建失败！");
			return INPUT;
		}

		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(var.getMenu_parent_id())  ){
			setSystemMessage("菜单上级节点不能为空",true,null);
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
