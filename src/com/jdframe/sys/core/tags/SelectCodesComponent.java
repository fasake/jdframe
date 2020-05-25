package com.jdframe.sys.core.tags;
import com.opensymphony.xwork2.util.ValueStack;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
  
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;   

import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.dao.model.T_sys_code;
 

 // TODO: Auto-generated Javadoc
 
/**
  * The Path : com.jdframe.sys.core.tags.SelectCodesComponent.java
  * The   SelectCodesComponent
  * Last-Modified-Time : 2014-2-17 10:02:06
  *
  * @author support@jdframe.com
  * @version  2.0.3.1
  *  http://www.jdframe.com
  * @see 
  */
 public class SelectCodesComponent extends Component {  
	 
	 /** The log. */
 	Logger log  = Logger.getLogger(SelectCodesComponent.class);
	 /** The code no. */
		private String suffix=""; //代码后缀
		
		/** The prefix code. */
		private String prefix=""; //代码前缀
	    
	    /** The code type. */
	    private String codeType=""; //代码类型
	    
	    private String name;//HTML 组件名称

	/**
	 * Instantiates a new codes component.
	 *
	 * @param arg0 the arg0
	 */
	public SelectCodesComponent(ValueStack arg0) {   
        super(arg0);   
    }   
  
    /* (non-Javadoc)
     * @see org.apache.struts2.components.Component#start(java.io.Writer)
     */
    @Override  
    public boolean start(Writer writer) {   
        boolean __result = super.start(writer);  
        try {   
            String __str = "";   
            
            String __prefix = (String)this.getStack().findValue(this.prefix);   
            if(__prefix!=null && !__prefix.equals("") ){
            	this.prefix = __prefix;
            }
            
            String __suffix = (String)this.getStack().findValue(this.suffix);   
            if(__suffix!=null && !__suffix.equals("") ){
            	this.suffix = __suffix;
            }
            java.util.List  __lst = CodesCache.findCode(__prefix,__suffix,codeType);
            
            String __name = (String)this.getStack().findValue(this.name);  
            
            StringBuffer sb = new StringBuffer("");
            if(__lst != null){
            	 for (Iterator iterator = __lst.iterator(); iterator.hasNext();) {
					T_sys_code c = (T_sys_code) iterator.next();
					if(__name != null && c.getCode_no().equals(__name)){
						sb.append("<option value=\"").append(c.getCode_no()).append("\" selected>");
					}else{
						sb.append("<option value=\"").append(c.getCode_no()).append("\">");
					}
					
					
					sb.append(c.getCode_name()).append("</option>");
					
				}
            }
            if(sb.toString().endsWith(",")){
            	sb.setLength(sb.length()-1);
            }
            
            writer.write("<select  name = \""+this.name+"\">"+sb.toString()+"</select>");   
        } catch (IOException ex) {   
        	ex.printStackTrace();
            log.debug(ex.getMessage());
        }   
        return __result;   
    }

	 
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Gets the code type.
	 *
	 * @return the code type
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * Sets the code type.
	 *
	 * @param codeType the new code type
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	
 }  

