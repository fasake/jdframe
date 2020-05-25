package work.dao.model;

import java.math.BigDecimal;
import java.util.Date;

public class T_work_tiden extends T_work_tidenKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WORK_TIDEN.OPERATEDATE //remark is :null
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    private Date operatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WORK_TIDEN.TAXES //remark is :null
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    private BigDecimal taxes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WORK_TIDEN.STRATDATE //remark is :null
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    private Date stratdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WORK_TIDEN.ENDDATE //remark is :null
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    private Date enddate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_WORK_TIDEN.TCLASS //remark is :null
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    private String tclass;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_WORK_TIDEN
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public T_work_tiden(BigDecimal linenumber, String tpayer, Date operatedate, BigDecimal taxes, Date stratdate, Date enddate, String tclass) {
        super(linenumber, tpayer);
        this.operatedate = operatedate;
        this.taxes = taxes;
        this.stratdate = stratdate;
        this.enddate = enddate;
        this.tclass = tclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_WORK_TIDEN
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public T_work_tiden() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WORK_TIDEN.OPERATEDATE
     *
     * @return the value of T_WORK_TIDEN.OPERATEDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public Date getOperatedate() {
        return operatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WORK_TIDEN.OPERATEDATE
     *
     * @param operatedate the value for T_WORK_TIDEN.OPERATEDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WORK_TIDEN.TAXES
     *
     * @return the value of T_WORK_TIDEN.TAXES
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public BigDecimal getTaxes() {
        return taxes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WORK_TIDEN.TAXES
     *
     * @param taxes the value for T_WORK_TIDEN.TAXES
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WORK_TIDEN.STRATDATE
     *
     * @return the value of T_WORK_TIDEN.STRATDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public Date getStratdate() {
        return stratdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WORK_TIDEN.STRATDATE
     *
     * @param stratdate the value for T_WORK_TIDEN.STRATDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public void setStratdate(Date stratdate) {
        this.stratdate = stratdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WORK_TIDEN.ENDDATE
     *
     * @return the value of T_WORK_TIDEN.ENDDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WORK_TIDEN.ENDDATE
     *
     * @param enddate the value for T_WORK_TIDEN.ENDDATE
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WORK_TIDEN.TCLASS
     *
     * @return the value of T_WORK_TIDEN.TCLASS
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public String getTclass() {
        return tclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WORK_TIDEN.TCLASS
     *
     * @param tclass the value for T_WORK_TIDEN.TCLASS
     *
     * @mbggenerated Wed Jan 08 17:05:34 CST 2014
     */
    public void setTclass(String tclass) {
        this.tclass = tclass == null ? null : tclass.trim();
    }
}