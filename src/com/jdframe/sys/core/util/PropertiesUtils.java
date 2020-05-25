package com.jdframe.sys.core.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.util.PropertiesUtils.java
 * The Class PropertiesUtils.
 * Last-Modified-Time : 2013-11-8 10:48:46
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class PropertiesUtils {

	/**
	 * Load.
	 *
	 * @param properties the properties
	 * @return the map
	 */
	public static Map<String,String> load(String properties)
	  {
	    Map<String,String> propsMap = new HashMap();
	    ResourceBundle bundle = null;
	    try {
	      bundle = ResourceBundle.getBundle(properties);
	      if (bundle != null) {
	        Enumeration enumeration = bundle.getKeys();
	        while (enumeration.hasMoreElements()) {
	          String key = (String)enumeration.nextElement();
	          propsMap.put(key, bundle.getString(key));
	        }
	      }
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    return propsMap;
	  }

	  /**
  	 * The main method.
  	 *
  	 * @param args the arguments
  	 */
  	public static void main(String[] args) {
	    Map map = load("dbconfig");
	    System.out.println(map.get("drivers"));
	  }

}
