package com.jdframe.sys.core.util;

import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.core.model.Tokens;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.dao.model.T_sys_code;
import com.jdframe.sys.dao.model.T_sys_task;
import com.jdframe.sys.dao.model.T_sys_task_receive;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.util.TaskUtils.java
 * The   TaskUtils
 * Last-Modified-Time : 2014-1-22 14:23:15
 *
 * @author support@jdframe.com
 * @version  2.0.3.1
 *  http://www.jdframe.com
 * @see 
 */
public class TaskUtils {
	
	/** The __log. */
	static Logger __log = Logger.getLogger(TaskUtils.class);
	 
	/**
	 * Run task.
	 *
	 * @param request the request
	 * @param response the response
	 */
	public static void runTask(HttpServletRequest request,HttpServletResponse response) {
		String __P_taskId = request.getParameter("task_id");
        if(ValidateUtils.isNullOrEmpty(__P_taskId)){
        	__log.error("The task argument incorrect.d");
        }
        SqlSession __sqlsession = DbUtils.builder().openSession();
        boolean __isContinue = true;
        try{
        	
        	T_sys_task __tmp_task = __sqlsession.selectOne("getTaskByTaskId",__P_taskId);
        	String user_dm = ((UserProfile)request.getSession().getAttribute(Tokens._USER_PROFILE)).getUser().getUser_dm();
        	if(__tmp_task!=null){
        		if(!__tmp_task.getTask_status().equalsIgnoreCase("0")){
        			__log.error("<Task status invalid!" + __P_taskId+","+user_dm+">");__isContinue=false;
        		}
        		if(ValidateUtils.isNullOrEmpty(__tmp_task.getTask_link())){
        			__log.error("<Task status invalid!" + __P_taskId+","+user_dm+">");__isContinue=false;
        		}
        		if(DateUtils.compareDate(__tmp_task.getTask_expire_date())<0){
        			__log.error("<Task was expired!" + __P_taskId+","+user_dm+">");
        		}
        		if(__isContinue){
        			
        			HashMap args = new HashMap();
        			args.put("task_id", __P_taskId);
        			args.put("task_receiver", user_dm);
	        		T_sys_task_receive __task_receive = __sqlsession.selectOne("getTaskReceiveByTaskId",args);
	        		if(__task_receive != null){
        				 HashMap<String, String> __map = new HashMap();
        				 __map.put("task_receive_date", DateUtils.newDateTime());
        				 __map.put("task_receiver", user_dm);
        				 __map.put("task_id", __P_taskId);
        				__sqlsession.update("updateTaskReceive", __map);
        				__sqlsession.commit();
        				__map = null;
	        		}else{
	        			__isContinue = false;
	        		}
	        		__task_receive = null;
        		}
        		
        		if(__isContinue){
        			String __systemContext = "";
        			
    				String __task_link = __tmp_task.getTask_link();

        			if(!__tmp_task.getTask_from().equals("01")){
        				//other system.
        				
        				T_sys_code __code = CodesCache.findCode(__tmp_task.getTask_from(), "DM_SYSTEM");
        				if(__code!=null){
        					__systemContext = __code.getCode_name();
        				}
        				
        				 __log.debug("Redirect to:"+__systemContext.concat(__task_link));
        				 if(!__task_link.matches("[a-zA-z]+://[^s]*")){
        					 __log.error("<Sytem detected a corrupt external address!," + __P_taskId+","+user_dm+">");
        					 if(__task_link.startsWith("www")){
        						 __log.error("<Sytem detected prefix is www,will repair a corrupt external address automatic>");
            					 __task_link = "http://" + __task_link;
            				 }else{
        					    return;
            				 }
        				 }
        				response.sendRedirect(__task_link);
        				//auto complement 
        				endTask(__P_taskId, user_dm);
        				__code = null;
        			}else{
        				//self system.
        			    if(!__task_link.startsWith("/")){
        			    	__task_link = __task_link+"/";
        			    }
        			    __log.debug("Forward to:"+__task_link);
        			   request.getRequestDispatcher(__task_link).forward(request, response);
        			   //if external system then auto finish
        			   String __P_ac = request.getParameter("_autofinish");
	       				if(!ValidateUtils.isNullOrEmpty(__P_ac) && __P_ac.equalsIgnoreCase("true")){
	       					endTask(__P_taskId, user_dm);
	       				}
        			}
        		}else{
        			__log.error("Forward failure!");
        		}
        		
        	}
        	__tmp_task = null;
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	__sqlsession.close();
        	__sqlsession = null;
        }
	}
	
	/**
	 * End task.
	 *
	 * @param task_id the task_id
	 * @param user_dm the user_dm
	 * @return true, if successful
	 * @throws ParseException the parse exception
	 */
	public static boolean endTask(String task_id,String user_dm) throws ParseException {
		if(ValidateUtils.isNullOrEmpty(task_id) || ValidateUtils.isNullOrEmpty(user_dm)){
			__log.error("finish task fail , the task id or user code is null!");
			return false;
		}
		
		
		SqlSession ss = DbUtils.builder().openSession();
		try {
			T_sys_task task = ss.selectOne("getTaskByTaskId", task_id);
			if (task.getTask_status().equals(Tokens.TASK_STATUS.TASK_STATUS_WATTING.value())) {
				
				HashMap map = new HashMap();
				// expired 
				if (DateUtils.compareDate(task.getTask_expire_date()) >= 0) {
					map.put("task_status",Tokens.TASK_STATUS.TASK_STATUS_TIMEOUT.value());
				} else {
					map.put("task_status",Tokens.TASK_STATUS.TASK_STATUS_PROCESSED.value());
				}

				map.put("task_deal_date", DateUtils.newDateTime());
				map.put("task_id", task_id);
				int i = ss.update("updateTaskStatus", map);
				if (i > 0) {
					map.clear();
					map.put("task_id", task_id);
					map.put("task_receive_date", DateUtils.newDateTime());
					map.put("task_receiver", user_dm);
					int j = ss.update("updateTaskReceive", map);
					if (j > 0) {
						ss.commit();
						return true;
					}
				}
			} else if (task.getTask_status().equals(Tokens.TASK_STATUS.TASK_STATUS_PROCESSED.value())) {
				System.out.println("<Task was colsed! >");
				//setSystemMessage("Task was complemented! ", true,"");
			}
		} finally {
			ss.close();
		}
		return false;
	}

}
