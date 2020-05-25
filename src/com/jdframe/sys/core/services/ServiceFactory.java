/*
 * 
 */
package com.jdframe.sys.core.services;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.lang3.ClassUtils;
import org.apache.log4j.Logger;
 

//TODO: Auto-generated Javadoc
/**
* The Path : com.jdframe.sys.core.services.ServiceFactory.java
* The class ServiceFactory.
* Last-Modified-Time : 2013-12-19 11:13:29
*
* @author support@jdframe.com
* @see
* @version  2.0.3.0 www.jdframe.com
*/
public class ServiceFactory {
	/** The log. */
	static Logger log = Logger.getLogger(ServiceFactory.class);
	/** The cau. */
	public  String cau;
	
	/**
	 * New instance.
	 *
	 * @return the service factory
	 */
	public static ServiceFactory newInstance(){
		return new ServiceFactory();
	}
	
      /**
       * Builds the.
       *
       * @return the i user service
       * @throws NamingException the naming exception
       * @throws ClassNotFoundException the class not found exception
       * @throws InstantiationException the instantiation exception
       * @throws IllegalAccessException the illegal access exception
       */
      public  IUserService build() throws NamingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		 Context ctx = new InitialContext();
		 Object CAUInterfaceClassName = ctx.lookup("java:comp/env/cau");
		 if(CAUInterfaceClassName!=null && !"".equals(CAUInterfaceClassName.toString().trim())){
             return  (IUserService)ClassUtils.getClass(CAUInterfaceClassName.toString()).newInstance();
		 }else{
			 log.info("Not found the custom user authentication  configuration info In web.xml.");
		 }
         return null;
      }
 
	/**
	 * Gets the cau.
	 *  
	 * @return the cau
	 */
	public   String getCau() {
		return cau;
	}
	
	/**
	 * Sets the cau.
	 *  
	 * @param cau the new cau
	 */
	public   void setCau(String cau) {
		this.cau = cau;
	}
	 
      
}
