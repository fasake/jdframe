package com.jdframe.sys.biz.role;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_role;
 
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
		var.setRole_zzjg_dm(user_zzjg_dm);
		//do query
		ArrayList<T_sys_role> list  = (ArrayList) sqlsession.selectList("getRole_listPage", var);
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
