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
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 3432893059816250265L;
	/**
	 * 
	* @Title:   perform
	* @Description: TODO(更新组织机构信息)
	* @param @return    设定文件
	* @return  String   返回类型
	* @throws
	 */
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getZzjg_dm())){
			setSystemMessage("组织机构代码不能为空！", false, "var.zzjg_dm");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getZzjg_name())){
			setSystemMessage("组织机构名称不能为空！", false, "var.zzjg_name");
			return INPUT;
		}else if(StringUtils.isEmptyOrNull(var.getZzjg_jc())){
			setSystemMessage("组织机构简称不能为空！", false, "var.zzjg_jc");
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
	
	 
	
	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(var.getZzjg_dm())){
			setSystemMessage("组织机构dm不能为空",false,var.getZzjg_dm());
		}
	}

     /**
      * 初始化组织机构信息
      */
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		var  =  sqlsession.selectOne("getOrgBySwjgDm", var.getZzjg_dm());
		return INITIAL;
	}
	

}
