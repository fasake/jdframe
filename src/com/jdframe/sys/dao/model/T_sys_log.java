package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;
import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.dao.model.T_sys_log.java
 * The Class T_sys_log.
 * Last-Modified-Time : 2013-11-8 10:50:55
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class T_sys_log implements T_vo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_LOG.LOG_ID //remark is :null
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    private BigDecimal logId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_LOG.LOG_TYPE //remark is :null
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    private String logType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_LOG.LOG_OPERATOR //remark is :null
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    private BigDecimal logOperator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_LOG.LOG_DATETIME //remark is :null
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    private Date logDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SYS_LOG.LOG_CONTENT //remark is :null
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    private String logContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_LOG
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public T_sys_log(BigDecimal logId, String logType, BigDecimal logOperator, Date logDatetime, String logContent) {
        this.logId = logId;
        this.logType = logType;
        this.logOperator = logOperator;
        this.logDatetime = logDatetime;
        this.logContent = logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SYS_LOG
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public T_sys_log() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_LOG.LOG_ID
     *
     * @return the value of T_SYS_LOG.LOG_ID
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public BigDecimal getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_LOG.LOG_ID
     *
     * @param logId the value for T_SYS_LOG.LOG_ID
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public void setLogId(BigDecimal logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_LOG.LOG_TYPE
     *
     * @return the value of T_SYS_LOG.LOG_TYPE
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public String getLogType() {
        return logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_LOG.LOG_TYPE
     *
     * @param logType the value for T_SYS_LOG.LOG_TYPE
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_LOG.LOG_OPERATOR
     *
     * @return the value of T_SYS_LOG.LOG_OPERATOR
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public BigDecimal getLogOperator() {
        return logOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_LOG.LOG_OPERATOR
     *
     * @param logOperator the value for T_SYS_LOG.LOG_OPERATOR
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public void setLogOperator(BigDecimal logOperator) {
        this.logOperator = logOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_LOG.LOG_DATETIME
     *
     * @return the value of T_SYS_LOG.LOG_DATETIME
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public Date getLogDatetime() {
        return logDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_LOG.LOG_DATETIME
     *
     * @param logDatetime the value for T_SYS_LOG.LOG_DATETIME
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public void setLogDatetime(Date logDatetime) {
        this.logDatetime = logDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SYS_LOG.LOG_CONTENT
     *
     * @return the value of T_SYS_LOG.LOG_CONTENT
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SYS_LOG.LOG_CONTENT
     *
     * @param logContent the value for T_SYS_LOG.LOG_CONTENT
     *
     * @mbggenerated Sat Jul 27 23:43:49 CST 2013
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }
}