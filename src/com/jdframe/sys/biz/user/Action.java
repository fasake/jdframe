package com.jdframe.sys.biz.user;



import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_grant;
import com.jdframe.sys.dao.model.T_sys_station;
import com.jdframe.sys.dao.model.T_sys_user;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.user.UserAction.java
 * The Class UserAction.
 * Last-Modified-Time : 2013-11-8 10:45:33
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public abstract class Action extends JdframeAction {
	
    
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 8181675709525823206L;
	/** The user. */
	protected T_sys_user var = new T_sys_user();
	 
	
	
	public T_sys_user getVar() {
		return var;
	}



	public void setVar(T_sys_user var) {
		this.var = var;
	}



	/**
	 * Inits the user satation.
	 *
	 * @return the string
	 */
	public String initUserSatation(String user_id){
		SqlSession ss = buildSession();
		try{
			List<T_sys_grant> list   = ss.selectList("getGrantByUserId",user_id);
			String station_ids = "";
			for (int i = 0; i < list.size(); i++) {
				T_sys_grant grant = list.get(i);
				station_ids += grant.getGrant_fid().concat(",");
			}
			if(station_ids.endsWith(",")){
				station_ids = station_ids.substring(0,station_ids.length()-1);
			}
			return station_ids; 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		 
			ss.close();
		}
		return "";
	} 
	
	 

	
	
}
