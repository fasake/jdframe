package com.jdframe.sys.core.tags;

import com.opensymphony.xwork2.util.ValueStack;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
import org.apache.struts2.components.Component;   
import org.apache.struts2.views.jsp.ComponentTagSupport;   


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.tags.MsgTag.java
 * The Class MsgTag.
 * Last-Modified-Time : 2013-11-8 10:47:41
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class MsgTag extends ComponentTagSupport {   
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -4746958490479506679L;
	
	/** The msg name. */
	private String msgName="systemMessage"; //信息变量
    
    /** The encoding. */
    private String encoding="GBK"; //信息编码

	/* (非 Javadoc)
	* <p>Title: getBean</p>
	* <p>Description: </p>
	* @param arg0
	* @param arg1
	* @param arg2
	* @return
	* @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	@Override  
    public Component getBean(ValueStack arg0, HttpServletRequest arg1, HttpServletResponse arg2) {   
        return new MsgComponent(arg0); 
    }   
  
    //获得参数   
    /* (非 Javadoc)
    * <p>Title: populateParams</p>
    * <p>Description: </p>
    * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
    */
    protected void populateParams() {   
        super.populateParams();     
        MsgComponent __msg = (MsgComponent)component;
        __msg.setEncoding(encoding);
        __msg.setMsgName(msgName);
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

	   
    
    
 }  