package com.jdframe.sys.core.model;

import java.awt.image.BufferStrategy;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.jdframe.sys.dao.model.T_sys_organization;
import com.jdframe.sys.dao.model.T_sys_user;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.User.java
 * The Class User.
 * Last-Modified-Time : 2013-11-8 10:46:46
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class User extends T_sys_user {
	//��֯����
	/** The user's direct organiation. tag could by any of "B" or "J"  */
	private T_sys_organization user_zzjg;
	//�ϼ���֯����
	/** The user's indirect organiation. if not null than tag must is "J"  */
	private T_sys_organization user_zzjg_sj;
	//��ǰ��֯��������
	/** The user_zzjg_name. */
	private String user_zzjg_name;
	//�û��˵�HTML
	/** The user_menu_html. */
	private String user_menu_html;
	//�û���¼IP
	/** The login_remote_ip. */
	private String login_remote_ip;
	//�û���¼PORT
	/** The login_remote_port. */
	private String login_remote_port;
	//�û���¼����ϵͳ�û���
	/** The login_remote_user name. */
	private String login_remote_userName;
	//�û���¼������
	/** The login_remote_host. */
	private String login_remote_host;
	//�û���¼ʱ��
	/** The login_time. */
	private String login_time;
	//�û�����ϵͳ��Ϣ
	/** The login_remore_agent. */
	private String login_remore_agent;
	
	
	
	/**
	 * The user's direct organiation. tag could by any of "B" or "J" .
	 *
	 * @return the user_zzjg
	 */
	public T_sys_organization getUser_zzjg() {
		return user_zzjg;
	}
	
	/**
	 * Sets the user_zzjg.
	 *
	 * @param user_zzjg the new user_zzjg
	 */
	public void setUser_zzjg(T_sys_organization user_zzjg) {
		this.user_zzjg = user_zzjg;
	}
	
	/**
	 * The user's indirect organiation. if not null than tag must is "J" .
	 *
	 * @return the user_zzjg_sj
	 */
	public T_sys_organization getUser_zzjg_sj() {
		return user_zzjg_sj;
	}
	
	/**
	 * Sets the user_zzjg_sj.
	 *
	 * @param user_zzjg_sj the new user_zzjg_sj
	 */
	public void setUser_zzjg_sj(T_sys_organization user_zzjg_sj) {
		this.user_zzjg_sj = user_zzjg_sj;
	}
	
	/**
	 * Gets the user_zzjg_name.
	 *
	 * @return the user_zzjg_name
	 */
	public String getUser_zzjg_name() {
		return user_zzjg_name;
	}
	
	/**
	 * Sets the user_zzjg_name.
	 *
	 * @param user_zzjg_name the new user_zzjg_name
	 */
	public void setUser_zzjg_name(String user_zzjg_name) {
		this.user_zzjg_name = user_zzjg_name;
	}
	
	/**
	 * Gets the user_menu_html.
	 *
	 * @return the user_menu_html
	 */
	public String getUser_menu_html() {
		return user_menu_html;
	}
	
	/**
	 * Sets the user_menu_html.
	 *
	 * @param user_menu_html the new user_menu_html
	 */
	public void setUser_menu_html(String user_menu_html) {
		this.user_menu_html = user_menu_html;
	}
	
	/**
	 * Gets the login_remote_ip.
	 *
	 * @return the login_remote_ip
	 */
	public String getLogin_remote_ip() {
		return login_remote_ip;
	}
	
	/**
	 * Sets the login_remote_ip.
	 *
	 * @param login_remote_ip the new login_remote_ip
	 */
	public void setLogin_remote_ip(String login_remote_ip) {
		this.login_remote_ip = login_remote_ip;
	}
	
	/**
	 * Gets the login_remote_host.
	 *
	 * @return the login_remote_host
	 */
	public String getLogin_remote_host() {
		return login_remote_host;
	}
	
	/**
	 * Sets the login_remote_host.
	 *
	 * @param login_remote_host the new login_remote_host
	 */
	public void setLogin_remote_host(String login_remote_host) {
		this.login_remote_host = login_remote_host;
	}
	
	/**
	 * Gets the login_time.
	 *
	 * @return the login_time
	 */
	public String getLogin_time() {
		return login_time;
	}
	
	/**
	 * Sets the login_time.
	 *
	 * @param login_time the new login_time
	 */
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	
	/**
	 * Gets the login_remote_port.
	 *
	 * @return the login_remote_port
	 */
	public String getLogin_remote_port() {
		return login_remote_port;
	}
	
	/**
	 * Sets the login_remote_port.
	 *
	 * @param login_remote_port the new login_remote_port
	 */
	public void setLogin_remote_port(String login_remote_port) {
		this.login_remote_port = login_remote_port;
	}
	
	/**
	 * Gets the login_remote_user name.
	 *
	 * @return the login_remote_user name
	 */
	public String getLogin_remote_userName() {
		return login_remote_userName;
	}
	
	/**
	 * Sets the login_remote_user name.
	 *
	 * @param login_remote_userName the new login_remote_user name
	 */
	public void setLogin_remote_userName(String login_remote_userName) {
		this.login_remote_userName = login_remote_userName;
	}
	
	/**
	 * Gets the login_remore_agent.
	 *
	 * @return the login_remore_agent
	 */
	public String getLogin_remore_agent() {
		return login_remore_agent;
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param user the user
	 */
	public User(T_sys_user user){
		 this.user_name = user.getUser_name();//�û���
		 this.user_id = user.getUser_id();//�û�ID
		 this.user_dm = user.getUser_dm();//�û�����
		 this.user_pwd = user.getUser_pwd();//�û�����
		 this.user_zzjg_dm = user.getUser_zzjg_dm();//�û����ڵ���֯����ID
		 this.user_desc = user.getUser_desc();//�û�����
		 this.user_tel = user.getUser_tel();//�칫�绰
		 this.user_mobile = user.getUser_mobile();//�ƶ��绰
		 this.user_email = user.getUser_email();//�����ַ
	}
	
	
	
    /**
     * Instantiates a new user.
     */
    public User(){
		
	}
    
    /**
     * Gets the user login info.
     *
     * @param request the request
     * @return the user login info
     */
    public String getUserLoginInfo(HttpServletRequest request){
    	StringBuffer sb = new StringBuffer("");
    	Enumeration<String> ______em =  request.getHeaderNames();
    	while(______em.hasMoreElements()){
    		String header = ______em.nextElement();
    		String headerValue = request.getHeader(header);
    		sb.append("#"+header+"="+headerValue+"\r\t");
    	}
    	______em = null;
    	
    	login_remore_agent =  getLogin_remote_host()+ "["+getLogin_remote_ip()+"] : "+getLogin_remote_port()+"@"+getLogin_remote_userName()+" #"+getLogin_time()+"\r\t "+sb.toString();
    	return login_remore_agent;
    	
    }
  
}
