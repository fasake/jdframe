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
	 * Description: TODO(返回包含下级节点的树，初始化后展开节点时执行，一般情况下id为为当前选中的节点)
	 * @param      
	 * @return  Category  
	 *
	  */
	public  abstract Category getById(String id);
	/**
	 * 
	* Title:  getRootById
	* Description: TODO(返回包含当前节点的树，初始化时执行，一般情况下id为空)
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
