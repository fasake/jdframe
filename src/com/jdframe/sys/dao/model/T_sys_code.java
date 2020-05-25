package com.jdframe.sys.dao.model;

import com.jdframe.sys.core.model.T_vo;


// TODO: Auto-generated Javadoc
/**
 * The Class T_sys_code.
 *
 * @copyright www.jdframe.com
 * @Package com.jdframe.sys.dao.model 
 * @Description: TODO
 * @author: support@jdframe.com
 * @date: 2013-09-15 17:08:51
 * @version v1.0
 */
public class T_sys_code implements T_vo{
	
	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;

	/** The code_no. */
	private String code_no; //代码编码;
	
	/** The code_name. */
	private String code_name; //代码名称;
	
	/** The code_type. */
	private String code_type; //名称类型;
	
	/** The cacheable. */
	private String cacheable; //是否缓冲;
	
	/** The n1. */
	private String n1; //附加信息;
	
	/** The n2. */
	private String n2; //附加信息;

    
	
	/**
	 * Gets the code_no.
	 *
	 * @return the code_no
	 */
	public String getCode_no() {
		return code_no;
	}



	/**
	 * Sets the code_no.
	 *
	 * @param code_no the new code_no
	 */
	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}



	/**
	 * Gets the code_name.
	 *
	 * @return the code_name
	 */
	public String getCode_name() {
		return code_name;
	}



	/**
	 * Sets the code_name.
	 *
	 * @param code_name the new code_name
	 */
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}



	/**
	 * Gets the code_type.
	 *
	 * @return the code_type
	 */
	public String getCode_type() {
		return code_type;
	}



	/**
	 * Sets the code_type.
	 *
	 * @param code_type the new code_type
	 */
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}





	/**
	 * Gets the cacheable.
	 *
	 * @return the cacheable
	 */
	public String getCacheable() {
		return cacheable;
	}



	/**
	 * Sets the cacheable.
	 *
	 * @param cacheable the new cacheable
	 */
	public void setCacheable(String cacheable) {
		this.cacheable = cacheable;
	}



	/**
	 * Gets the n1.
	 *
	 * @return the n1
	 */
	public String getN1() {
		return n1;
	}



	/**
	 * Sets the n1.
	 *
	 * @param n1 the new n1
	 */
	public void setN1(String n1) {
		this.n1 = n1;
	}



	/**
	 * Gets the n2.
	 *
	 * @return the n2
	 */
	public String getN2() {
		return n2;
	}



	/**
	 * Sets the n2.
	 *
	 * @param n2 the new n2
	 */
	public void setN2(String n2) {
		this.n2 = n2;
	}

    

	/* (非 Javadoc)
	* <p>Title: hashCode</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Object#hashCode()
	*/
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getCode_no().hashCode()+this.getCode_type().hashCode();
	}



	/* (非 Javadoc)
	* <p>Title: equals</p>
	* <p>Description: </p>
	* @param obj
	* @return
	* @see java.lang.Object#equals(java.lang.Object)
	*/
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof T_sys_code){
			T_sys_code code = (T_sys_code)obj;
			if(code.getCode_no().equals(this.getCode_no()) && code.getCode_type().equals(this.getCode_type())){
				return true;
			}
		}
		return false;
	}



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
