package com.jdframe.sys.core.tags;

import com.opensymphony.xwork2.util.ValueStack;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
import org.apache.struts2.components.Component;   
import org.apache.struts2.views.jsp.ComponentTagSupport;   
 


// TODO: Auto-generated Javadoc
 
/**
 * The Path : com.jdframe.sys.core.tags.SelectCodesTag.java
 * The   SelectCodesTag
 * Last-Modified-Time : 2014-2-17 10:02:15
 *
 * @author support@jdframe.com
 * @version  2.0.3.1
 *  http://www.jdframe.com
 * @see 
 */
public class SelectCodesTag extends ComponentTagSupport {   
   
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 7524794124556465345L;
	
	/** The code no. */
	private String suffix=""; //代码后缀
	
	/** The prefix code. */
	private String prefix=""; //代码前缀
    
    /** The code type. */
    private String codeType=""; //代码类型
 
    private String name;//HTML 组件名称

	/* (非 Javadoc)
	* <p>Title: getBean</p>
	* <p>Description: </p>
	* @param arg0
	* @param arg1
	* @param arg2
	* @return
	* @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override  
    public Component getBean(ValueStack arg0, HttpServletRequest arg1, HttpServletResponse arg2) {   
        return new SelectCodesComponent(arg0); //返回Code Component   
    }   
  
    //获得参数   
    /* (非 Javadoc)
    * <p>Title: populateParams</p>
    * <p>Description: </p>
    * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
    */
    /* (non-Javadoc)
     * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
     */
    protected void populateParams() {   
        super.populateParams();     
        SelectCodesComponent __codes = (SelectCodesComponent)component;   
        __codes.setCodeType(codeType);
        __codes.setPrefix(prefix);
        __codes.setPrefix(prefix);
        __codes.setName(name);
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