package com.jdframe.sys.biz.org;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_organization;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.org.OrganizationQueryAction.java
 * The Class OrganizationQueryAction.
 * Last-Modified-Time : 2013-11-8 10:43:12
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class QueryAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 8181675709525823206L;

    /* (非 Javadoc)
    * <p>Title: initial</p>
    * <p>Description: </p>
    * @return
    * @see com.jdframe.sys.core.action.JdframeAction#initial()
    */
    @Override
    protected String initial(){
    	//this.setSystemMessage("初始化成功！");
    	return INITIAL;
    }
    
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		ArrayList list  = (ArrayList) sqlsession.selectList("getOrg_listPage_ByDmMc", var);
		this.setPagenationList(list);
		//log.debug(orgTree);
		return SUCCESS;
	}

	
	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
	}

}
