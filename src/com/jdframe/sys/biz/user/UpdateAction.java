package com.jdframe.sys.biz.user;


import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.ByteUtils;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_user;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.user.UserUpdateAction.java
 * The Class UserUpdateAction.
 * Last-Modified-Time : 2013-11-8 10:45:18
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1874224702642474771L;
	
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.IframeAction#perform()
	*/
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
		var.setUser_pwd(null);
		int i = sqlsession.update("updateUser", var);
		if(i>0){
			String user_zzjg_dm = var.getUser_zzjg_dm();
			var = null;
			var = new T_sys_user();
			var.setUser_zzjg_dm(user_zzjg_dm);
			setSystemMessage("Update Item Success!");
		}else{
			setSystemMessage("Update Item Failed!");
		}
		return SUCCESS;
	}
	
	
	 

	
	
	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.IframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_id())){
			setSystemMessage("用户ID不能为空！", true, "var.user_id");
		}
        
	}

 
	/* (非 Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.IframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		var =  sqlsession.selectOne("getUserByUserId", var.getUser_id());
		return INITIAL;
	}
	
	 
	
	 
	
}
