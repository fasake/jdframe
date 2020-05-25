package com.jdframe.sys.core.services;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.ws.*;

import java.io.File;

 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.services.CommonWS.java
 * The   CommonWS
 * Last-Modified-Time : 2014-1-22 10:39:07
 *
 * @author support@jdframe.com
 * @version  2.0.3.1
 *  http://www.jdframe.com
 * @see 
 */
public abstract class CommonWS {
	
	/** The endpoint. */
	protected String endpoint = "";
    
	CommonWS(String endpoint){
		this.endpoint = endpoint;
	}
 
	/**
	 * Generate stub.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	protected void generateStub() throws FileNotFoundException{
		generateStub(null,null);
	}
	
	/**
	 * Generate stub.
	 *
	 * @param javaFileResourcePath the java file resource path
	 * @param dir the dir
	 * @throws FileNotFoundException the file not found exception
	 */
	protected void generateStub(String javaFileResourcePath ,File dir) throws FileNotFoundException{
		if(javaFileResourcePath ==null || "".equals(javaFileResourcePath)){
			String classCanonicalName = this.getClass().getCanonicalName();
			javaFileResourcePath =   classCanonicalName.replaceAll("\\.", File.separator)+".java";
		}
		
		if(dir ==null || "".equals(dir)){
			String javaBasePath = System.getProperty("user.dir")+File.separator+"src";
			dir = new File(javaBasePath);
			if(!dir.exists()){
				throw new java.io.FileNotFoundException();
			}
		}
		try {
			 Runtime.getRuntime().exec("apt -nocompile "+ javaFileResourcePath, null, dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * run.
	 *
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	protected void run() throws InstantiationException, IllegalAccessException{
		Endpoint.publish(endpoint, getClass().newInstance());
		//Endpoint.create(bindingId, implementor)
	}
	
	/**
	 * Generate client.
	 *
	 * @param wsdl the wsdl
	 */
	public void generateClient(String wsdl){
		try {
			 Runtime.getRuntime().exec("wsimport -p client -keep "+ wsdl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		   /**
		    * 1. exec generateStub
		    * 2. exec run
		    *  
		    */
		 
			//generation stub
			//Process p_apt = Runtime.getRuntime().exec("apt -nocompile "+ javaPath, null, base);
		
			//enable webservice
			//Process p_java = Runtime.getRuntime().exec("java "+ classCanonicalName, null, base);
		    //in main method : Endpoint.publish(endpoint, getClass().newInstance());
		
		    //generation client
			//Runtime.getRuntime().exec("wsgen -cp . "+webs.getClass().getCanonicalName());
		
			//vista the web service..
		    //	Endpoint.publish("http://127.0.0.1:7001/myservice", webs);
		 
	}

	/**
	 * Gets the endpoint.
	 *
	 * @return the endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * Sets the endpoint.
	 *
	 * @param endpoint the new endpoint
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	
}
