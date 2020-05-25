package com.jdframe.sys.core.model;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.Tokens.java
 * The Class Tokens.
 * Last-Modified-Time : 2013-11-8 10:46:50
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class Tokens implements java.lang.Cloneable {
	// 登录用户信息
	/** The Constant USER_PROFILE. */
	public static final String _USER_PROFILE = "$USER_PROFILE";
	// 登录用户菜单
	/** The user menu. */
	public static String _USER_MENU = "$USER_MENU";
	// 登录用户岗位
	/** The Constant USER_STATION. */
	public static final String _USER_STATION = "$USER_STATION";
	// 登录用户角色
	/** The Constant USER_ROLE. */
	public static final String _USER_ROLE = "$USER_ROLE";

	// 权限类

	/**
	 * The Enum Task_status.
	 * 
	 * @copyright www.jdframe.com
	 * @Package com.jdframe.sys.core.modelTokens.java
	 * @Description: TODO
	 * @author: support@jdframe.com
	 * @date: 2013-09-151 11:18:46
	 * @version v1.0
	 */

	public enum TASK_STATUS {

		/** The task status watting. */
		TASK_STATUS_WATTING("0"),
		/** The task status processed. */
		TASK_STATUS_PROCESSED("1"),
		/** The task status timeout. */
		TASK_STATUS_TIMEOUT("2");

		/** The value. */
		private String value = "0";

		/**
		 * Instantiates a new task_status.
		 * 
		 * @param i
		 *            the i
		 */
		TASK_STATUS(String i) {
			this.value = i;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

		/*
		 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
		 * 
		 * @return
		 * 
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return this.value;
		}
	}

	/**
	 * The Enum priority.
	 * 
	 * @copyright www.jdframe.com
	 * @Package com.jdframe.sys.core.modelTokens.java
	 * @Description: TODO
	 * @author: support@jdframe.com
	 * @date: 2013-09-151 11:18:46
	 * @version v1.0
	 */
	public enum PRIORITY {

		/** The critical. */
		CRITICAL("0"),
		/** The major. */
		MAJOR("1"),
		/** The minor. */
		MINOR("2"),
		/** The trivial. */
		TRIVIAL("3");

		/** The value. */
		private String value = "0";

		/**
		 * Instantiates a new priority.
		 * 
		 * @param i
		 *            the i
		 */
		PRIORITY(String i) {
			this.value = i;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

		/*
		 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
		 * 
		 * @return
		 * 
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return this.value;
		}
	}

	/**
	 * The Enum Grant_type.
	 * 
	 * @copyright www.jdframe.com
	 * @Package com.jdframe.sys.core.modelTokens.java
	 * @Description: TODO
	 * @author: support@jdframe.com
	 * @date: 2013-09-151 11:18:46
	 * @version v1.0
	 */
	public static enum GRANT_TYPE {

		/** The grant role asso menu. */
		GRANT_ROLE_ASSO_MENU("DM_ROLE_ASSO_MENU"),
		/** The grant station asso role. */
		GRANT_STATION_ASSO_ROLE("DM_STATION_ASSO_ROLE"),
		/** The grant user asso station. */
		GRANT_USER_ASSO_STATION("DM_USER_ASSO_STATION");

		/** The value. */
		private String value = "DM_ROLE_ASSO_MENU";

		/**
		 * Instantiates a new grant_type.
		 * 
		 * @param i
		 *            the i
		 */
		GRANT_TYPE(String i) {
			this.value = i;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

		/*
		 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
		 * 
		 * @return
		 * 
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return this.value;
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println("0"
				.equals(Tokens.TASK_STATUS.TASK_STATUS_WATTING.value));
	}
}
