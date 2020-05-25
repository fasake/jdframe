package com.jdframe.sys.biz.role;


import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.*;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.jdframe.sys.dao.model.T_sys_role;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.role.RoleUpdateAction.java
 * The Class RoleUpdateAction.
 * Last-Modified-Time : 2013-11-8 10:44:37
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	*/
	private static final long serialVersionUID = -1874224702642474771L;
	 
	
	/* (�� Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if(  ValidateUtils.isNullOrEmpty(var.getRole_name())){
			setSystemMessage("��ɫ���Ʋ���Ϊ��",false,"var.role_name");
			return INPUT;
		}
		
		int i = sqlsession.update("updateRole", var);
		if(i > 0){
			grant(sqlsession,var.getRole_id(),var.getRole_menu_id(),GRANT_TYPE.GRANT_ROLE_ASSO_MENU);
			var = null;
			var = new T_sys_role();
			setSystemMessage("Update Item Success!");
		}else{
		    setSystemMessage("Update Item Failed!");
		    return INPUT;
		}
		
		return SUCCESS;
	}
	
	 
	
	
	/* (�� Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
        if(ValidateUtils.isNullOrEmpty(var.getRole_id())){
        	setSystemMessage("��ɫID����Ϊ�գ�",true,null);
        }
        
	}

 
	/* (�� Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		//��ʼ��������Ϣ
		var =  sqlsession.selectOne("getRoleByRoleId", var.getRole_id());
		//��ʼ����
		buildTree();
		return INITIAL;
	}
	
	
	
}
