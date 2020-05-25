package com.jdframe.sys.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.dao.model.T_sys_consumer;
import com.jdframe.sys.dao.model.T_sys_menu;
import com.jdframe.sys.dao.model.T_sys_notice;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.jdframe.sys.dao.model.T_sys_user;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.UserProfile.java
 * The Class UserProfile.
 * Last-Modified-Time : 2013-11-8 10:46:42
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class UserProfile implements java.io.Serializable{
	
	 
	/** The log. */
	transient Logger log = Logger.getLogger(getClass());
	//用户登录信息
	/** The user. */
	private  User user;
	// 用户权限
	/** The privilege. */
	public HashMap privilege = new HashMap();
	
	
 
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the privilege.
	 *
	 * @return the privilege
	 */
	public HashMap getPrivilege() {
		return privilege;
	}

	/**
	 * Sets the privilege.
	 *
	 * @param privilege the new privilege
	 */
	public void setPrivilege(HashMap privilege) {
		this.privilege = privilege;
	}

	
      /**
       * Instantiates a new user profile.
       *
       * @param user the user
       */
	public UserProfile(User user)  {
	   if(user != null){
			this.setUser(user);
			initPrivilege();
	   }
	}
	 
	/**
	 * Inits the privilege.
	 */
	private void initPrivilege(){
		org.apache.ibatis.session.SqlSession __sqlsession =  DbUtils.builder().openSession();
		try{
			//初始化用户菜单
			user.setUser_menu_html(initUserMenu(__sqlsession, user.getUser_zzjg_dm()));
			//当前组织机构
			
			T_sys_organization __org = __sqlsession.selectOne("getOrgBySwjgDm",user.getUser_zzjg_dm());
			//user's station ,tag is "B" or "J"
			user.setUser_zzjg(__org);
			//user's up level organiztion, tag is "J"
			user.setUser_zzjg_sj(getUplevelJG(__sqlsession,user.getUser_zzjg_dm()));
//			if(__org!=null){
//				user.setUser_zzjg_name(__org.getZzjg_name());
//				if(__org.getZzjg_bz().equalsIgnoreCase("J")){
//					user.setUser_zzjg_sj(__org);
//				}else if(__org.getZzjg_bz().equalsIgnoreCase("B")){
//					user.setUser_zzjg(__org);
//					
//					T_sys_organization __org_bm = __sqlsession.selectOne("getOrgSjByZzjgdm",user.getUser_dm());
//					if(__org_bm != null && __org_bm.getZzjg_bz().equalsIgnoreCase("B")){
//						user.setUser_zzjg_sj(null);
//						log.error("系统组织机构配置错误，不支持多级部门");
//						throw new java.lang.IllegalStateException("系统组织机构配置错误，不支持多级部门");
//					}else if(__org_bm != null && __org_bm.getZzjg_bz().equalsIgnoreCase("J")){
//						user.setUser_zzjg_sj(__org_bm);
//					}
//					__org_bm  = null;
//				}
//			}
//			__org  = null;
			
			
		}finally{
			__sqlsession.close();
			__sqlsession = null;
		}
		
	}
	
	/**
	 * Gets the uplevel jg.
	 *
	 * @param zzjg_dm the zzjg_dm
	 * @return the uplevel jg
	 */
	private T_sys_organization getUplevelJG(SqlSession __sqlsession,String zzjg_dm){
		T_sys_organization __org = null;
		 __org = __sqlsession.selectOne("getOrgBySwjgDm",zzjg_dm);

		if(__org == null || __org.getZzjg_bz().equalsIgnoreCase("J")){
			return __org;
		}else{
			return getUplevelJG(__sqlsession,__org.getZzjg_dm_sj());
		}
	}
	
	
	 
	/**
	 * Inits the user menu.
	 *
	 * @param sqlsession the sqlsession
	 * @param user_zzjg_dm the user_zzjg_dm
	 * @return the string
	 */
	protected String initUserMenu(SqlSession sqlsession,String user_zzjg_dm){
		StringBuffer __menuHTML = new StringBuffer("");
		HashMap<String, String> __arg = new HashMap();
		__arg.put("user_id", user.getUser_id());
		__arg.put("zzjg_dm", user.getUser_zzjg_dm());
		ArrayList<T_sys_menu> __menuCatalogue = (ArrayList) sqlsession.selectList("getMenuCatalogueByUserId", __arg);
		
		HashMap<String, String> __map = new HashMap<String, String>();
		T_sys_menu __catalogue =  null;
		Vector<String> __vmenus = new Vector<String>();
		for (int i = 0; i < __menuCatalogue.size(); i++) {
			__catalogue = __menuCatalogue.get(i);
			__vmenus.add(__catalogue.getMenu_id());
			__menuHTML.append("<div id=\"DivID"+i+"\" class=\"zxmenu\" onClick=\"javascript:show('DivID").append(i).append("');\" >").append(__catalogue.getMenu_name()).append("</div>");
			__menuHTML.append("<div id=\"DivID"+i+"_2\" style=\"display:none\">");
			__menuHTML.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"4\" >");
			__map.clear();
			__map.put("menu_parent_id", __catalogue.getMenu_id());
			__map.put("zzjg_dm", __arg.get("zzjg_dm"));
			__map.put("user_id", __arg.get("user_id"));
			ArrayList<T_sys_menu> __menuLeaf = (ArrayList) sqlsession.selectList("getMenuLeafByParentId", __map);
			T_sys_menu leaf = null;
			for (int j = 0; j < __menuLeaf.size(); j++) {
				leaf = __menuLeaf.get(j);
				__vmenus.add(leaf.getMenu_id());
				__menuHTML.append("<tr>");
				__menuHTML.append("<td width=\"10\">&nbsp;</td>");
				__menuHTML.append("<td class=\"zxmenu2\"><li><a href=\"javascript:addDiv('").append(leaf.getMenu_name()).append("','").append(leaf.getMenu_name()).append("','").append(leaf.getMenu_url()).append("');\" target=\"main\">").append(leaf.getMenu_name()).append("</a></li></td>");
				__menuHTML.append("</tr>");
			}
			leaf = null;
			__menuLeaf = null;
			__menuHTML.append("</table>");
			__menuHTML.append("</div>");
		}
		__map = null;
		__arg = null;
		//保存用户菜单信息
		privilege.put(com.jdframe.sys.core.model.Tokens._USER_MENU, __vmenus);
		__catalogue = null;
		__menuCatalogue = null;
		__vmenus = null;
		return __menuHTML.toString();
	}
	
	/**
	 * Inits the user notice.
	 *
	 * @param zzjg_dm the zzjg_dm
	 * @return the string
	 */
	public static String initUserNotice(String zzjg_dm){
		return initUserNoticeImpl(zzjg_dm);
	}

	/**
	 * _init user notice impl.
	 *
	 * @param zzjg_dm the zzjg_dm
	 * @return the string
	 */
	private static String initUserNoticeImpl(String zzjg_dm) {
		org.apache.ibatis.session.SqlSession __sqlsession =  DbUtils.builder().openSession();
		StringBuffer __noticeHTML = new StringBuffer("");
		try{
				__noticeHTML.append("<div  style=\"height:100%\"><marquee width=\"210\" height=\"100%\" id=\"mrq_notice\" onmouseover=\"mrq_notice.stop()\" onmouseout=\"mrq_notice.start()\" direction=\"up\" scrollAmount=\"2\">");
				HashMap __map = new HashMap();
				__map.put("user_zzjg_dm", zzjg_dm);
				__map.put("notice_expire_date", DateUtils.newDateTime());
				ArrayList<T_sys_notice> __list  = (ArrayList) __sqlsession.selectList("getNoticeAll", __map);
				for (int i = 0; i < __list.size(); i++) {
					T_sys_notice notice  = __list.get(i);
					__noticeHTML.append("<table width=\"100%\" border=\"0\" cellSpacing=\"0\" style=\"margin-left: 5px\">");
					__noticeHTML.append("<tbody>");
					__noticeHTML.append("<tr>");
					__noticeHTML.append("<td id=\""+java.util.UUID.randomUUID()+"\" style=\"font-size: 12px;\"  title=\"Publish Date:"+notice.getNotice_create_date()+"   \r\nExpire  Date:"+notice.getNotice_expire_date()+"\">");
					__noticeHTML.append("<a class=\"b01\" onclick=\"showNotice('"+notice.getNotice_id()+"')\" href=\"javascript:void();\">");
					__noticeHTML.append("<img width=\"16\" height=\"16\" src=\"/images/sys/notice.gif\" complete=\"complete\"/>");
					__noticeHTML.append("<font color=\"red\" zise=\"12px\">"+notice.getNotice_title()+"</font>");
					__noticeHTML.append(" </a>");
					__noticeHTML.append("</td>");
					__noticeHTML.append("</tr>");
					__noticeHTML.append("</tbody>");
					__noticeHTML.append("</table>");
				}
				__noticeHTML.append("</div></marquee>");
				__list = null;
				__map = null;
				
				
		}finally{
			__sqlsession.close();
			__sqlsession = null;
		}
		return __noticeHTML.toString();
	}
	
	/**
	 * Gets the server info.
	 *
	 * @return the server info
	 */
	public String getServerInfo(){
	    	StringBuffer __buffer = new StringBuffer("");
	    	Map __env  =   System.getenv();
	    	Iterator __loop = __env.keySet().iterator();
	    	while(__loop.hasNext()){
	    		Object key = __loop.next();
	    		Object value = __env.get(key);
	    		__buffer.append("#"+key+"="+value+"\r\t");
	    		key = null;
	    		value = null;
	    	}
	    	__loop = null;
	    	__env = null;
	    	return __buffer.toString();
	    }
	  

}
