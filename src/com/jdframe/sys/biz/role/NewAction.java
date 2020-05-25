package com.jdframe.sys.biz.role;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_role;

 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.role.NewAction.java
 * The Class NewAction.
 * Last-Modified-Time : 2014-1-2 11:52:59
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class NewAction extends Action {

	/* (�� Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		
		 if(StringUtils.isEmptyOrNull(var.getRole_name())){
			setSystemMessage("��ɫ���Ʋ���Ϊ�գ�", false, "var.role_name");
			return INPUT;
		} 
		
		
		String role_id  = sqlsession.selectOne("getNewRoleId");
		var.setRole_id(role_id);
 	 
		var.setRole_creater(getUserProfileFromSession().getUser().getUser_dm());
		var.setRole_create_date(DateUtils.newDateTime());
		//���ý�ɫ��Χ����ȡʱ������role_zzjg_dm��role_scopeȷ����Χ
		if(var.getRole_scope().equals("1") || var.getRole_scope().equals("2")){
			//����λ ���� ����λ���¼�
			var.setRole_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm());
		}else if(var.getRole_scope().equals("3")){
			//������
			var.setRole_zzjg_dm(getUserProfileFromSession().getUser().getUser_zzjg().getZzjg_dm());
		}
		var.setRole_order(var.getRole_id());
		int i = sqlsession.insert("insertRole", var);
		if(i>0){
			int j = grant(sqlsession,var.getRole_id(),var.getRole_menu_id(),GRANT_TYPE.GRANT_ROLE_ASSO_MENU);
			var = null;
			var = new T_sys_role();
			setSystemMessage("Save Item Success!");
		}else{
			setSystemMessage("Save Item Failed!");
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
		//��ʼ������֯������Ϣ
		buildTree();
		return INITIAL;
	}
 
}
