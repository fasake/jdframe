package com.jdframe.sys.core.util;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.jdframe.sys.dao.model.T_sys_log;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.util.DbUtils.java
 * The Class DbUtils.
 * Last-Modified-Time : 2013-11-8 10:49:23
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class DbUtils {

	/** The __log. */
	static Logger __log = Logger.getLogger(DbUtils.class);
	
	/** The __sql session. */
	private  static SqlSessionFactory __sqlSession = null; 

	/** The Constant DB_TYPE_ORACLE. */
	public static final String DB_TYPE_ORACLE = "oracle";

	/** The Constant DB_TYPE_MYSQL. */
	public static final String DB_TYPE_MYSQL = "mysql";

	/** The Constant DB_TYPE_SQLSERVER. */
	public static final String DB_TYPE_SQLSERVER = "sqlserver";

	/** The Constant DB_TYPE_DB2. */
	public static final String DB_TYPE_DB2 = "db2";

	/** The Constant DB_TYPE_SYBASE. */
	public static final String DB_TYPE_SYBASE = "sybase";

	/** The Constant DATE_FORMAT_JAVA. */
	private static final String DATE_FORMAT_JAVA = "yyyy-MM-dd HH:mm:ss";

	/** The Constant ORACLE_DATE_FORMAT_DB. */
	private static final String ORACLE_DATE_FORMAT_DB = "yyyy-mm-dd hh24:mi:ss";

	/** The Constant MYSQL_DATE_FORMAT_DB. */
	private static final String MYSQL_DATE_FORMAT_DB = "%Y-%m-%d %H:%i:%s";

	/**
	 * To sql string.
	 * 
	 * @param value
	 *            the value
	 * @param dbType
	 *            the db type
	 * @return the string
	 */
	public static String toSqlString(Object value, String dbType) {
		String valStr = "''";
		if ((value instanceof Date)) {
			if ("mysql".equals(dbType)) {
				valStr = "STR_TO_DATE('" + dateToStr((Date) value) + "','"
						+ "%Y-%m-%d %H:%i:%s" + "')";
			} else {
				valStr = "to_date('" + dateToStr((Date) value) + "','"
						+ "yyyy-mm-dd hh24:mi:ss" + "')";
			}

		} else if ((value instanceof Long)) {
			valStr = String.valueOf((Long) value);
		} else if ((value instanceof Integer)) {
			valStr = String.valueOf((Integer) value);
		} else if ((value instanceof Double)) {
			valStr = String.valueOf((Double) value);
		} else if (((String) value).equalsIgnoreCase("sysdate")) {
			valStr = (String) value;
		} else {
			valStr = "'" + (String) value + "'";
		}
		return valStr;
	}

	/**
	 * Date to str.
	 * 
	 * @param d
	 *            the d
	 * @return the string
	 */
	private static String dateToStr(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(d);
	}

	/**
	 * _recode log to db.
	 * 
	 * @param logType
	 *            the log type
	 * @param logOperator
	 *            the log operator
	 * @param logContent
	 *            the log content
	 * @return true, if successful
	 */
	public static boolean recodeLogToDB(String logType,
			BigDecimal logOperator, String logContent) {
		if (ValidateUtils.isNullOrEmpty(logType)) {
			__log.error("日志记录错误，日志类型不能为空！");
			return false;
		}
		if (ValidateUtils.isNullOrEmpty(logContent)) {
			//__log.error("日志记录错误，日志内容不能为空！");
			return false;
		}
		SqlSession ss = buildSqlSession();
		try {
			BigDecimal logId = ss.selectOne("t_sys_log$getNewLogId");
			Date logDatetime = new Date();
			T_sys_log syslog = new T_sys_log(logId, logType, logOperator,
					logDatetime, logContent);
			int i = ss.update("t_sys_log$_insert", syslog);
			if (i > 0) {
				ss.commit();
				return true;
			}

		} finally {
			if (ss != null)
				ss.close();
		}
		return false;
	}

	/**
	 * _build sql session.
	 * 
	 * @return the sql session
	 */
	public static SqlSession buildSqlSession() {
		return DbUtils.builder().openSession();

	}
	
	/**
	 * Builds the url.
	 *
	 * @param driver the driver
	 * @param addr the addr
	 * @param port the port
	 * @param dbName the db name
	 * @return the string
	 */
	public static String buildURL(String driver, String addr, String port,
			String dbName) {
		String str = driver.toLowerCase();
		if (str.indexOf("oracle") >= 0) {
			return "jdbc:oracle:thin:@" + addr + ":" + port + ":" + dbName;
		}
		if (str.indexOf("sqlserver") >= 0) {
			return "jdbc:sqlserver://" + addr + ":" + port + ";DatabaseName="
					+ dbName;
		}

		if (str.indexOf("mysql") >= 0) {
			return "jdbc:mysql://" + addr + ":" + port + "/" + dbName;
		}

		return "";
	}
	/**
	 * 
	* Title:  _buildConnect
	* Description: TODO(这里用一句话描述这个方法的作用)
	* @param      
	* @return  Connection  
	*
	 */
	public static Connection buildConnect(String driver, String url,String user,String password) throws ClassNotFoundException, SQLException {
	   Class.forName(driver);
	   return java.sql.DriverManager.getConnection(url, user, password) ;
	}
	
	/**
	 * _get auto increment lsb (number.).
	 *
	 * @param driver the driver
	 * @param url the url
	 * @param user the user
	 * @param password the password
	 * @param tablename the tablename
	 * @param columnName the column name
	 * @return the long
	 */
	public static BigDecimal getAutoIncrementLsb(String tablename,String columnName){
		
		Connection conn = null;
		try {
			conn = buildSqlSession().getConnection();
			java.sql.Statement stat = conn.createStatement();
			java.sql.ResultSet rs  = stat.executeQuery("select max("+columnName+")+1 from "+tablename);
			if(rs.next()){
				return rs.getBigDecimal(1);
			}
			rs.close();
			rs = null;
			stat.close();
			stat = null;
			if ( conn!=null )conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return new BigDecimal(0);
	}
	
	
	/**
	 * _get random lsb(String.).
	 *
	 * @return the string
	 */
	public static String getRandomStringLsb(){
		return StringUtils.randomString();
	}
	
	/**
  	 * 获取默认SQL会话工厂，使用默认配置文件$ClassPath/DBConfig.xml.
  	 *
  	 * @return the sql session factory
  	 */
	  public static SqlSessionFactory builder(){
		  if(__sqlSession==null){
			     Reader __reader;
				try {
					__reader = Resources.getResourceAsReader("DBConfig.xml");
					__sqlSession = new SqlSessionFactoryBuilder().build(__reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  return __sqlSession;
	  }
	 
 	/**
 	 * 获取SQL会话工厂，使用配置文件configPath.
 	 *
 	 * @param configPath the config path
 	 * @return the sql session factory
 	 */
	  public static SqlSessionFactory builder(String configPath){
		  if(__sqlSession==null){
			     Reader reader;
				try {
					reader = Resources.getResourceAsReader(configPath);
					__sqlSession = new SqlSessionFactoryBuilder().build(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  return __sqlSession;
	  }
	  
	 
	 
}