package com.jdframe.sys.biz.user;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.jdframe.sys.dao.model.T_sys_user;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.user.UserQueryAction.java
 * The Class UserQueryAction.
 * Last-Modified-Time : 2013-11-8 10:45:23
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class QueryAction extends Action {
   /**
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	*/
	private static final long serialVersionUID = 4415715493903744460L;

    @Override
    protected String initial(){
    	String zzjg_dm = var.getUser_zzjg_dm();
    	if(ValidateUtils.isNullOrEmpty(zzjg_dm)){
    		this.setSystemMessage("�û����ܻ�������Ϊ�գ�");
    	}
    	return SUCCESS;
    }
    
	/* (�� Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		ArrayList<T_sys_user> list  = (ArrayList) sqlsession.selectList("getUser_listPage", var);
		this.setPagenationList(list);
		return SUCCESS;
	}
	
	/* (�� Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
        if(ValidateUtils.isNullOrEmpty(var.getUser_zzjg_dm())){
        	setSystemMessage("�û��������벻��Ϊ�գ�",true,null);
        }
	}
	
}
