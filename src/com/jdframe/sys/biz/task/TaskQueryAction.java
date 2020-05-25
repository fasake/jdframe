package com.jdframe.sys.biz.task;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;


import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.dao.model.T_sys_task;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.task.TaskQueryAction.java
 * The Class TaskQueryAction.
 * Last-Modified-Time : 2013-11-8 10:45:36
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class TaskQueryAction extends TaskAction {
	
    
   /**
	* @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	*/
	private static final long serialVersionUID = 4415715493903744460L;
	/**
	 * @Description: TODO ϵͳ�������˳�ʼ��
	 */
    @Override
    protected String initial(){
    	HashMap<String,String> map = new HashMap();
		map.put("task_receiver", getUserProfileFromSession().getUser().getUser_dm());
		//map.put("current_date",DateUtils._newDateTime());
		ArrayList<T_sys_task> list  = (ArrayList) sqlsession.selectList("getTask_listPage_ByDefault", map);
		this.setPagenationList(list);
		map = null;
    	return INITIAL;
    }
    
    
    /**
	 * @Description: TODO ϵͳ�������˲�ѯ
	 */
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("task_receiver", getUserProfileFromSession().getUser().getUser_dm());
		map.put("task_status", getTask_status());
		map.put("task_title",  getTask_title());
		
		//��ѯ���ڴ�������
		if(getTask_status().equals("1")){
			map.put("task_expire_date", DateUtils.newDateTime());
		}
		
		ArrayList<T_sys_task> list  = (ArrayList) sqlsession.selectList("getTask_listPage", map);
		this.setPagenationList(list);
		map = null;
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
	}
	 
}
