/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2;

import com.jdframe.sys.core.exception.JDFrameException;
import com.jdframe.sys.core.model.Tokens;
import com.jdframe.sys.core.model.Tokens.GRANT_TYPE;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.*;
import com.jdframe.sys.dao.model.T_sys_grant;
import com.jdframe.sys.dao.model.T_sys_menu;
import com.jdframe.sys.dao.model.T_sys_task;
import com.jdframe.sys.dao.model.T_sys_task_receive;
import com.jdframe.sys.dao.model.T_sys_user;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionSupport.
 *
 * @copyright www.jdframe.com
 * @Package com.opensymphony.xwork2ActionSupport.java
 * @Description: TODO
 * @author: support@jdframe.com
 * @date: 2013-7-28 0:05:22
 * @version v1.0
 */
public class ActionSupport implements Action, Validateable, ValidationAware,
		TextProvider, LocaleProvider, Serializable {

	/** The system message. */
	

	// 返还前台的消息提示
	protected String systemMessage = "";
	
	/** The sqlsession. */
	protected SqlSession sqlsession = null;

	// 翻页对象
	/** The page no. */
	private String pageNo = "1"; // 当前页码

	/** The page count. */
	private String pageCount = "1"; // 总页数

	/** The page size. */
	private String pageSize = "10"; // 每页显示记录数

	/** The row count. */
	private String rowCount = "0"; // 记录数
	// 用于保存页面显示记录的list
	/** The pagenation list. */
	private ArrayList pagenationList = new ArrayList();
	//待办事项ID
	/** The task_id. */
	protected String task_id;

	// protected static Logger LOG =
	// LoggerFactory.getLogger(ActionSupport.class);

	/** The log. */
	protected Logger log = Logger.getLogger(getClass());

	/** The validation aware. */
	private final ValidationAwareSupport validationAware = new ValidationAwareSupport();

	/** The text provider. */
	private transient TextProvider textProvider;
	
	/** The container. */
	private Container container;

	/* (非 Javadoc)
	* <p>Title: setActionErrors</p>
	* <p>Description: </p>
	* @param errorMessages
	* @see com.opensymphony.xwork2.ValidationAware#setActionErrors(java.util.Collection)
	*/
	public void setActionErrors(Collection<String> errorMessages) {
		validationAware.setActionErrors(errorMessages);
	}

	/* (非 Javadoc)
	* <p>Title: getActionErrors</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#getActionErrors()
	*/
	public Collection<String> getActionErrors() {
		return validationAware.getActionErrors();
	}

	/* (非 Javadoc)
	* <p>Title: setActionMessages</p>
	* <p>Description: </p>
	* @param messages
	* @see com.opensymphony.xwork2.ValidationAware#setActionMessages(java.util.Collection)
	*/
	public void setActionMessages(Collection<String> messages) {
		validationAware.setActionMessages(messages);
	}

	/* (非 Javadoc)
	* <p>Title: getActionMessages</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#getActionMessages()
	*/
	public Collection<String> getActionMessages() {
		return validationAware.getActionMessages();
	}

	/**
	 * Gets the error messages.
	 *
	 * @return the error messages
	 */
	@Deprecated
	public Collection<String> getErrorMessages() {
		return getActionErrors();
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	@Deprecated
	public Map<String, List<String>> getErrors() {
		return getFieldErrors();
	}

	/* (非 Javadoc)
	* <p>Title: setFieldErrors</p>
	* <p>Description: </p>
	* @param errorMap
	* @see com.opensymphony.xwork2.ValidationAware#setFieldErrors(java.util.Map)
	*/
	public void setFieldErrors(Map<String, List<String>> errorMap) {
		validationAware.setFieldErrors(errorMap);
	}

	/* (非 Javadoc)
	* <p>Title: getFieldErrors</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#getFieldErrors()
	*/
	public Map<String, List<String>> getFieldErrors() {
		return validationAware.getFieldErrors();
	}

	/* (非 Javadoc)
	* <p>Title: getLocale</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.LocaleProvider#getLocale()
	*/
	public Locale getLocale() {
		ActionContext ctx = ActionContext.getContext();
		if (ctx != null) {
			return ctx.getLocale();
		} else {
			if (log.isDebugEnabled()) {
				log.debug("Action context not initialized");
			}
			return null;
		}
	}

	/* (非 Javadoc)
	* <p>Title: hasKey</p>
	* <p>Description: </p>
	* @param key
	* @return
	* @see com.opensymphony.xwork2.TextProvider#hasKey(java.lang.String)
	*/
	public boolean hasKey(String key) {
		return getTextProvider().hasKey(key);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param aTextName
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String)
	*/
	public String getText(String aTextName) {
		return getTextProvider().getText(aTextName);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param aTextName
	* @param defaultValue
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String)
	*/
	public String getText(String aTextName, String defaultValue) {
		return getTextProvider().getText(aTextName, defaultValue);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param aTextName
	* @param defaultValue
	* @param obj
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String, java.lang.String)
	*/
	public String getText(String aTextName, String defaultValue, String obj) {
		return getTextProvider().getText(aTextName, defaultValue, obj);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param aTextName
	* @param args
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.util.List)
	*/
	public String getText(String aTextName, List<?> args) {
		return getTextProvider().getText(aTextName, args);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param key
	* @param args
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String[])
	*/
	public String getText(String key, String[] args) {
		return getTextProvider().getText(key, args);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param aTextName
	* @param defaultValue
	* @param args
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String, java.util.List)
	*/
	public String getText(String aTextName, String defaultValue, List<?> args) {
		return getTextProvider().getText(aTextName, defaultValue, args);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param key
	* @param defaultValue
	* @param args
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String, java.lang.String[])
	*/
	public String getText(String key, String defaultValue, String[] args) {
		return getTextProvider().getText(key, defaultValue, args);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param key
	* @param defaultValue
	* @param args
	* @param stack
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String, java.util.List, com.opensymphony.xwork2.util.ValueStack)
	*/
	public String getText(String key, String defaultValue, List<?> args,
			ValueStack stack) {
		return getTextProvider().getText(key, defaultValue, args, stack);
	}

	/* (非 Javadoc)
	* <p>Title: getText</p>
	* <p>Description: </p>
	* @param key
	* @param defaultValue
	* @param args
	* @param stack
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getText(java.lang.String, java.lang.String, java.lang.String[], com.opensymphony.xwork2.util.ValueStack)
	*/
	public String getText(String key, String defaultValue, String[] args,
			ValueStack stack) {
		return getTextProvider().getText(key, defaultValue, args, stack);
	}

	/**
	 * Gets the formatted.
	 *
	 * @param key the key
	 * @param expr the expr
	 * @return the formatted
	 */
	public String getFormatted(String key, String expr) {
		Map<String, Object> conversionErrors = ActionContext.getContext()
				.getConversionErrors();
		if (conversionErrors.containsKey(expr)) {
			String[] vals = (String[]) conversionErrors.get(expr);
			return vals[0];
		} else {
			final ValueStack valueStack = ActionContext.getContext()
					.getValueStack();
			final Object val = valueStack.findValue(expr);
			return getText(key, Arrays.asList(val));
		}
	}

	/* (非 Javadoc)
	* <p>Title: getTexts</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getTexts()
	*/
	public ResourceBundle getTexts() {
		return getTextProvider().getTexts();
	}

	/* (非 Javadoc)
	* <p>Title: getTexts</p>
	* <p>Description: </p>
	* @param aBundleName
	* @return
	* @see com.opensymphony.xwork2.TextProvider#getTexts(java.lang.String)
	*/
	public ResourceBundle getTexts(String aBundleName) {
		return getTextProvider().getTexts(aBundleName);
	}

	/* (非 Javadoc)
	* <p>Title: addActionError</p>
	* <p>Description: </p>
	* @param anErrorMessage
	* @see com.opensymphony.xwork2.ValidationAware#addActionError(java.lang.String)
	*/
	public void addActionError(String anErrorMessage) {
		validationAware.addActionError(anErrorMessage);
	}

	/* (非 Javadoc)
	* <p>Title: addActionMessage</p>
	* <p>Description: </p>
	* @param aMessage
	* @see com.opensymphony.xwork2.ValidationAware#addActionMessage(java.lang.String)
	*/
	public void addActionMessage(String aMessage) {
		validationAware.addActionMessage(aMessage);
	}

	/* (非 Javadoc)
	* <p>Title: addFieldError</p>
	* <p>Description: </p>
	* @param fieldName
	* @param errorMessage
	* @see com.opensymphony.xwork2.ValidationAware#addFieldError(java.lang.String, java.lang.String)
	*/
	public void addFieldError(String fieldName, String errorMessage) {
		validationAware.addFieldError(fieldName, errorMessage);
	}

	/**
	 * Input.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	public String input() throws Exception {
		return INPUT;
	}

	/**
	 * Do default.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	public String doDefault() throws Exception {
		return SUCCESS;
	}

	/* (非 Javadoc)
	* <p>Title: execute</p>
	* <p>Description: </p>
	* @return
	* @throws Exception
	* @see com.opensymphony.xwork2.Action#execute()
	*/
	public String execute() throws Exception {
		return SUCCESS;
	}

	/* (非 Javadoc)
	* <p>Title: hasActionErrors</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#hasActionErrors()
	*/
	public boolean hasActionErrors() {
		return validationAware.hasActionErrors();
	}

	/* (非 Javadoc)
	* <p>Title: hasActionMessages</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#hasActionMessages()
	*/
	public boolean hasActionMessages() {
		return validationAware.hasActionMessages();
	}

	/* (非 Javadoc)
	* <p>Title: hasErrors</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#hasErrors()
	*/
	public boolean hasErrors() {
		return validationAware.hasErrors();
	}

	/* (非 Javadoc)
	* <p>Title: hasFieldErrors</p>
	* <p>Description: </p>
	* @return
	* @see com.opensymphony.xwork2.ValidationAware#hasFieldErrors()
	*/
	public boolean hasFieldErrors() {
		return validationAware.hasFieldErrors();
	}

	/**
	 * Clear field errors.
	 */
	public void clearFieldErrors() {
		validationAware.clearFieldErrors();
	}

	/**
	 * Clear action errors.
	 */
	public void clearActionErrors() {
		validationAware.clearActionErrors();
	}

	/**
	 * Clear messages.
	 */
	public void clearMessages() {
		validationAware.clearMessages();
	}

	/**
	 * Clear errors.
	 */
	public void clearErrors() {
		validationAware.clearErrors();
	}

	/**
	 * Clear errors and messages.
	 */
	public void clearErrorsAndMessages() {
		validationAware.clearErrorsAndMessages();
	}

	/* (非 Javadoc)
	* <p>Title: validate</p>
	* <p>Description: </p>
	* @see com.opensymphony.xwork2.Validateable#validate()
	*/
	public void validate() {
	}

	/* (非 Javadoc)
	* <p>Title: clone</p>
	* <p>Description: </p>
	* @return
	* @throws CloneNotSupportedException
	* @see java.lang.Object#clone()
	*/
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	/**
	 * Pause.
	 *
	 * @param result the result
	 */
	public void pause(String result) {
	}


	/**
	 * Gets the text provider.
	 *
	 * @return the text provider
	 */
	private TextProvider getTextProvider() {
		if (textProvider == null) {
			TextProviderFactory tpf = new TextProviderFactory();
			if (container != null) {
				container.inject(tpf);
			}
			textProvider = tpf.createInstance(getClass(), this);
		}
		return textProvider;
	}


	/**
	 * Sets the container.
	 *
	 * @param container the new container
	 */
	@Inject
	public void setContainer(Container container) {
		this.container = container;
	}

	// extend functions
	/**
	 * 办结待办事项.
	 *
	 * @param task_id the task_id
	 * @return true, if successful
	 * @throws ParseException the parse exception
	 */
	protected boolean finishTask(String task_id) throws ParseException {
		
		//return finishTaskImpl(task_id);
		return TaskUtils.endTask(task_id, getUserDm());
	}

	/**
	 * 返回当前HttpServletRequest对象.
	 *
	 * @return the request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 返回当前HttpServletResponse对象.
	 *
	 * @return the response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 返回当前HttpSession对象.
	 *
	 * @param create the create
	 * @return the session
	 */
	public HttpSession getSession(boolean create) {
		
		return ServletActionContext.getRequest().getSession(create);
	}

	/**
	 * 获取当前登录用户信息,如果不存在返回null.
	 *
	 * @return the user profile from session
	 */
	protected com.jdframe.sys.core.model.UserProfile getUserProfileFromSession() {
		return getUserProfileFromSessionImpl();
	}

	/**
	 * Gets the user profile from session impl.
	 *
	 * @return the user profile from session impl
	 */
	private com.jdframe.sys.core.model.UserProfile getUserProfileFromSessionImpl() {
		try {
			log.debug("USER_PROFILE:: "
					+ com.jdframe.sys.core.model.Tokens._USER_PROFILE);
			Object obj = getSession(true).getAttribute(
					com.jdframe.sys.core.model.Tokens._USER_PROFILE);
			if (obj == null) {
				throw new IllegalAccessError();

			} else {
				if (((com.jdframe.sys.core.model.UserProfile) obj).getUser() == null) {
					throw new IllegalAccessError();
				}
			}

			com.jdframe.sys.core.model.UserProfile userProfile = (com.jdframe.sys.core.model.UserProfile) obj;
			return userProfile;
		} catch (IllegalAccessError e) {
				e.printStackTrace();
				setSystemMessage("用户信息不存在，请重新登陆！");
		}
		return null;
	}

	/**
	 * 获取当前登录用户代码.
	 *
	 * @return the user dm
	 */
	protected String getUserDm() {
		return getUserProfileFromSession().getUser().getUser_dm();
	}

	/**
	 * Gets the system message.
	 *
	 * @return the system message
	 */
	public String getSystemMessage() {
		return systemMessage;
	}

	/**
	 * 设置前后台交互消息，配合前台标签一起使用；
	 *
	 * @param systemMessage the new system message
	 */
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}

	 
	 
	/**
	 * 设置前后台交互消息，配合前台标签一起使用；并设置actionError消息或者fieldError.
	 *
	 * @param message the message
	 * @param isActionError the is action error
	 * @param filedName the filed name
	 */
	public void setSystemMessage(String message, boolean isActionError,String filedName) {
		setSystemMessage(message);
		if(isActionError){
			this.addActionError(message);
		}else{
			this.addFieldError(filedName,message);
		}
	}

	/**
	 * 保存参数到SESSION，范围是每个action.
	 *
	 * @param name the name
	 * @param value the value
	 * @return the object
	 */
//	protected Object safeArguments(String name, Object value) {
//		return safeArgumentsImpl(name, value);
//	}

	private Object safeArgumentsImpl(String name, Object value) {
		ActionInvocation ai = ActionContext.getContext().getActionInvocation();
		ActionProxy proxy = ai.getProxy();
		// ActionConfig config = proxy.getConfig();
		String actionName = proxy.getActionName();
		String nameSpace = proxy.getNamespace();
		String method = proxy.getMethod();
		if (value == null) {
			return getSession(true).getAttribute( nameSpace + "." + actionName + "." + name);
		} else {
			getSession(true).setAttribute( nameSpace + "." + actionName + "." + name, value);
		}
		return value;
	}
	/**
	 * 保存参数到SESSION.作用域为ACTION
	 *
	 * @param name the name
	 * @param value the value 如果为null,相当于调用getArguments(name)
	 * @return the object
	 */
	protected Object setActonArguments(String name, Object value) {
		if(value==null || "".equals(value)){
			return getActionArguments(name);
		}
		return safeArgumentsImpl(name, value);
	}
	/**
	 * 获取参数从SESSION.作用域为ACTION
	 *
	 * @param name the name
	 * @param value the value
	 * @return the object
	 */
	protected Object getActionArguments(String name) {
		return safeArgumentsImpl(name, null);
	}
	

	/**
	 * 发送待办事项
	 *
	 * @param task the task
	 * @param menu_id the menu_id
	 * @return true, if successful
	 * @deprecated
	 */
	protected boolean sendTask(T_sys_task task, String menu_id) {
		return sendTaskImpl(task, menu_id);
	}


	/**
	 * Send task impl.
	 *
	 * @param task the task
	 * @param menu_id the menu_id
	 * @return true, if successful
	 */
	private boolean sendTaskImpl(T_sys_task task, String menu_id) {
		SqlSession ss = DbUtils.builder().openSession();
		try {
			String newTask_id = ss.selectOne("getNewTaskId");
			task.setTask_id(newTask_id);
			String task_link = task.getTask_link();
			task.setTask_link(task_link);

			int i = ss.insert("insertTask", task);
			HashMap map = new HashMap();
			map.put("menu_id", menu_id);
			map.put("user_zzjg_dm", getUserProfileFromSession().getUser()
					.getUser_zzjg_dm());
			List<T_sys_user> users = ss.selectList("getUserByMenuId", map);
			if(users.size() == 0){
				log.error("无待办事宜接收人员，接收人员列表为空！");
				ss.rollback();
				return false;
			}
			for (int j = 0; j < users.size(); j++) {
				T_sys_user user = users.get(j);
				String user_dm = user.getUser_dm();
				T_sys_task_receive receive = new T_sys_task_receive();
				receive.setTask_id(newTask_id);
				receive.setTask_receiver(user_dm);
				receive.setTask_receive_date("1900-01-01 00:00:00");
				int c = ss.insert("insertTaskReceive", receive);
				 
			}
			ss.commit();
			return true;
		}catch(Exception e){
			ss.rollback();
			e.printStackTrace();
			return false;
		} finally {
			ss.close();
		}
		
	}

	/**
	 * 发送待办事项.
	 *
	 * @param task_title the task_title
	 * @param task_priority the task_priority
	 * @param task_link the task_link
	 * @param task_from the task_from
	 * @param Task_expire_date the task_expire_date
	 * @param menu_id the menu_id
	 * @return true, if successful
	 */
	protected boolean sendTask(String task_title, Tokens.PRIORITY priortity,
			String task_link, String task_from, String Task_expire_date,
			String menu_id) {

		return sendTaskImpl(task_title, priortity, task_link, task_from,
				Task_expire_date, menu_id);

	}

 
	/**
	 * Send task impl.
	 *
	 * @param task_title the task_title
	 * @param priortity the priortity
	 * @param task_link the task_link
	 * @param task_from the task_from
	 * @param Task_expire_date the task_expire_date
	 * @param menu_id the menu_id
	 * @return true, if successful
	 */
	private boolean sendTaskImpl(String task_title, Tokens.PRIORITY priortity,
			String task_link, String task_from, String Task_expire_date,
			String menu_id) {
		T_sys_task task = new T_sys_task();
		task.setTask_create_date(DateUtils.newDateTime());
		task.setTask_expire_date(Task_expire_date);
		task.setTask_from(task_from);
		task.setTask_link(task_link);
		task.setTask_priority(priortity.value());
		task.setTask_sender(getUserDm());
		task.setTask_status("0");
		task.setTask_title(task_title);
		return sendTask(task, menu_id);
	}

	/**
	 * 授权
	 *
	 * @param sqlsession the sqlsession
	 * @param grant_id the grant_id
	 * @param grant_fid the grant_fid
	 * @param grant_type the grant_type
	 * @return the int
	 */
	protected int grant(SqlSession sqlsession, String grant_id,
			String grant_fid, GRANT_TYPE grant_type) {
		return grantImpl(sqlsession, grant_id, grant_fid, grant_type);
	}


	/**
	 * Grant impl.
	 *
	 * @param sqlsession the sqlsession
	 * @param grant_id the grant_id
	 * @param grant_fid the grant_fid
	 * @param grant_type the grant_type
	 * @return the int
	 */
	private int grantImpl(SqlSession sqlsession, String grant_id,
			String grant_fid, GRANT_TYPE grant_type) {
		int i = 0;
		if (ValidateUtils.isNullOrEmpty(grant_id) || ValidateUtils.isNullOrEmpty(grant_fid)
				|| ValidateUtils.isNullOrEmpty(grant_type)) {
			return 0;
		} else {
			int x = revoke(sqlsession, grant_id, grant_type);
			StringTokenizer st = new StringTokenizer(grant_fid, ",");
			T_sys_grant grant = null;
			Vector fid = new Vector();
			while (st.hasMoreTokens()) {
				String token = st.nextToken();

				grant = new T_sys_grant();
				grant.setGrant_id(grant_id);
				grant.setGrant_fid(token);
				grant.setGrant_type(grant_type.value());
				grant.setGrant_creater(getUserDm());
				grant.setGrant_create_date(DateUtils.newDateTime());
				fid.add(token);
				i += sqlsession.insert("grant", grant);

			}

			// 添加系统菜单上级节点
			if (grant_type.value().equals(GRANT_TYPE.GRANT_ROLE_ASSO_MENU.value())) {
				st = new StringTokenizer(grant_fid, ",");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					List<T_sys_menu> list = sqlsession.selectList(
							"getMenuParentIdByMenuId", token.trim());
					for (int j = 0; j < list.size(); j++) {
						T_sys_menu menu = list.get(j);
						grant = new T_sys_grant();
						grant.setGrant_id(grant_id);
						grant.setGrant_fid(menu.getMenu_parent_id());
						grant.setGrant_type(grant_type.value());
						grant.setGrant_creater(getUserDm());
						grant.setGrant_create_date(DateUtils.newDateTime());
						List grant_list = sqlsession.selectList(
								"getGrantByIFT", grant);
						if (grant_list.size() == 0) {
							i += sqlsession.insert("grant", grant);
						}
					}
				}
			}
		}
		return i;
	}

	/**
	 * 回收权限.
	 *
	 * @param sqlsession the sqlsession
	 * @param grant_id the grant_id
	 * @param grant_type the grant_type
	 * @return the int
	 */
	protected int revoke(SqlSession sqlsession, String grant_id,
			GRANT_TYPE grant_type) {
		return revokeImpl(sqlsession, grant_id, grant_type);
	}


	/**
	 * Revoke impl.
	 *
	 * @param sqlsession the sqlsession
	 * @param grant_id the grant_id
	 * @param grant_type the grant_type
	 * @return the int
	 */
	private int revokeImpl(SqlSession sqlsession, String grant_id,
			GRANT_TYPE grant_type) {
		int i = 0;
		if (ValidateUtils.isNullOrEmpty(grant_id) || ValidateUtils.isNullOrEmpty(grant_type)) {
			return 0;
		} else {
			HashMap map = new HashMap();
			map.put("grant_id", grant_id);
			map.put("grant_type", grant_type.value());
			i = sqlsession.delete("revoke", map);
		}
		return i;
	}

	/**
	 * 获取SqlSession对象，用于数据访问；使用完后记得close.
	 *
	 * @return the sql session
	 */
	protected SqlSession buildSession() {
		return DbUtils.builder().openSession();
	}

	/* (非 Javadoc)
	* <p>Title: accessPrivilege</p>
	* <p>Description: </p>
	* @see com.opensymphony.xwork2.Action#accessPrivilege()
	*/
	@Override
	public void accessPrivilege() {
		// TODO Auto-generated method stub

	}


	/**
	 * Gets the pagenation list.
	 *
	 * @return the pagenation list
	 */
	public ArrayList getPagenationList() {
		return pagenationList;
	}


	/**
	 * 设置翻页数据，和前台标签配合使用.
	 *
	 * @param pagenationList the new pagenation list
	 */
	public void setPagenationList(ArrayList pagenationList) {
		this.pagenationList = pagenationList;
	}


	/**
	 * Gets the page no.
	 *
	 * @return the page no
	 */
	public String getPageNo() {
		return pageNo;
	}


	/**
	 * Sets the page no.
	 *
	 * @param pageNo the new page no
	 */
	public void setPageNo(String pageNo) {
		if (pageNo == null || "".equals(pageNo)) {
			pageNo = "1";
		}
		this.pageNo = pageNo;
	}


	/**
	 * Gets the page count.
	 *
	 * @return the page count
	 */
	public String getPageCount() {
		return pageCount;
	}


	/**
	 * Sets the page count.
	 *
	 * @param pageCount the new page count
	 */
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}


	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public String getPageSize() {
		return pageSize;
	}


	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * Gets the row count.
	 *
	 * @return the row count
	 */
	public String getRowCount() {
		return rowCount;
	}

	/**
	 * Sets the row count.
	 *
	 * @param rowCount the new row count
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}


	/**
	 * Gets the task_id.
	 *
	 * @return the task_id
	 */
	public String getTask_id() {
		return task_id;
	}

	/**
	 * Sets the task_id.
	 *
	 * @param task_id the new task_id
	 */
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	
    /**
     * 记录操作日志到数据库.
     *
     * @param logType the log type
     * @param logContent the log content
     * @return true, if successful
     */
    protected boolean recodeLogToDB(String logType,String logContent){
    	BigDecimal logOperator = new BigDecimal(getUserDm()==null?"0":getUserDm());
    	return DbUtils.recodeLogToDB(logType, logOperator, logContent);
    }
      
    /**
     * 记录操作日志到数据库.
     *
     * @param logType the log type
     * @param logContent the log content
     * @param appendToLog the append to log
     * @return true, if successful
     */
    protected boolean recodeLogToDB(String logType,String logContent,boolean appendToLog){
    	BigDecimal logOperator = new BigDecimal(getUserDm()==null?"0":getUserDm());
    	if (appendToLog) {
			log.debug(logType+","+logContent);
		}
    	return DbUtils.recodeLogToDB(logType, logOperator, logContent);
    }
    
    /**
     * Send error report.
     *
     * @param Auth_userName the auth_user name
     * @param Auth_password the auth_password
     * @param subject the subject
     * @param msg the msg
     * @return true, if successful
     * @throws EmailException the email exception
     */
    public boolean sendErrorReport(String toAddr,String title,String content) throws EmailException{
    	 
        UserProfile profile = getUserProfileFromSession();
        String serverInfo = profile.getServerInfo();
        String clientInfo = profile.getUser().getLogin_remore_agent();
        String runTimeActionInfo = StringUtils.toString(ActionContext.getContext().getActionInvocation().getAction());
        String runTimeSystemInfo = StringUtils.toString(System.getenv());
        
        MailUtils util = new MailUtils("smtp.exmail.qq.com", "smtp.exmail.qq.com", "", "debug@jdframe.com", "jdframe@@107");
        Mail mail = new Mail();
        //serverInfo.concat("\r\t").concat(clientInfo).concat("\r\t").concat(runTimeSystemInfo).concat("\r\t").concat(runTimeActionInfo)
        mail.setContent(content);
        mail.setToAddr(toAddr);
        mail.setTitle(title);
        mail.setFromAddr("debug@jdframe.com");
        
        try {
			util.send(mail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    	return true;
    }
    
}
