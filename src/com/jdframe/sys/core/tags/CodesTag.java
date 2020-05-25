package com.jdframe.sys.core.tags;

import com.opensymphony.xwork2.util.ValueStack;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
import org.apache.struts2.components.Component;   
import org.apache.struts2.views.jsp.ComponentTagSupport;   
 


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.tags.CodesTag.java
 * The Class CodesTag.
 * Last-Modified-Time : 2013-11-8 10:47:50
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class CodesTag extends ComponentTagSupport {   
   
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 7524794124556465345L;
	
	/** The code no. */
	private String codeNo=""; //代码编号
    
    /** The code type. */
    private String codeType=""; //代码类型

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
        return new CodesComponent(arg0); //返回Code Component   
    }   
  
    //获得参数   
    /* (非 Javadoc)
    * <p>Title: populateParams</p>
    * <p>Description: </p>
    * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
    */
    protected void populateParams() {   
        super.populateParams();     
        CodesComponent __codes = (CodesComponent)component;   
        __codes.setCodeNo(codeNo);
        __codes.setCodeType(codeType);
    }

	/**
	 * Gets the code no.
	 *
	 * @return the code no
	 */
	public String getCodeNo() {
		return codeNo;
	}

	/**
	 * Sets the code no.
	 *
	 * @param codeNo the new code no
	 */
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
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

	 
 }  