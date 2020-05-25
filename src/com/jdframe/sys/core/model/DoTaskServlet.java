package com.jdframe.sys.core.model;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.core.util.TaskUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_code;
import com.jdframe.sys.dao.model.T_sys_task;
import com.jdframe.sys.dao.model.T_sys_task_receive;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.model.DoTaskServlet.java
 * The Class DoTaskServlet.
 * Last-Modified-Time : 2013-11-8 10:46:57
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class DoTaskServlet extends HttpServlet {
     /**
	* @Fields serialVersionUID : TODO()
	*/
	private static final long serialVersionUID = -8573907367709423096L;
	
	/** The __log. */
	Logger __log = Logger.getLogger(this.getClass());
	/**
	 * Constructor of the object.
	 */
	public DoTaskServlet() {
		super();
	}
 

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 *  
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * @Description: TODO()
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskUtils.runTask(request, response);
	}
 
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
