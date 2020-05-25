package com.jdframe.sys.biz.station;


import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.*;
import com.jdframe.sys.dao.model.T_sys_station;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.station.StationUpdateAction.java
 * The Class StationUpdateAction.
 * Last-Modified-Time : 2013-11-8 10:44:49
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UpdateAction extends Action {
	
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -1874224702642474771L;
	 
	
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		 if(StringUtils.isEmptyOrNull(var.getStation_name())){
				setSystemMessage("岗位名称不能为空!", false, "var.role_name");
				return INPUT;
		 }
		 if(StringUtils.isEmptyOrNull(var.getStation_name())){
				setSystemMessage("岗位名称不能为空!", false, "var.role_name");
				return INPUT;
		 }
		 if(StringUtils.isEmptyOrNull(var.getStation_id())){
				setSystemMessage("岗位ID不能为空!", false, "var.role_name");
				return INPUT;
		 }
		 
		int i = sqlsession.update("updateStation", var);
		if(i>0){
			
			int j = grant(sqlsession,var.getStation_id(),var.getStation_role_id(),GRANT_TYPE.GRANT_STATION_ASSO_ROLE);
			var = new T_sys_station();
			setSystemMessage("Update Item Success!");
		}else{
			setSystemMessage("Update Item Failed!");
			return INPUT;
		}
		 
		 
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
        if(ValidateUtils.isNullOrEmpty(var.getStation_id())){
        	setSystemMessage("岗位ID不能为空！",true,"");
        }
        
	}

 
	/* (非 Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		//初始化基本信息
		var =  sqlsession.selectOne("getStationByStationId", var.getStation_id());
		//初始化树
		buildTree();
		return INITIAL;
	}
  
	
}
