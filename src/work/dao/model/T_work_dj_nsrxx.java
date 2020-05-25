package work.dao.model;

import com.jdframe.sys.core.model.T_vo;
import java.math.BigDecimal;
import java.util.Date;

public class T_work_dj_nsrxx implements T_vo {
    private String nsrsbm;

    private String nsrmc;

    private String zgswjgDm;

    private String fddbrmc;

    private String fddbrzjhm;

    private String frdbrzjDm;

    private String fddbrdh;

    private String swdjzlxDm;

    private String swdjzh;

    private Date djzjyqxqsrq;

    private Date djzjyqxzzrq;

    private String nsrztDm;

    private BigDecimal qysdssblxDm;

    public T_work_dj_nsrxx(String nsrsbm, String nsrmc, String zgswjgDm, String fddbrmc, String fddbrzjhm, String frdbrzjDm, String fddbrdh, String swdjzlxDm, String swdjzh, Date djzjyqxqsrq, Date djzjyqxzzrq, String nsrztDm, BigDecimal qysdssblxDm) {
        this.nsrsbm = nsrsbm;
        this.nsrmc = nsrmc;
        this.zgswjgDm = zgswjgDm;
        this.fddbrmc = fddbrmc;
        this.fddbrzjhm = fddbrzjhm;
        this.frdbrzjDm = frdbrzjDm;
        this.fddbrdh = fddbrdh;
        this.swdjzlxDm = swdjzlxDm;
        this.swdjzh = swdjzh;
        this.djzjyqxqsrq = djzjyqxqsrq;
        this.djzjyqxzzrq = djzjyqxzzrq;
        this.nsrztDm = nsrztDm;
        this.qysdssblxDm = qysdssblxDm;
    }

    public T_work_dj_nsrxx() {
        super();
    }

    public String getNsrsbm() {
        return nsrsbm;
    }

    public void setNsrsbm(String nsrsbm) {
        this.nsrsbm = nsrsbm == null ? null : nsrsbm.trim();
    }

    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc == null ? null : nsrmc.trim();
    }

    public String getZgswjgDm() {
        return zgswjgDm;
    }

    public void setZgswjgDm(String zgswjgDm) {
        this.zgswjgDm = zgswjgDm == null ? null : zgswjgDm.trim();
    }

    public String getFddbrmc() {
        return fddbrmc;
    }

    public void setFddbrmc(String fddbrmc) {
        this.fddbrmc = fddbrmc == null ? null : fddbrmc.trim();
    }

    public String getFddbrzjhm() {
        return fddbrzjhm;
    }

    public void setFddbrzjhm(String fddbrzjhm) {
        this.fddbrzjhm = fddbrzjhm == null ? null : fddbrzjhm.trim();
    }

    public String getFrdbrzjDm() {
        return frdbrzjDm;
    }

    public void setFrdbrzjDm(String frdbrzjDm) {
        this.frdbrzjDm = frdbrzjDm == null ? null : frdbrzjDm.trim();
    }

    public String getFddbrdh() {
        return fddbrdh;
    }

    public void setFddbrdh(String fddbrdh) {
        this.fddbrdh = fddbrdh == null ? null : fddbrdh.trim();
    }

    public String getSwdjzlxDm() {
        return swdjzlxDm;
    }

    public void setSwdjzlxDm(String swdjzlxDm) {
        this.swdjzlxDm = swdjzlxDm == null ? null : swdjzlxDm.trim();
    }

    public String getSwdjzh() {
        return swdjzh;
    }

    public void setSwdjzh(String swdjzh) {
        this.swdjzh = swdjzh == null ? null : swdjzh.trim();
    }

    public Date getDjzjyqxqsrq() {
        return djzjyqxqsrq;
    }

    public void setDjzjyqxqsrq(Date djzjyqxqsrq) {
        this.djzjyqxqsrq = djzjyqxqsrq;
    }

    public Date getDjzjyqxzzrq() {
        return djzjyqxzzrq;
    }

    public void setDjzjyqxzzrq(Date djzjyqxzzrq) {
        this.djzjyqxzzrq = djzjyqxzzrq;
    }

    public String getNsrztDm() {
        return nsrztDm;
    }

    public void setNsrztDm(String nsrztDm) {
        this.nsrztDm = nsrztDm == null ? null : nsrztDm.trim();
    }

    public BigDecimal getQysdssblxDm() {
        return qysdssblxDm;
    }

    public void setQysdssblxDm(BigDecimal qysdssblxDm) {
        this.qysdssblxDm = qysdssblxDm;
    }
}