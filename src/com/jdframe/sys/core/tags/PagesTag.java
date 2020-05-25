package com.jdframe.sys.core.tags;

import com.opensymphony.xwork2.util.ValueStack;   
import javax.servlet.http.HttpServletRequest;   
import javax.servlet.http.HttpServletResponse;   
import org.apache.struts2.components.Component;   
import org.apache.struts2.views.jsp.ComponentTagSupport;   
 


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.tags.PagesTag.java
 * The Class PagesTag.
 * Last-Modified-Time : 2013-11-8 10:47:33
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class PagesTag extends ComponentTagSupport {   
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -4746958490279506679L;
    
    /** The page size. */
    private String pageSize="10"; //每页多少条记录
    
    /** The form. */
    private String form="0"; //表单名称，默认第一个表单

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
        return new PagesComponent(arg0); //返回Pages Component，分页的逻辑处理都在这个Component中   
    }   
  
    //获得参数   
    /* (非 Javadoc)
    * <p>Title: populateParams</p>
    * <p>Description: </p>
    * @see org.apache.struts2.views.jsp.ComponentTagSupport#populateParams()
    */
    protected void populateParams() {   
        super.populateParams();     
        PagesComponent __pages = (PagesComponent)component;   
        __pages.setPageSize(pageSize);
        __pages.setForm(form);
    }

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public String getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the form.
	 *
	 * @return the form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * Sets the form.
	 *
	 * @param form the new form
	 */
	public void setForm(String form) {
		this.form = form;
	}   
    
    
 }  