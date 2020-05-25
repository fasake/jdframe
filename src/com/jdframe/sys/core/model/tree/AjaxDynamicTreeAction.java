package com.jdframe.sys.core.model.tree;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.model.tree.Category;
 
 
public abstract class AjaxDynamicTreeAction  extends JdframeAction {
	//default value
	/** The node id. */
	protected String nodeId = null;
	//for ftl
    /** The category. */
	public Category category;
	
	/* (·Ç Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected abstract String perform();
	
	/**
	 * Select tree node.
	 *
	 * @return the string
	 */
	public abstract String selectTreeNode() ;

	/* (·Ç Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected abstract void validators() ;

	/* (·Ç Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected abstract String initial()  ;
	


    /**
     * Gets the category.
     *
     * @return the category
     */
    public Category getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	 
    
    public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	/**
     * Gets the node name.
     *
     * @return the node name
     */
    public String getNodeName() {
        return category != null ? category.getName() : "Node not found";
    }

 

}
