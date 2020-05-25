package com.jdframe.sys.core.model.tree;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.Category.java
 * The Class Category.
 * Last-Modified-Time : 2013-12-25 21:32:41
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public abstract class Category {

	/** The id. */
	protected String id;
	
	/** The name. */
	protected String name;
	
	/** The children. */
	protected List children;
	
	/** The cat map. */
	public Category(){}
	 /**
	  * 
	 * Title:  getById
	 * Description: TODO(���ذ����¼��ڵ��������ʼ����չ���ڵ�ʱִ�У�һ�������idΪΪ��ǰѡ�еĽڵ�)
	 * @param      
	 * @return  Category  
	 *
	  */
	public  abstract Category getById(String id);
	/**
	 * 
	* Title:  getRootById
	* Description: TODO(���ذ�����ǰ�ڵ��������ʼ��ʱִ�У�һ�������idΪ��)
	* @param      
	* @return  Category  
	*
	 */
	public  abstract Category getRootById(String id);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public List getChildren() {
		return children;
	}

	/**
	 * Sets the children.
	 *
	 * @param children the new children
	 */
	public void setChildren(List children) {
		this.children = children;
	}

	 

}
