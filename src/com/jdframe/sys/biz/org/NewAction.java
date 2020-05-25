package com.jdframe.sys.biz.org;

import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.opensymphony.xwork2.ActionContext;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.org.NewAction.java
 * The Class NewAction.
 * Last-Modified-Time : 2013-12-27 11:22:45
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
		//Check input form.
		if(StringUtils.isEmptyOrNull(var.getZzjg_dm())){
			setSystemMessage("��֯�������벻��Ϊ�գ�", false, "var.zzjg_dm");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getZzjg_name())){
			setSystemMessage("��֯�������Ʋ���Ϊ�գ�", false, "var.zzjg_name");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getZzjg_jc())){
			setSystemMessage("��֯������Ʋ���Ϊ�գ�", false, "var.zzjg_jc");
			return INPUT;
		}
		
		T_sys_organization tmp  = sqlsession.selectOne("getOrgBySwjgDm",var.getZzjg_dm());
		if(tmp != null){
			setSystemMessage("��֯��������ʧ�ܣ���֯�����Ѵ���",false,var.getZzjg_name());
			return INPUT;
		}
		
		//��ȡ�µ���֯����ID
		String zzjg_id  = sqlsession.selectOne("getNewZzjgId");
		var.setZzjg_id(zzjg_id);
		
		int i = sqlsession.insert("insertOrg", var);
		if(i > 0){
			String zzjg_dm_sj = var.getZzjg_dm_sj();
			var = null;
			var = new T_sys_organization();
			var.setZzjg_dm_sj(zzjg_dm_sj);
			setSystemMessage("Save Item Success!",true,null);
		}else{
			//fail
			setSystemMessage("Save Item Failed!",true,null);
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
	    	if(ValidateUtils.isNullOrEmpty(var.getZzjg_dm_sj())  ){
				setSystemMessage("��֯�����ϼ�����dm����Ϊ��",false,var.getZzjg_name());
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
		return INITIAL;
	}
 
}
