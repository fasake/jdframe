package com.jdframe.sys.core.util;

import java.io.UnsupportedEncodingException;


// TODO: Auto-generated Javadoc
/**
 * The Path : com.jdframe.sys.core.util.EncodingUtils.java
 * The Class EncodingUtils.
 * Last-Modified-Time : 2013-11-8 10:49:19
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class EncodingUtils {

	/**
	 * To g b2312.
	 * 
	 * @param src
	 *            the src
	 * @return the string
	 */
	public String toGB2312(String src) {
		try {
			return new String(src.getBytes(), "GB2312");
		} catch (UnsupportedEncodingException ex) {
		}
		return null;
	}

	/**
	 * To is o88591.
	 * 
	 * @param src
	 *            the src
	 * @return the string
	 */
	public String toISO88591(String src) {
		try {
			return new String(src.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException ex) {
		}
		return null;
	}

	/**
	 * To gbk.
	 * 
	 * @param src
	 *            the src
	 * @return the string
	 */
	public String toGBK(String src) {
		try {
			return new String(src.getBytes(), "GBK");
		} catch (UnsupportedEncodingException ex) {
		}
		return null;
	}

	/**
	 * To ut f8.
	 * 
	 * @param src
	 *            the src
	 * @return the string
	 */
	public String toUTF8(String src) {
		try {
			return new String(src.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
		return null;
	}
}