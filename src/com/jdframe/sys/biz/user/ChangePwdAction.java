package com.jdframe.sys.biz.user;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.util.ByteUtils;
import com.jdframe.sys.dao.model.T_sys_user;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.user.UserChangePwdAction.java
 * The Class UserChangePwdAction.
 * Last-Modified-Time : 2013-11-8 10:45:27
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class ChangePwdAction extends Action {

	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		
		if ( getPassword()==null || getPassword().length() < 6) {
			setSystemMessage("密码长度必须大于6位！",true,null);
			return null;
		}
		if (!getPassword().equals(getPassword_comfirm())) {
			setSystemMessage("密码不匹配,请重新输入！",true,null);
			return null;
		}
		String old_pwd = var.getUser_pwd();
		var.setUser_pwd(ByteUtils.sha512Hex(old_pwd));
		T_sys_user tmp =  sqlsession.selectOne("getUserByDmAndPass", var);
		if(tmp != null){
			var.setUser_pwd(ByteUtils.sha512Hex(getPassword()));
			int i = sqlsession.update("updateUser", tmp);
			if(i>0){
				var = null;
				var = new T_sys_user();
				var.setUser_zzjg_dm(tmp.getUser_zzjg_dm());
				tmp = null;
				setSystemMessage("#javascript:alert('用户密码更新成功！');window.close();#");
			}else{
				setSystemMessage("用户密码更新失败!");
				return INPUT;
			}
		}else{
			//var.setUser_pwd(old_pwd);
			setSystemMessage("用户密码更新失败,原密码不正确!",true,null);
			return INPUT;
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
		
	}

	/* (非 Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		T_sys_user user = (T_sys_user) sqlsession.selectOne("getUserByUserId", var.getUser_id());
		if(user != null){
			user.setUser_pwd("");
            var=user;
		}else{
			setSystemMessage("初始化用户失败！",true,null);
		}
		return INITIAL;
	}

 
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//密码修改
	/** The password_comfirm. */
	public String password;
	
	/** The password_comfirm. */
	public String password_comfirm;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Gets the password_comfirm.
	 *
	 * @return the password_comfirm
	 */
	public String getPassword_comfirm() {
		return password_comfirm;
	}


	/**
	 * Sets the password_comfirm.
	 *
	 * @param password_comfirm the new password_comfirm
	 */
	public void setPassword_comfirm(String password_comfirm) {
		this.password_comfirm = password_comfirm;
	}
	
	
}
