package com.jdframe.sys.biz.station;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_station;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.station.StationQueryAction.java
 * The Class StationQueryAction.
 * Last-Modified-Time : 2013-11-8 10:44:45
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class QueryAction extends Action {
	
    
   /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 4415715493903744460L;
	
   /**
    * 
    */
    @Override
    protected String initial(){
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
		//setting access permission
		String user_zzjg_dm  = getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm();
		var.setStation_zzjg_dm(user_zzjg_dm);
		//do query
		ArrayList<T_sys_station> list  = (ArrayList) sqlsession.selectList("getStation_listPage", var);
		this.setPagenationList(list);
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
