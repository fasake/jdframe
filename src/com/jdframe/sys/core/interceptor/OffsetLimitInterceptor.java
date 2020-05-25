package com.jdframe.sys.core.interceptor;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.rmi.NoSuchObjectException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.*;

import org.apache.ibatis.executor.*;
import org.apache.ibatis.executor.statement.*;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import com.jdframe.sys.biz.login.LoginAction;
import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.core.util.StringUtils;
import com.jdframe.sys.core.util.ValidateUtils;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.interceptor.OffsetLimitInterceptor.java
 * The Class OffsetLimitInterceptor.
 * Last-Modified-Time : 2013-11-8 10:46:22
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})  
public class OffsetLimitInterceptor implements Interceptor{
	
	/** The log. */
	Logger log = Logger.getLogger("");
	
	/** The dialect. */
	private static String dialect = ""; //数据库方言  
    
    /** The page sql id. */
    private static String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)  
    
    /** The __logs. */
    private static volatile String __logs = null;//日志信息
    
    /** The __operator. */
    private static String __operator = null; //操作员信息；
    
    /* (非 Javadoc)
    * <p>Title: intercept</p>
    * <p>Description: </p>
    * @param ivk
    * @return
    * @throws Throwable
    * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
    */
    public Object intercept(Invocation ivk) throws Throwable {  
    	Object o =  _interceptImpl(ivk);  
    	if(__logs != null){
    		
    		new Thread(){
    			public void run(){
    				try {
						sleep(500);
						DbUtils.recodeLogToDB("INTERCEPTOR",new  BigDecimal(ValidateUtils.isNullOrEmpty(__operator)?"0":__operator), __logs);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    		}.start();
    		
    	}
    	return o;
    }



	/**
	 * _intercept impl.
	 *
	 * @param ivk the ivk
	 * @return the object
	 * @throws InvocationTargetException the invocation target exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws NoSuchObjectException the no such object exception
	 * @throws SQLException the sQL exception
	 */
	private Object _interceptImpl(Invocation ivk)
			throws InvocationTargetException, IllegalAccessException,
			NoSuchFieldException, NoSuchObjectException, SQLException {
		__logs = null;__operator=null;
		//获取当前的struts2.action实例
    	ActionContext ac = ActionContext.getContext();
    	//兼容DWR
    	if(ac==null || ac.getActionInvocation()==null){
    		return ivk.proceed();
    	}
    	 Object invokeAction = ac.getActionInvocation().getAction();
    	 String method_name = ac.getName();
    	 String actionInfo = invokeAction.toString().substring(0,invokeAction.toString().indexOf("@"));
    	 String ActionMethod = method_name;
    	 String SqlId = "";
    	 String SqlScript = "";
    	 String SQLArguments = "";
    	 String operationInfo = "";
    	 
    	 JdframeAction  action = null; 
    	 String userDm = "";
    	 if(ivk.getTarget() instanceof RoutingStatementHandler){  
             RoutingStatementHandler statementHandler = (RoutingStatementHandler)ivk.getTarget();  
             BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");  
             MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");  
             BoundSql boundSql = delegate.getBoundSql();  
             Object parameterObject = boundSql.getParameterObject();
            
                SqlId = mappedStatement.getId();
    	         if(invokeAction instanceof JdframeAction){     
    	         	action = (JdframeAction) invokeAction; 
    	         	String sql = boundSql.getSql(); 
    	         	if(mappedStatement.getId().equalsIgnoreCase("com.jdframe.sys.dao.mappers.t_sys_user.getUserByDmAndPass")){
    	         		SqlScript = sql.replaceAll("[\n\r\t]", " ") ;
    	         		SQLArguments = StringUtils.toString(parameterObject);
    	         	}else{
    	         	   userDm = "";
    	         	   if(action instanceof LoginAction){
    	         		  userDm =  ((LoginAction)action).getUser().getUser_dm();
    	         	   }else{
    	         		  Object obj  = action.getSession(true).getAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE);
	    	      			if(obj!=null){
	    	      				 
	    	      				if(((com.jdframe.sys.core.model.UserProfile)obj).getUser() != null ){
	    	      					userDm = ((com.jdframe.sys.core.model.UserProfile)obj).getUser().getUser_dm();
	    	      				}
	    	      			}
    	         	   }
    	         	  SqlScript = sql.replaceAll("[\n\r\t]", " ") ;
  	         		  SQLArguments = StringUtils.toString(parameterObject);
  	         		  operationInfo = userDm;
    	         	}
    	         	String info ="\r\t";
    	         	info+="/***********************JDF Debug Tracking Information******************************\r\t";
    	         	info+=" *     -Action: "+actionInfo+"\r\t";
    	         	info+=" *     -ActionMethod: "+ActionMethod+"\r\t";
    	         	info+=" *     -Operation: "+userDm+"\r\t";
    	         	info+=" *     -SqlId: "+SqlId+"\r\t";
    	         	info+=" *     -SqlScript: "+SqlScript+"\r\t";
    	         	info+=" *     -SQLArguments: "+SQLArguments+"\r\t";
    	         	info+=" ***********************************************************************************";
    	         	log.debug(info);
    	         	long serial_number = System.currentTimeMillis();
    	         	if(SqlId.equalsIgnoreCase("com.jdframe.sys.dao.mapping.T_sys_log.t_sys_log$_insert")){
    	         		__logs = null;
    	         		__operator = null;
    	         	}else{
	    	         	__logs = "#"+serial_number+"#Invoke:\r\t\nAction:"+actionInfo+"\r\t\nAction.method:"+ActionMethod+" \r\t\nSqlId:"+SqlId+" \r\t\nSqlScript:"+SqlScript+" \r\t\nSQLArguments:"+SQLArguments;
	    	         	__operator = userDm;
    	         	}
    	         	
    	         }else{   
    	                 throw new NoSuchObjectException(invokeAction.getClass().getName()+"IframeAction instance does not exist！");  
    	         }  
            	 
           
             
             
    	 }
    	
        // TODO Auto-generated method stub  
        if(ivk.getTarget() instanceof RoutingStatementHandler){  
            RoutingStatementHandler statementHandler = (RoutingStatementHandler)ivk.getTarget();  
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");  
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");  
            log.debug("执行SQL别名:"+mappedStatement.getId());
            if(mappedStatement.getId().matches(pageSqlId)){ //拦截需要分页的SQL  
                BoundSql boundSql = delegate.getBoundSql();  
                 
                Object parameterObject = boundSql.getParameterObject();//分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空  
                if(parameterObject==null){  
                    throw new NullPointerException("parameterObject尚未实例化！");  
                }else{  
                    Connection connection = (Connection) ivk.getArgs()[0];  
                    String sql = boundSql.getSql();  
                    String countSql = "select count(0) RowsCount from (" + sql+ ") tab_alias1075"; //记录统计  
                    log.debug(actionInfo+"The Original Sql Is::"+sql);
                    log.debug(actionInfo+"The Original Count Sql Is::"+countSql);
                    PreparedStatement countStmt = connection.prepareStatement(countSql);  
                    BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),countSql,boundSql.getParameterMappings(),parameterObject);  
                    _setParameters(countStmt,mappedStatement,countBS,parameterObject);  
                    ResultSet rs = countStmt.executeQuery();  
                    int count = 0;  
                    if (rs.next()) {  
                        count = rs.getInt("ROWSCOUNT");  
                    }  
                    rs.close();  
                    countStmt.close();  
                    
                   // IframeAction action = null;  
                    if(invokeAction instanceof JdframeAction){     
                    	action = (JdframeAction) invokeAction;  
                    	action.setRowCount(Integer.toString(count));  
                    	if(count==0){
                    		action.setPageNo("0");
                    	}
                    }else{   
                            throw new NoSuchObjectException(invokeAction.getClass().getName()+"IframeAction Onstance Does Not Exist！");  
                    }  
                    String pageSql = _generatePageSql(sql,action);  
                    ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); //将分页sql语句反射回BoundSql.  
                }  
            }  
        }  
        return ivk.proceed();
	}  
  
      
     
    /**
     * Sets the parameters.
     *
     * @param ps the ps
     * @param mappedStatement the mapped statement
     * @param boundSql the bound sql
     * @param parameterObject the parameter object
     * @throws SQLException the sQL exception
     */
    private void _setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {  
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());  
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
        if (parameterMappings != null) {  
            Configuration configuration = mappedStatement.getConfiguration();  
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();  
            MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);  
            for (int i = 0; i < parameterMappings.size(); i++) {  
                ParameterMapping parameterMapping = parameterMappings.get(i);  
                if (parameterMapping.getMode() != ParameterMode.OUT) {  
                    Object value;  
                    String propertyName = parameterMapping.getProperty();  
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);  
                    if (parameterObject == null) {  
                        value = null;  
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {  
                        value = parameterObject;  
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {  
                        value = boundSql.getAdditionalParameter(propertyName);  
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {  
                        value = boundSql.getAdditionalParameter(prop.getName());  
                        if (value != null) {  
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));  
                        }  
                    } else {  
                        value = metaObject == null ? null : metaObject.getValue(propertyName);  
                    }  
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();  
                    if (typeHandler == null) {  
                        throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId());  
                    }  
                    log.debug("PreparedStatement Parameter Name: "+(propertyName==null?"":propertyName)+" Value: ["+(value==null?"":value.toString())+"] index:"+(i+1)+" JdbcType:"+(parameterMapping.getJdbcType()==null?"":parameterMapping.getJdbcType().name()));
                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());  
                }  
            }  
        }  
    }  
    
      
    /**
     * Generate page sql.
     *
     * @param sql the sql
     * @param action the action
     * @return the string
     */
    private String _generatePageSql(String sql,JdframeAction action){  
        if(action!=null && ValidateUtils.notEmpty(dialect)){  
            StringBuffer pageSql = new StringBuffer();  
            
            int count = Integer.parseInt(action.getRowCount());//总记录数
			int current_index = Integer.parseInt(action.getPageNo());//当前页
			int perCount = Integer.parseInt(action.getPageSize());//每页记录数
			int startRow = ((current_index>0?current_index:0)-1) * perCount;//开始记录数
			if(startRow < 0){
				startRow = 0;
			}
			int endRow = startRow + perCount;//结束记录数		
			//降低精度
			action.setPageCount(String.valueOf((int)Math.ceil(Double.valueOf(count)/ Double.valueOf(perCount))));	
			  
			if(endRow>count)endRow=count;
			
            if("mysql".equals(dialect)){  
                pageSql.append(sql);  
                pageSql.append(" limit "+startRow+","+endRow);  
            }else if("oracle".equals(dialect)){  
                pageSql.append("select * from (select tab_alias1075.*,ROWNUM row_id from (");  
                pageSql.append(sql);  
                pageSql.append(")  tab_alias1075 where ROWNUM<=");  
                pageSql.append(endRow);  
                pageSql.append(") where row_id>");  
                pageSql.append(startRow);  
            }  
            log.debug("Computational pages of SQL is::"+pageSql);
            return pageSql.toString();  
        }else{  
            return sql;  
        }  
    }  
      
    /* (非 Javadoc)
    * <p>Title: plugin</p>
    * <p>Description: </p>
    * @param arg0
    * @return
    * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
    */
    public Object plugin(Object arg0) {  
        // TODO Auto-generated method stub  
        return Plugin.wrap(arg0, this);  
    }  
     
    /* (非 Javadoc)
    * <p>Title: setProperties</p>
    * <p>Description: </p>
    * @param p
    * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
    */
    public void setProperties(Properties p) {  
        _setPropertiesImpl(p);  
    }



	/**
	 * _set properties impl.
	 *
	 * @param p the p
	 */
	private void _setPropertiesImpl(Properties p) {
		dialect = p.getProperty("dialect");  
        if (ValidateUtils.isEmpty(dialect)) {  
            try {  
                throw new PropertyException("dialect property is not found!");  
            } catch (PropertyException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        pageSqlId = p.getProperty("pageSqlId");  
        if (ValidateUtils.isEmpty(pageSqlId)) {  
            try {  
            	pageSqlId = "select";
                throw new PropertyException("pageSqlId property is not found!");  
            } catch (PropertyException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }
	}  
      
}  