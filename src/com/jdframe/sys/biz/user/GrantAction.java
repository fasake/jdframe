package com.jdframe.sys.biz.user;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_station;
import com.jdframe.sys.dao.model.T_sys_user;

public class GrantAction extends Action {
    //组织机构复选框数
	public String stationTree="";
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		
		int i = grant(sqlsession, var.getUser_id(),	var.getUser_station_id(),GRANT_TYPE.GRANT_USER_ASSO_STATION);
		if (i > 0) {
			String user_zzjg_dm = var.getUser_zzjg_dm();
			var = null;
			var = new T_sys_user();
			var.setUser_zzjg_dm(user_zzjg_dm);
			setSystemMessage("人员授权成功!");
		} else {
			setSystemMessage("人员授权失败!");
		}
		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_id())){
			setSystemMessage("用户ID不能为空！", true, "var.user_id");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		// 初始化
		var =  sqlsession.selectOne("getUserByUserId", var.getUser_id());
		var.setUser_station_id(initUserSatation(var.getUser_id()));
		buildTree(sqlsession);
		return INITIAL;
	}
	
	protected String buildTree(SqlSession sqlsession){
		// TODO Auto-generated method stub
				String stationTree = "  d = new dTree('d');\r\n"+" d.add(1,-1,'系统岗位'); \r\n";
				stationTree +=  getChildNodes(sqlsession);
				stationTree +=  "document.write(d);";
				this.setStationTree(stationTree);
				return stationTree;
	}
	/**
	 * 
	* Title:  getChildNodes
	* Description: TODO(返回当前用户主管税务机关下面所有的岗位列表)
	* @param      
	* @return  String  
	*
	 */
	public String getChildNodes(SqlSession ss){
		StringBuffer childNodesInnerHTML = new StringBuffer("");
		try{
			ArrayList<T_sys_station> list  = (ArrayList) ss.selectList("buildStationTree",getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm());
			T_sys_station station = null;
			for (int i = 0; i < list.size(); i++) {
				station = list.get(i);
				childNodesInnerHTML.append(station.getStation_name());
			}
			return childNodesInnerHTML.toString();
		}catch(Exception e){
			e.printStackTrace();
		} 
		return "";
	} 
	
	public String getStationTree() {
		return stationTree;
	}

	public void setStationTree(String stationTree) {
		this.stationTree = stationTree;
	}
   
}
