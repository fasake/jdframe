package com.jdframe.sys.core.security;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.security.SecurityProtectFilter.java
 * The Class SecurityProtectFilter.
 * Last-Modified-Time : 2013-11-8 10:47:12
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class SecurityProtectFilter implements Filter {

	/** The log. */
	private Logger __log = Logger.getLogger(getClass());

	/** The list. */
	private static Vector __list = new Vector();

	/** The enabled. */
	private static String __enabled = "true";
	

	/*
	 * (非 Javadoc) <p>Title: destroy</p> <p>Description: </p>
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (非 Javadoc) <p>Title: doFilter</p> <p>Description: </p>
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		_doFilterImpl(arg0, arg1, arg2);

	}

	/**
	 * Do filter impl.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 * @param arg2
	 *            the arg2
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws IllegalAccessError
	 *             the illegal access error
	 * @throws ServletException
	 *             the servlet exception
	 */
	private void _doFilterImpl(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws UnsupportedEncodingException, IOException,
			IllegalAccessError, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest __httpServletRequest = (HttpServletRequest) arg0;
		HttpServletResponse __httpServletResponse = (HttpServletResponse) arg1;
		// 获取GET方法请求参数串
		String __queryString = __httpServletRequest.getQueryString();
		String __requesturi = __httpServletRequest.getRequestURI();

		// 是否启动,web.xml中配置的初始化参数
		if (__enabled.equalsIgnoreCase("true")) {
			// 开始XSS(METHOD:GET)和sql注入检测
			boolean __$isXssFind = false;
			// 对getRequestURI中的值进行检测判断
			if (__requesturi != null && !__requesturi.equalsIgnoreCase("null")) {
				__requesturi = java.net.URLDecoder.decode(__requesturi, "GB2312");

				if (__requesturi != null && !__requesturi.equalsIgnoreCase("null")) {
					String keyword = "";
					for (int i = 0; i < __list.size(); i++) {
						keyword = __list.get(i).toString();
						if (__requesturi.indexOf(keyword) != -1) {
							__$isXssFind = true;
							break;
						}
					}
					if (__$isXssFind) {

						__log.error("Found suspected cross-site scripting attacks, judge request address contains illegal characters::"
								+ java.net.URLEncoder.encode(keyword, "GB2312"));
						__httpServletResponse
								.sendError(__httpServletResponse.SC_FORBIDDEN);
						throw new java.lang.IllegalAccessError();
					}
				}
			}
			if (__queryString != null && !__queryString.equalsIgnoreCase("null")) {

				// 回车换行符 CR LF
				if (__queryString.toLowerCase().indexOf("%0d".toLowerCase()) != -1
						|| __queryString.toLowerCase().indexOf("%0a".toLowerCase()) != -1) {
					__log.error("Found suspected cross-site scripting attacks, judge request address contains illegal characters::CRLF");
					__httpServletResponse
							.sendError(__httpServletResponse.SC_FORBIDDEN);
					throw new java.lang.IllegalAccessError();
				}

				String src = java.net.URLDecoder.decode(__queryString, "GB2312");

				src += "_";// +queryString;
				String reg = "value\\(rs_.*\\)=";// ()需要转义
				String __src_after = src.replaceAll(reg, "=");
				if (__src_after != null && !__src_after.equalsIgnoreCase("null")) {
					String keyword = "";
					for (int i = 0; i < __list.size(); i++) {
						keyword = __list.get(i).toString();
						if (__src_after.indexOf(keyword) != -1) {
							__$isXssFind = true;
							break;
						}
					}
					if (__$isXssFind) {
						__log.error("Found suspected cross-site scripting attacks, judge request address contains illegal characters::"
								+ java.net.URLEncoder.encode(keyword, "GB2312"));
						__httpServletResponse
								.sendError(__httpServletResponse.SC_FORBIDDEN);
						throw new java.lang.IllegalAccessError();
					}
				}
			}
			// 开始XSS(METHOD:POST)和sql注入检测
			if (!__$isXssFind) {
				arg2.doFilter(new RequestWrapperXSS(__httpServletRequest,
						__httpServletResponse, __list), arg1);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	/*
	 * (非 Javadoc) <p>Title: init</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		_initImpl(arg0);
	}

	/**
	 * Inits the impl.
	 * 
	 * @param arg0
	 *            the arg0
	 */
	private void _initImpl(FilterConfig arg0) {
		__enabled = arg0.getInitParameter("enabled");
		if (__enabled == null || "".equals(__enabled)) {
			__enabled = "true";
		}
		__log.info("<System Security Protection is Running!>");
	}

	static {
		__list.add("'");
		__list.add("(");
		__list.add("<");
		__list.add(" or ");
		// list.add("and");
		__list.add("[");
		__list.add(".." + File.separator);
		// 请求参数不能能有脚步
		__list.add("script");
		__list.add("+");
		// list.add("-");
		__list.add("*");
		__list.add("%");

	}

	/**
	 * Do valid.
	 * 
	 * @param isValid
	 *            the is valid
	 */
	private static void doValid(boolean isValid) {
		if (isValid) {
			__enabled = "true";
		} else {
			__enabled = "false";
		}
	}
}

class RequestWrapperXSS extends HttpServletRequestWrapper {
	private Logger _log = Logger.getLogger(getClass());
	private HttpServletRequest __request;
	private HttpServletResponse __serlvetResponse;
	private boolean __isXssFind = false;
	private Vector __keywords = null;;

	public RequestWrapperXSS(HttpServletRequest servletRequest) {
		super(servletRequest);
		this.__request = servletRequest;
	}

	/**
	 * 
	 * @param servletRequest
	 * @param serlvetResponse
	 */
	private RequestWrapperXSS(HttpServletRequest servletRequest,
			HttpServletResponse serlvetResponse) {
		super(servletRequest);
		this.__request = servletRequest;
		this.__serlvetResponse = serlvetResponse;
	}

	public RequestWrapperXSS(HttpServletRequest servletRequest,
			HttpServletResponse serlvetResponse, Vector keywords) {
		super(servletRequest);
		this.__request = servletRequest;
		this.__serlvetResponse = serlvetResponse;
		this.__keywords = keywords;
	}

	public String[] getParameterValues(String name) {
		return getParameterValuesImpl(name);
	}

	private String[] getParameterValuesImpl(String name)
			throws IllegalAccessError {
		String[] values = super.getParameterValues(name);
		try {
				_xssCheck(values, __keywords);
		} catch (IllegalAccessError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public String getParameter(String para) {
		return getParameterImpl(para);
	}

	private String getParameterImpl(String para) throws IllegalAccessError {
		String postStrInfo = super.getParameter(para);

		try {
			__xssCheck(postStrInfo, __keywords);
		} catch (IllegalAccessError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postStrInfo;
	}

	public ServletInputStream getInputStream() {
		return getInputStreamImpl();
	}

	private ServletInputStream getInputStreamImpl() throws IllegalAccessError {
		// ServletInputStream
		ServletInputStream stream = null;
		// POST表单信息
		String postStrInfo = null;
		try {
			stream = __request.getInputStream();
			byte[] buffer = IOUtils.toByteArray(stream);
			postStrInfo = new String(buffer, "GB2312");
			// 拆分请求参数串
			String[] args = postStrInfo.split("\r\n");
			boolean isFile = false;
			for (int i = 0; i < args.length; i++) {
				String line = args[i];
				// 过滤分隔符，和请求参数名称
				if (line.trim().startsWith("-------------------")
						|| line.trim().startsWith("Content-Disposition")
						|| line.trim().startsWith("Content-Type")
						|| line.trim().equals("")) {
					if (line.trim().startsWith("Content-Type")) {// 说明是文件
						isFile = true;
					}
					if (line.trim().startsWith("-------------------") && isFile) {
						isFile = false;
					}
					continue;
				}
				if (!isFile) {
					__xssCheck(line, __keywords);
				}
			}
			// 验证完成
			final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
			// 生成新的ServletInputStream
			ServletInputStream sis = new ServletInputStream() {
				public int read() throws IOException {
					// TODO Auto-generated method stub
					return bais.read();
				}
			};
			stream = sis;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stream;
	}

	private void __xssCheck(String postStrInfo, Vector array)
			throws IOException, IllegalAccessError {
		if (postStrInfo == null)
			return;

		String __src = postStrInfo == null ? "null" : postStrInfo.toLowerCase();
		String __src_after = __src;
		__src_after = java.net.URLDecoder.decode(__src_after, "GB2312");
		// 验证XSS中是否包含相关关键字
		if (__src_after != null && !__src_after.equalsIgnoreCase("null")) {
			String _keyword = "";
			for (int i = 0; i < array.size(); i++) {
				_keyword = array.get(i).toString();
				if (__src_after.indexOf(_keyword) != -1) {
					__isXssFind = true;
					break;
				}
			}
			if (__isXssFind) {
				_log.error("Found suspected cross-site scripting attacks, judge request address contains illegal characters::"
						+ java.net.URLEncoder.encode(_keyword, "GB2312"));
				__serlvetResponse.sendError(__serlvetResponse.SC_FORBIDDEN);
				throw new java.lang.IllegalAccessError();
			}
		}

	}

	private void _xssCheck(String[] values, Vector array) throws IOException,
			IllegalAccessError {
		if (values == null) {
			return;
		}
		for (int j = 0; j < values.length; j++) {
			String __src = java.net.URLDecoder.decode(values[j], "GB2312");
			String __src_after =  java.net.URLDecoder.decode(__src, "GB2312");

			// 验证XSS中是否包含相关关键字
			if (__src_after != null && !__src_after.equalsIgnoreCase("null")) {
				String keyword = "";
				for (int i = 0; i < array.size(); i++) {
					keyword = array.get(i).toString();
					if (__src_after.indexOf(keyword) != -1) {
						__isXssFind = true;
						break;
					}
				}
				if (__isXssFind) {
					_log.error("Found suspected cross-site scripting attacks, judge request address contains illegal characters::"
							+ java.net.URLEncoder.encode(keyword, "GB2312"));
					__serlvetResponse.sendError(__serlvetResponse.SC_FORBIDDEN);
					throw new java.lang.IllegalAccessError();
				}
			}

		}
	}
}
