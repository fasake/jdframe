package com.jdframe.sys.core.tags;
import com.opensymphony.xwork2.util.ValueStack;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.ArrayList;
import java.util.Stack;
  
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;   

 

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.tags.MsgComponent.java
 * The Class MsgComponent.
 * Last-Modified-Time : 2013-11-8 10:47:46
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class MsgComponent extends Component {   
	 
 	/** The __log. */
 	Logger __log  = Logger.getLogger(MsgComponent.class);
	 
 	/** The msg name. */
 	private String msgName="systemMessage"; //消息变量
	 
 	/** The encoding. */
 	private String encoding="";  //消息编码
     

	/**
	 * Instantiates a new msg component.
	 *
	 * @param arg0 the arg0
	 */
	public MsgComponent(ValueStack arg0) {   
        super(arg0);   
    }   
  
    /* (非 Javadoc)
    * <p>Title: start</p>
    * <p>Description: </p>
    * @param writer
    * @return
    * @see org.apache.struts2.components.Component#start(java.io.Writer)
    */
    @Override  
    public boolean start(Writer writer) {   
        boolean result = super.start(writer);   
        try {   
            StringBuilder __str = new StringBuilder();   
            boolean __isValid = true;   

        	msgName = this.getStack().findValue(msgName)==null?"":new String(this.getStack().findValue(msgName).toString().getBytes(encoding));   
            __isValid = (msgName == null || "".equals(msgName)) ? false : true;   
            
           if (__isValid) {
                
               if (msgName!=null && !"".equals(msgName)) {   
                   if(msgName.startsWith("#javascript:") && msgName.endsWith("#")){
                	   String script = msgName.substring(msgName.indexOf("#javascript:")+1,msgName.length()-1);
                	   __str.append("<script type=\"text/javascript\">"+script+"</script>");
                   }else{
            	       __str.append("<script type=\"text/javascript\">alert(\"系统消息: "+msgName+"\"); </script>");
                   }
                   //show once.
                   msgName = "";
               }
               
               writer.write(__str.toString());   
           }
           
               
        } catch (IOException ex) {   
        	ex.printStackTrace();
            __log.debug(ex.getMessage());
        }   
        return result;   
    }

	/**
	 * Gets the msg name.
	 *
	 * @return the msg name
	 */
	public String getMsgName() {
		return msgName;
	}

	/**
	 * Sets the msg name.
	 *
	 * @param msgName the new msg name
	 */
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	/**
	 * Gets the encoding.
	 *
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets the encoding.
	 *
	 * @param encoding the new encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
 

	
 }  

