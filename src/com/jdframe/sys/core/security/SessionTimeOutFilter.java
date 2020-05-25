package com.jdframe.sys.core.security;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.jdframe.sys.core.model.Tokens;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.dao.model.T_sys_user;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.security.SessionTimeOutFilter.java
 * The Class SessionTimeOutFilter.
 * Last-Modified-Time : 2013-11-8 10:47:16
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class SessionTimeOutFilter  implements Filter {
	
	/** The log. */
	protected Logger __log = Logger.getLogger(getClass());
	
	/** The login page. */
	private String __initPar_loginPage=""; 
	
	/** The exclude path. */
	private String __initPar_excludePath="";
	
	/** The enable. */
	private String __initPar_enable="";
	
	/* (非 Javadoc)
	* <p>Title: destroy</p>
	* <p>Description: </p>
	* @see javax.servlet.Filter#destroy()
	*/
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	

	/* (非 Javadoc)
	* <p>Title: doFilter</p>
	* <p>Description: </p>
	* @param arg0
	* @param arg1
	* @param arg2
	* @throws IOException
	* @throws ServletException
	* @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	*/
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(doCheck(arg0, arg1, arg2)){
		  arg2.doFilter(arg0, arg1);
		}
	}



	/**
	 * Do check.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @param arg2 the arg2
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public boolean doCheck(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		if(__initPar_enable.equalsIgnoreCase("true")){
		HttpServletRequest httpServletRequest=(HttpServletRequest)arg0;
		   String __url=httpServletRequest.getServletPath();
			   //过滤排除的URL
			   boolean __iscontinues = true;
               StringTokenizer __stoken = new StringTokenizer(__initPar_excludePath,",");
               while (__stoken.hasMoreElements()) {
				Object __$object = (Object) __stoken.nextElement();
				if(__$object!=null){
					if(__url.indexOf(__$object.toString().trim())>=0){
						__log.debug("Exclusive Path ["+__url+"]. Continue..");
						return true;
						 
					}
				}
				__$object = null;
			   }
               __stoken = null;
               //	进行验证
               if(__iscontinues){
			    HttpSession __session = httpServletRequest.getSession(true);
			    //判断用户session是否过期或是否登录
			         if (__session!= null&&__session.getAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE)!=null){
			        	  UserProfile __loginUser = (UserProfile) __session.getAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE);
			        	  if(__loginUser.getUser() != null){ 
			        		__log.debug("operator code:"+__loginUser.getUser().getUser_dm()+ " requestUrl："+httpServletRequest.getServletPath()+"?"+httpServletRequest.getQueryString());
			       		    __log.debug("operator code:"+__loginUser.getUser().getUser_dm()+ " requestUrl："+httpServletRequest.getParameterMap());
			       		     return true;
			        	  }else{
			        		  __log.error("Illegal Access, Will Jump To The Login Page!");
			        		  //转向登录页面
			        		  HttpServletResponse httpServletResponse=(HttpServletResponse)arg1;
			        		  httpServletResponse.sendRedirect(__initPar_loginPage);
			        		  return false;
			        	  }
//			        	  __loginUser = null;
			         } else {
					         //转向登录页面
			        	 __log.error("<The Session Has Been Expired,Please Login Again!>");
			        	 HttpServletResponse httpServletResponse=(HttpServletResponse)arg1;
		        		 httpServletResponse.sendRedirect(__initPar_loginPage);
		        		 return false;
			         }
               }
		       
               
		}else{
			return true;
		}
		return false;
	}

	/* (非 Javadoc)
	* <p>Title: init</p>
	* <p>Description: </p>
	* @param arg0
	* @throws ServletException
	* @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	*/
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		__initPar_enable=arg0.getInitParameter("enable");
		__initPar_loginPage=arg0.getInitParameter("loginPage");
		__initPar_excludePath = arg0.getInitParameter("excludePath");
		if(__initPar_loginPage==null || "".equals(__initPar_loginPage)){
			__initPar_loginPage= "/login.jsp";
		}
		

	}



	public String get__initPar_loginPage() {
		return __initPar_loginPage;
	}
	
}
