package com.jdframe.sys.biz.menu;

import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_menu;

public class DeleteAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		T_sys_menu tmp = sqlsession.selectOne("getMenuByMenuId", var.getMenu_id());
		String menu_parent_id = tmp.getMenu_parent_id();
		tmp = null;
		int i = sqlsession.delete("deleteMenuById", var);
		if(i>0){
			
			var = null;
			var = new T_sys_menu();
			var.setMenu_parent_id(menu_parent_id);
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
		if(ValidateUtils.isNullOrEmpty(var.getMenu_id())){
			setSystemMessage("菜单ID不能为空",true,"");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INITIAL;
	}

	 

}
