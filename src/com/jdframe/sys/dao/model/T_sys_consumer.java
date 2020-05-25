package com.jdframe.sys.dao.model;

import java.sql.Timestamp;

import com.jdframe.sys.core.model.T_vo;

// TODO: Auto-generated Javadoc
/**
 * The Class T_sys_consumer.
 *
 * @copyright www.jdframe.com
 * @Package com.jdframe.sys.dao.modelT_sys_consumer.java
 * @Description: TODO
 * @author: support@jdframe.com
 * @date: 2013-09-15 17:16:43
 * @version v1.0
 */
public class T_sys_consumer implements T_vo{
	//纳税人编号,税务登记证，纳税人名称，登录名称，登录密码，联系电话，证件类型，证件号码，注册ip
	private String nsrbh, swdjzh, nsrmc, dlmc, dlmm, lxdh, zjlx, zjhm, zcip;
	//注册日期，
    private Timestamp zcrq;
    //有效标志，
    private char yxbz;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " 纳税人编号"+this.getNsrbh()+" 登录名称："+this.getDlmc()+" 登录密码："+this.getDlmm()+" 联系电话："+this.getLxdh()+" 纳税人编号："+this.getNsrbh()+" 纳税人名称："+this.getNsrmc()+" 税务登记证："+this.getSwdjzh()+" 有效标志："+this.getYxbz()+" 注册ip："+this.getZcip()+" 注册日期："+this.getZcrq()+" 证件号码："+this.getZjhm()+" 证件类型："+this.getZjlx();
	}

	/**
	 * Gets the nsrbh.
	 *
	 * @return the nsrbh
	 */
	public String getNsrbh() {
		return nsrbh;
	}

	/**
	 * Sets the nsrbh.
	 *
	 * @param nsrbh the new nsrbh
	 */
	public void setNsrbh(String nsrbh) {
		this.nsrbh = nsrbh;
	}

	/**
	 * Gets the swdjzh.
	 *
	 * @return the swdjzh
	 */
	public String getSwdjzh() {
		return swdjzh;
	}

	/**
	 * Sets the swdjzh.
	 *
	 * @param swdjzh the new swdjzh
	 */
	public void setSwdjzh(String swdjzh) {
		this.swdjzh = swdjzh;
	}

	 
	/**
	 * Gets the nsrmc.
	 *
	 * @return the nsrmc
	 */
	public String getNsrmc() {
		return nsrmc;
	}

	/**
	 * Sets the nsrmc.
	 *
	 * @param nsrmc the new nsrmc
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	/**
	 * Gets the dlmc.
	 *
	 * @return the dlmc
	 */
	public String getDlmc() {
		return dlmc;
	}

	/**
	 * Sets the dlmc.
	 *
	 * @param dlmc the new dlmc
	 */
	public void setDlmc(String dlmc) {
		this.dlmc = dlmc;
	}

	/**
	 * Gets the dlmm.
	 *
	 * @return the dlmm
	 */
	public String getDlmm() {
		return dlmm;
	}

	/**
	 * Sets the dlmm.
	 *
	 * @param dlmm the new dlmm
	 */
	public void setDlmm(String dlmm) {
		this.dlmm = dlmm;
	}

	/**
	 * Gets the lxdh.
	 *
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}

	/**
	 * Sets the lxdh.
	 *
	 * @param lxdh the new lxdh
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/**
	 * Gets the zjlx.
	 *
	 * @return the zjlx
	 */
	public String getZjlx() {
		return zjlx;
	}

	/**
	 * Sets the zjlx.
	 *
	 * @param zjlx the new zjlx
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	/**
	 * Gets the zjhm.
	 *
	 * @return the zjhm
	 */
	public String getZjhm() {
		return zjhm;
	}

	/**
	 * Sets the zjhm.
	 *
	 * @param zjhm the new zjhm
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
 

	/**
	 * Gets the zcrq.
	 *
	 * @return the zcrq
	 */
	public Timestamp getZcrq() {
		return zcrq;
	}

	/**
	 * Sets the zcrq.
	 *
	 * @param zcrq the new zcrq
	 */
	public void setZcrq(Timestamp zcrq) {
		this.zcrq = zcrq;
	}

	/**
	 * Gets the yxbz.
	 *
	 * @return the yxbz
	 */
	public char getYxbz() {
		return yxbz;
	}

	/**
	 * Sets the yxbz.
	 *
	 * @param yxbz the new yxbz
	 */
	public void setYxbz(char yxbz) {
		this.yxbz = yxbz;
	}

	/**
	 * Gets the zcip.
	 *
	 * @return the zcip
	 */
	public String getZcip() {
		return zcip;
	}

	/**
	 * Sets the zcip.
	 *
	 * @param zcip the new zcip
	 */
	public void setZcip(String zcip) {
		this.zcip = zcip;
	}
	
}
