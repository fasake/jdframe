package com.jdframe.sys.core.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.dao.model.T_sys_code;

// TODO: Auto-generated Javadoc
 
/**
 * The Path : com.jdframe.sys.core.db.CodesCache.java
 * The   CodesCache
 * Last-Modified-Time : 2014-1-22 11:57:00
 *
 * @author support@jdframe.com
 * @version  2.0.3.1
 *  http://www.jdframe.com
 * @see 
 */
public class CodesCache {
	
	/** The _log. */
	static Logger _log = Logger.getLogger("sys.core.db.CodesCache");
	
	/** The __cache. */
	private static ArrayList<T_sys_code> __cache = new ArrayList();
	
	static{
		_log.debug("Start the cache system code...");
		initSysCodeCache();
		java.util.Timer __timer = new java.util.Timer() ;
		//refresh system code per one hour
		__timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				initSysCodeCache();
				_log.debug("Refresh the cache system code...");
				if(__cache.size()==0){
					_log.debug("System code not found!");
					System.exit(0);
				}
			}
		},10*60*1000, 1*60*60*1000);
		
	}
	
	 
	/**
	 * Inits the sys code cache.
	 */
	public static void initSysCodeCache(){
		SqlSession __ss = DbUtils.builder().openSession();
	    try{
	    	__cache = (ArrayList) __ss.selectList("getCachedCodes");
	    	_log.debug("Refresh the cache system code finished , "+__cache.size());
	    }finally{
	    	__ss.close();
	    }
	}
	
	 
	/**
	 * Find code.
	 *
	 * @param codeNo the code no
	 * @param codeType the code type
	 * @return the t_sys_code
	 */
	public static T_sys_code findCode(String codeNo,String codeType){
		T_sys_code __code = new T_sys_code();
		__code.setCode_no(codeNo);
		__code.setCode_type(codeType);
		for (T_sys_code mycode : __cache) {
			if(mycode.equals(__code)){
				return mycode;
			}
		}
		return null;
		
	}
	
	/**
	 * Find code.
	 *
	 * @param prefix the prefix
	 * @param suffix the suffix
	 * @param codeType the code type
	 * @return the java.util. list
	 */
	public static java.util.List findCode(String prefix,String suffix,String codeType){
		
		java.util.List l  = new ArrayList();
		if(codeType == null || codeType.equals("")){
			return l;
		}
		
		for (T_sys_code c : __cache) {
			
			if(c.getCode_type().equals(codeType)){
				  
				 if(prefix != null && c.getCode_no().startsWith(prefix)){
					 l.add(c);
				 }else if (suffix !=null && c.getCode_no().endsWith(suffix)){
					 l.add(c);
				 } else{
					 l.add(c);
				 }
				 
			}
		}
		return l;
		
	}
	 
	/**
	 * Find code.
	 *
	 * @param codeType the code type
	 * @return the hash map
	 */
	public static HashMap findCode(String codeType){
		HashMap<String,String> codes = new HashMap<String,String>();
		for (T_sys_code mycode : __cache) {
			if(mycode.getCode_type().equals(codeType)){
				codes.put(mycode.getCode_no(),mycode.getCode_name());
			}
		}
		return codes;
		
	}
	
	
 
}
