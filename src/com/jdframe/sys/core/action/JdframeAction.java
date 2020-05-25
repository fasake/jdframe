/*
 * 
 */
package com.jdframe.sys.core.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.exception.JDFrameException;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.dao.model.T_sys_organization;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

 

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.action.JdframeAction.java
 * The Class JdframeAction.
 * Last-Modified-Time : 2013-11-8 10:46:03
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public abstract class JdframeAction extends ActionSupport {
	
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	
	private static final long serialVersionUID = -8727634387657108848L;
	
	/** The Constant DOMAIN_PATH. */
    public static final String $PATH_DOMAIN = System.getProperty("user.dir")+File.separator;
    
    /** The Constant ATTACH_PATH. */
    public static final String $PATH_ATTACH = $PATH_DOMAIN+"Attachs";

	/**
	 * Perform方法，已经初始化SqlSession,无异常自动提交，有异常执行回滚操作..
	 *
	 * @return the string
	 */
	protected abstract String perform();
	
	
	 
	/**
	 * Validators方法，已经初始化SqlSession,无异常自动提交，有异常执行回滚操作..
	 */
	protected abstract void validators();
	
	/**
	 * Initial方法，已经初始化SqlSession,无异常自动提交，有异常执行回滚操作.
	 *
	 * @return the string
	 */
	protected abstract String initial();
	
	 
	/* (非 Javadoc)
	* <p>Title: execute，子类实现perform方法即可</p>
	* <p>Description: </p>
	* @return
	* @throws Exception
	* @see com.opensymphony.xwork2.ActionSupport#execute()
	*/
	@Override
	public final String execute() throws Exception {
		// TODO Auto-generated method stub
		return $private();
	}

	 
	/**
	 * __private.
	 *
	 * @return the string
	 */
	private String $private() {
		long start = System.currentTimeMillis();
		String returnStr = SUCCESS;
		sqlsession = buildSession();
		try{
			returnStr = perform();
			sqlsession.commit();
		}catch(Exception e){
			sqlsession.rollback();
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
		log.info("<Call "+this.getClass().getName()+" perform Completed,Measured milliseconds :"+(System.currentTimeMillis()-start)+">");
		return returnStr;
	}
	
 
	 
	/* (非 Javadoc)
	* <p>Title: validate，子类实现validators方法即可</p>
	* <p>Description: </p>
	* @see com.opensymphony.xwork2.ActionSupport#validate()
	*/
	@Override
	public final void validate() {
		// TODO Auto-generated method stub
				O00000000000OOOOOO0();
		
	}
 
	/**
	 * O00000000000 ooooo o0.
	 */
	private void O00000000000OOOOOO0() {
		long start = System.currentTimeMillis();
		sqlsession = buildSession();
		try{
			validators();
			accessPrivilege();
		}catch(Exception e){
			sqlsession.rollback();
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
		log.debug("<Call validators Completed,Measured milliseconds :"+(System.currentTimeMillis()-start)+">");
	}
	
	/**
	 * 框架内置方法 init(), 子类实现initial()即可.
	 *
	 * @return the string
	 */
	public final String init(){
		// TODO Auto-generated method stub
		return O00000000000OOOOO();
	}

	 
	/**
	 * O00000000000 ooooo.
	 *
	 * @return the string
	 */
	private String O00000000000OOOOO() {
		long start = System.currentTimeMillis();
		String returnStr = SUCCESS;
		sqlsession = buildSession();
		try{
			returnStr = initial();
			sqlsession.commit();
		}finally{
			sqlsession.rollback();
			sqlsession.close();
		}
		log.debug("<Call initial Completed,Measured milliseconds :"+(System.currentTimeMillis()-start)+">");
		return returnStr;
	}

	
	
	
	/**
	 * Instantiates a new iframe action.
	 */
	public JdframeAction(){
		log.debug("Action init finshed!");
	}
	
	
	 
	 
	/**
	 * 获取下级机构完整信息..
	 *
	 * @param zzjg_dm_sj the zzjg_dm_sj
	 * @param zzjg_bz the zzjg_bz
	 * @return the sub org by dm and bz
	 */
	public List<T_sys_organization> getSubOrgByDmAndBz(String zzjg_dm_sj,String zzjg_bz){
		return O00000000000OOOOOO0O_002(zzjg_dm_sj, zzjg_bz);
	}

	 
	/**
	 * O00000000000 ooooo o0 o_002.
	 *
	 * @param zzjg_dm_sj the zzjg_dm_sj
	 * @param zzjg_bz the zzjg_bz
	 * @return the list
	 */
	private List O00000000000OOOOOO0O_002(String zzjg_dm_sj, String zzjg_bz) {
		Map arg = new HashMap();
		arg.put("zzjg_dm_sj", zzjg_dm_sj);
		arg.put("zzjg_bz", zzjg_bz);
		SqlSession ss = buildSession();
		try{
			return ss.selectList("getSubOrgByDmAndBz", arg);
		}finally{
			ss.close();
		}
	}
	
	/**
	 * 获取下级机构的代码和机构名称..
	 *
	 * @param zzjg_dm_sj the zzjg_dm_sj 上级机构代码
	 * @param zzjg_bz the zzjg_bz (J:机构/B：部门)
	 * @return  hashmap
	 */
	public HashMap<String,String> getSubOrgDmAndMcByDmAndBz(String zzjg_dm_sj,String zzjg_bz){
		return O00000000000OOOOOO0O_001(zzjg_dm_sj, zzjg_bz);
	}

	/**
	 * 获取下级机构.
	 *
	 * @param zzjg_dm_sj the zzjg_dm_sj 上级机构代码
	 * @param zzjg_bz the zzjg_bz (J:机构/B：部门)
	 * @return the sub org dm and mc by dm and bz impl
	 */
	private HashMap O00000000000OOOOOO0O_001(String zzjg_dm_sj,
			String zzjg_bz) {
		List<T_sys_organization> list = getSubOrgByDmAndBz(zzjg_dm_sj,zzjg_bz);
		HashMap<String,String> map = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			T_sys_organization org = list.get(i);
			if(org != null){
				map.put(org.getZzjg_dm(), org.getZzjg_name());
			}
		}
		return map;
	}
	
	
	  
	
	 
	/**
	 * 删除附件，成功返回true,失败返回false..
	 *
	 * @param attach_uri the attach Absolute Path
	 * @return true, if successful
	 */
	protected boolean deleteAttach(String attach_uri) {
			 if(attach_uri != null && !attach_uri.equals("")){
			   try {
					File f = new File(attach_uri);  
					FileUtils.forceDelete(f);
					f = null;
					return true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			 }
		 return true;
	}
	
	/**
	 * 重命名并保存附件到domain/Attachs目录下，成功返回新文件文件名，失败返回null.
	 *
	 * @param attach the attach
	 * @return the string
	 */
	protected String saveAttach(File attach) {
		 if(!attach.exists()){
			 return null;
		 }
		 String newfilename = StringUtils.randomString();
		 File savefile = new File($PATH_ATTACH, newfilename);
		 
		 if (!savefile.getParentFile().exists()){
			 savefile.getParentFile().mkdirs();   	 
		 }
		 try {
			 
			FileUtils.copyFile(attach, savefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return newfilename;
	}
	
	
	/**
	 * 当前执行的方法名称
	 *
	 * @return the method name
	 */
	protected String getMethodName(){
		return ActionContext.getContext().getName();
	}
	
}
