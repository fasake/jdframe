package com.jdframe.sys.core.tags;
import com.opensymphony.xwork2.util.ValueStack;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.ArrayList;
import java.util.Stack;
  
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;   

import com.jdframe.sys.core.util.ValidateUtils;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.tags.PagesComponent.java
 * The Class PagesComponent.
 * Last-Modified-Time : 2013-11-8 10:47:37
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class PagesComponent extends Component {   
	 
 	/** The __log. */
 	Logger __log  = Logger.getLogger(PagesComponent.class);
	 
 	/** The page no. */
 	private String pageNo="0";  //��ǰҳ��
	 
 	/** The page count. */
 	private String pageCount="0";  //��ҳ��   
	 
 	/** The page size. */
 	private String pageSize="10"; //ÿҳ��������¼
	 
 	/** The form. */
 	private String form="0"; //�����ƣ�Ĭ�ϵ�һ����
     

	/**
	 * Instantiates a new pages component.
	 *
	 * @param arg0 the arg0
	 */
	public PagesComponent(ValueStack arg0) {   
        super(arg0);   
    }   
  
    /* (�� Javadoc)
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

           if (__isValid) {   
                   pageNo = (String)this.getStack().findValue("pageNo");   
                   __isValid = pageNo == null ? false : true;   
           }   
           if (__isValid) {   
        	   pageCount = (String)this.getStack().findValue("pageCount");   
          } 
           
           if (__isValid) {
               Integer pageNoInt = Integer.valueOf(pageNo); 
           //֧��ͬһҳ���ϵĶ����ҳ
           if(form==null || "".equals(form)){
        	   form = "0";
           }else if(!ValidateUtils.isNumer(form)){
        	   form= "'"+form+"'";
           }
               
               //����ǽ���ҳ�����������
               if ("1".equals(pageCount) || "0".equals(pageCount)) {   
                   //���total = 1���������ҳ����ʾ��[��1ҳ] [��1ҳ]��   
                	 __str.append("<input type='hidden' name='pageNo' value='1'/>");
              	     __str.append("<input type='hidden' name='pageSize' value='"+pageSize+"'/>");
              	     __str.append("<a href=\"javascript:void();\" disabled =\"true\">[��ҳ]</a>&nbsp;&nbsp;");
              	     __str.append("<a href=\"javascript:void();\" disabled =\"true\">[��һҳ]</a>&nbsp;&nbsp;");
              	     __str.append("<a href=\"javascript:void();\" disabled =\"true\">[��һҳ]</a>&nbsp;&nbsp;");
              	     __str.append("<a href=\"javascript:void();\" disabled =\"true\">[ĩҳ]</a>&nbsp;&nbsp;");
                     
                }else if(pageNo.equals(pageCount)){
                 //�����һҳ	
                	 __str.append("<input type='hidden' name='pageNo' value='1'/>");
	           	     __str.append("<input type='hidden' name='pageSize' value='"+pageSize+"'/>");
	           	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='1';document.forms["+form+"].submit();\">[��ҳ]</a>&nbsp;&nbsp;");
	           	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+(pageNoInt-1)+"';document.forms["+form+"].submit();\"  >[��һҳ]</a>&nbsp;&nbsp;");
	           	     __str.append("<a href=\"javascript:void();\" disabled =true>[��һҳ]</a>&nbsp;&nbsp;");
	           	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+pageCount+"';document.forms["+form+"].submit();\">[ĩҳ]</a>&nbsp;&nbsp;");
                } else { 
                    //��ǰҳ����ҳ������ͬ   
                    if ("1".equals(pageNo)) {   
                        //��һҳ����ʾ��[��ҳ] [��һҳ] [ĩҳ]��   
                    	
                    	 __str.append("<input type='hidden' name='pageNo' value='1'/>");
                	     __str.append("<input type='hidden' name='pageSize' value='"+pageSize+"'/>");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='1';document.forms["+form+"].submit();\">[��ҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:void();\" disabled =true >[��һҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+(pageNoInt+1)+"';document.forms["+form+"].submit();\">[��һҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+pageCount+"';document.forms["+form+"].submit();\">[ĩҳ]</a>&nbsp;&nbsp;");
                    } else {   
                        //���ǵ�һҳ����ʾ��[��ҳ] [��һҳ] [��һҳ] [ĩҳ]��   
                    	
                    	 __str.append("<input type='hidden' name='pageNo'/>");
                	     __str.append("<input type='hidden' name='pageSize' value='"+pageSize+"'/>");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='1';document.forms["+form+"].submit();\">[��ҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+(pageNoInt-1)+"';document.forms["+form+"].submit();\">[��һҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+(pageNoInt+1)+"';document.forms["+form+"].submit();\">[��һҳ]</a>&nbsp;&nbsp;");
                	     __str.append("<a href=\"javascript:document.getElementsByName('pageNo')[0].value='"+pageCount+"';document.forms["+form+"].submit();\">[ĩҳ]</a>&nbsp;&nbsp;");
                    }   
                }   
               __str.append("[��ǰ��  " + pageNo + " ҳ  �� "+pageCount+" ҳ]");     
            }else{
            	 
            	__str.append("<input type='hidden' name='pageNo' value='1'/>");
       	        __str.append("<input type='hidden' name='pageSize' value='"+pageSize+"'/>");
            }
           
            writer.write(__str.toString());   
               
        } catch (IOException ex) {   
        	ex.printStackTrace();
            __log.debug(ex.getMessage());
        }   
        return result;   
    }
 
	/**
	 * Gets the page no.
	 *
	 * @return the page no
	 */
	public String getPageNo() {
		return pageNo;
	}

	/**
	 * Sets the page no.
	 *
	 * @param pageNo the new page no
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * Gets the page count.
	 *
	 * @return the page count
	 */
	public String getPageCount() {
		return pageCount;
	}

	/**
	 * Sets the page count.
	 *
	 * @param pageCount the new page count
	 */
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
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

