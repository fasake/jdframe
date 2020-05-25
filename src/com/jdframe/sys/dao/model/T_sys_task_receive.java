package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.dao.model.T_sys_task_receive.java
 * The Class T_sys_task_receive.
 * Last-Modified-Time : 2013-11-8 10:50:26
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class T_sys_task_receive implements T_vo {
	
	/** The task_id. */
	private String task_id;//待办事项ID
	
	/** The task_receiver. */
	private String task_receiver;//接收人员ID
	
	/** The task_receive_date. */
	private String task_receive_date;//接收日期
	
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
	 * Gets the task_receiver.
	 *
	 * @return the task_receiver
	 */
	public String getTask_receiver() {
		return task_receiver;
	}
	
	/**
	 * Sets the task_receiver.
	 *
	 * @param task_receiver the new task_receiver
	 */
	public void setTask_receiver(String task_receiver) {
		this.task_receiver = task_receiver;
	}
	
	/**
	 * Gets the task_receive_date.
	 *
	 * @return the task_receive_date
	 */
	public String getTask_receive_date() {
		return task_receive_date;
	}
	
	/**
	 * Sets the task_receive_date.
	 *
	 * @param task_receive_date the new task_receive_date
	 */
	public void setTask_receive_date(String task_receive_date) {
		this.task_receive_date = task_receive_date;
	}
}
