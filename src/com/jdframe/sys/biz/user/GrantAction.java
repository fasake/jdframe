package com.jdframe.sys.biz.user;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_station;
import com.jdframe.sys.dao.model.T_sys_user;

public class GrantAction extends Action {
    //��֯������ѡ����
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
			setSystemMessage("��Ա��Ȩ�ɹ�!");
		} else {
			setSystemMessage("��Ա��Ȩʧ��!");
		}
		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(StringUtils.isEmptyOrNull(var.getUser_id())){
			setSystemMessage("�û�ID����Ϊ�գ�", true, "var.user_id");
		}
	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		// ��ʼ��
		var =  sqlsession.selectOne("getUserByUserId", var.getUser_id());
		var.setUser_station_id(initUserSatation(var.getUser_id()));
		buildTree(sqlsession);
		return INITIAL;
	}
	
	protected String buildTree(SqlSession sqlsession){
		// TODO Auto-generated method stub
				String stationTree = "  d = new dTree('d');\r\n"+" d.add(1,-1,'ϵͳ��λ'); \r\n";
				stationTree +=  getChildNodes(sqlsession);
				stationTree +=  "document.write(d);";
				this.setStationTree(stationTree);
				return stationTree;
	}
	/**
	 * 
	* Title:  getChildNodes
	* Description: TODO(���ص�ǰ�û�����˰������������еĸ�λ�б�)
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
