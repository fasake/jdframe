package com.jdframe.sys.biz.task;

import com.jdframe.sys.core.action.JdframeAction;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.biz.task.TaskAction.java
 * The Class TaskAction.
 * Last-Modified-Time : 2013-11-8 10:45:43
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public abstract class TaskAction extends JdframeAction {
	
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	
	/** The task_status. */
	private String task_status;
    
    /** The task_title. */
    private String task_title;
	
	/**
	 * Gets the task_status.
	 *
	 * @return the task_status
	 */
	public String getTask_status() {
		return task_status;
	}
	
	/**
	 * Sets the task_status.
	 *
	 * @param task_status the new task_status
	 */
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	
	/**
	 * Gets the task_title.
	 *
	 * @return the task_title
	 */
	public String getTask_title() {
		return task_title;
	}
	
	/**
	 * Sets the task_title.
	 *
	 * @param task_title the new task_title
	 */
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
    
	
}
