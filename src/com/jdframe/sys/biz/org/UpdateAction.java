package com.jdframe.sys.biz.org;


import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.ActionContext;

import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_organization;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.org.OrganizationUpdateAction.java
 * The Class OrganizationUpdateAction.
 * Last-Modified-Time : 2013-11-8 10:43:16
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	*/
	private static final long serialVersionUID = 3432893059816250265L;
	/**
	 * 
	* @Title:   perform
	* @Description: TODO(������֯������Ϣ)
	* @param @return    �趨�ļ�
	* @return  String   ��������
	* @throws
	 */
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
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
		
		int i = sqlsession.update("updateOrg", var);
		if(i>0){
			String zzjg_dm_sj = var.getZzjg_dm_sj();
			var = null;
			var = new T_sys_organization();
			var.setZzjg_dm_sj(zzjg_dm_sj);
			setSystemMessage("Update Item Success!");
		}else{
			setSystemMessage("Update Item Failed!");
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
		if(ValidateUtils.isNullOrEmpty(var.getZzjg_dm())){
			setSystemMessage("��֯����dm����Ϊ��",false,var.getZzjg_dm());
		}
	}

     /**
      * ��ʼ����֯������Ϣ
      */
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		var  =  sqlsession.selectOne("getOrgBySwjgDm", var.getZzjg_dm());
		return INITIAL;
	}
	

}
