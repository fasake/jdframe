package com.jdframe.sys.core.security;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.dao.model.T_sys_notice;
 

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.security.CommonDownLoad.java
 * The Class CommonDownLoad.
 * Last-Modified-Time : 2013-11-8 10:47:19
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class CommonDownLoad extends HttpServlet {
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -4734377344391314181L;
	
	/** The log. */
	Logger __log = Logger.getLogger(getClass());
	/**
	 * Constructor of the object.
	 */
	public CommonDownLoad() {
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
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String _P_noticeId = request.getParameter("noticeId");
        SqlSession __sqlsession = DbUtils.builder().openSession();
        //通知公告附件下载
        try{
        	
        	if(_P_noticeId!=null && !"".equals(_P_noticeId.trim())){
        		
        		T_sys_notice __notice  = __sqlsession.selectOne("getNoticeByNoticeId",_P_noticeId);
        		if(__notice!=null){
        			String attach_uri = __notice.getNotice_attach_uri();
        			String attach_file_name = __notice.getNotice_attach_name();
        			String attach_content_type = __notice.getNotice_attach_content_type();
        			File f = new File(attach_uri);
        			if(!f.exists()){
        				response.sendError(HttpServletResponse.SC_NOT_FOUND);  
        	            return ;  
        			}
        			__log.debug("下载公告附件, 文件名称："+attach_file_name+" 字节："+f.length()+" 文件类型： "+attach_content_type+" 文件路径 文件路径："+attach_uri);
        			response.setCharacterEncoding("GBK");
        			BufferedInputStream __bis = new BufferedInputStream(new FileInputStream(f));
            		response.reset();
            		response.setContentType("application/octet-stream;charset=GBK");
            		response.setContentLength((int)f.length());
            		//new String(filename.getBytes("工程编码"),"ISO-8859-1")
            		String attachment_filename = new String(attach_file_name.getBytes("GBK"),"ISO-8859-1");
            		response.addHeader("Content-Disposition", "attachment; filename="+ attachment_filename );
           		    OutputStream __bos = new BufferedOutputStream(response.getOutputStream());
           		    try{
           		    	IOUtils.copy(__bis, __bos);
           		    	__bos.flush();
            		    __log.debug("bos.flush");
           		    }finally{
           		    	if(__bis != null){
           		    	   __bis.close();
           		    	   __bos.close();
           		    	   __bis = null;
           		    	   __bos = null;
           		    	}
           		    }
        		}else{
        			response.setContentType("text/html");
        			PrintWriter __$out = response.getWriter();
        			__$out.println("<script>alert('文件不存在！');</script>");
        			__$out.flush();
        			__$out.close();
        		}
        		__notice =  null;
            }
        }finally{
        	__sqlsession.close();
        	__sqlsession = null;
        }
        
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
