package com.jdframe.sys.biz.login;

import java.util.*;



import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.model.User;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.services.IUserService;
import com.jdframe.sys.core.services.ServiceFactory;
import com.jdframe.sys.core.util.ByteUtils;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_user;

 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.login.LoginAction.java
 * The Class LoginAction.
 * Last-Modified-Time : 2013-11-8 10:41:48
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class LoginAction extends JdframeAction {
	    //页面提交的表单信息
		/** The user. */
	    public User user;
		//注册验证码
	    /** The veri code. */
		public String veriCode;
	    
		/**
		 * Gets the veri code.
		 *
		 * @return the veri code
		 */
		public String getVeriCode() {
			return veriCode;
		}

		/**
		 * Sets the veri code.
		 *
		 * @param veriCode the new veri code
		 */
		public void setVeriCode(String veriCode) {
			this.veriCode = veriCode;
		}

	    /**
    	 * Gets the user.
    	 *
    	 * @return the user
    	 */
    	public User getUser() {
			return user;
		}

		/**
		 * Sets the user.
		 *
		 * @param user the new user
		 */
		public void setUser(User user) {
			this.user = user;
		}

	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		 T_sys_user t_user = new T_sys_user();
		 user.setUser_pwd(ByteUtils.sha512Hex(user.getUser_pwd()));
		 t_user =  sqlsession.selectOne("getUserByDmAndPass", user);
		 if(t_user==null){
			 log.info("User Login Failed");
			 this.setSystemMessage( "用户名或密码不正确，请重新登录！");
			 user.setUser_pwd("");
			 recodeLogToDB("Login", user.getUser_dm()+"@登录失败！");
			 return INPUT;
		 }else{
			 //初始化用户信息
			 user = new User(t_user);
			 user.setLogin_time(DateUtils.newDateTime());
			 user.setLogin_remote_host(getRequest().getRemoteAddr());
			 user.setLogin_remote_ip(getRequest().getRemoteHost());
			 user.setLogin_remote_port(String.valueOf(getRequest().getRemotePort()));
			 user.setLogin_remote_userName(getRequest().getRemoteUser());
			 String userInfo = user.getUserLoginInfo(getRequest());
			 //登录成功
			 UserProfile profile = new UserProfile(user);
			 log.debug(user.getLogin_remore_agent());
			 //保存用户登录信息到回话中
			 log.info("<User ("+user.getUser_dm()+":"+user.getUser_name()+") Login Completed!>");
			 
			 getSession(true).setAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE, profile);
			 log.debug("USER_PROFILE:: "+com.jdframe.sys.core.model.Tokens._USER_PROFILE);
			 log.debug("SAVE USERPROFILE:: "+ (getSession(true).getAttribute("com.jdframe.sys.core.model.Tokens.USER_PROFILE")==null));
			 recodeLogToDB("Login", user.getLogin_remore_agent());
			 //do init custom user data
			 try{
				 
				 IUserService service = ServiceFactory.newInstance().build();
				 service.doService(this.getRequest(), this.getResponse());
				 log.info("<Call Costom User's Service Interface Completed!>");
			 }catch(Exception e){
				 log.info("Call Custom User's Service Interface is Failed!");
				 log.error("System invoke user's service interface, Error"+e);
			 }
			 return SUCCESS;
		 }
	}

	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		String s_veriCode  =  ValidateUtils.sNull(getRequest().getSession().getAttribute("veriCode"));
		if(ValidateUtils.isNullOrEmpty(user.getUser_dm())){
			this.setSystemMessage("登录名称不能为空，请重新登录！",  false, "nsrxx.dlxx");
			return;
		}else if(ValidateUtils.isNullOrEmpty(user.getUser_pwd())){
			this.setSystemMessage("登录密码不能为空，请重新登录！",  false, "nsrxx.dlxx");
			return;
		}else if(!s_veriCode.equalsIgnoreCase(veriCode)){
			this.setSystemMessage("验证码不正确，请重新输入！",  false, "nsrxx.dlxx");
			return;
		}
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
		return null;
	}
	
}
