package work.services;

import com.jdframe.sys.core.util.JvmUtils;

// TODO: Auto-generated Javadoc
/**
 * The Path : work.services.DwrImp.java
 * The   DwrImp
 * Last-Modified-Time : 2014-2-19 9:22:56
 *
 * @author support@jdframe.com
 * @version  2.0.3.1
 *  http://www.jdframe.com
 * @see 
 */
public class DwrImp {
     
     /**
      * Hc memory.
      *
      * @return the string
      */
     public static String hcMemory(){
    	 String s = "";
    	 long[] l = JvmUtils.hc_memory();
    	 for (int i = 0; i < l.length; i++) {
			s += l[i]+",";
		}
    	if(s.endsWith(",")){
    		s = s.substring(0,s.length()-1);
    	}
    	 return s;
     }
     
     /**
      * Hc thread.
      *
      * @return the string
      */
     public static String hcThread(){
    	 String s = "";
    	 long[] l = JvmUtils.hc_thread();
    	 for (int i = 0; i < l.length; i++) {
			s += l[i]+",";
		}
    	if(s.endsWith(",")){
    		s = s.substring(0,s.length()-1);
    	}
    	 return s;
     }
     
     public static void main(String[] args){
    	 System.out.println(hcThread());
     }
}
