package com.jdframe.sys.biz.menu;

import com.jdframe.sys.core.model.User;
import com.jdframe.sys.core.model.tree.AjaxDynamicTreeAction;
 
// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.ShowAjaxDynamicTreeAction.java
 * The Class ShowAjaxDynamicTreeAction.
 * Last-Modified-Time : 2013-12-25 21:32:29
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class DynamicTreeAction  extends AjaxDynamicTreeAction {
	
	/* (·Ç Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		//System.out.println(OrgCategory.catMap.keySet().size());
		CategoryImpl cat = new CategoryImpl();
		if(nodeId == null ){
			category = cat.getRootById(null);
		}else{
			category = cat.getById(nodeId);
		}
		
		return SUCCESS;
	}
	
	/**
	 * Select tree node.
	 *
	 * @return the string
	 */
	public String selectTreeNode() {
		// TODO Auto-generated method stub
		//category = OrgCategory.getInstance().getById(nodeId);
		CategoryImpl cat = new CategoryImpl();
		category = cat.getById(nodeId);
		return SUCCESS;
	}

	/* (·Ç Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		
	}

	/* (·Ç Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return null;
	}

}
