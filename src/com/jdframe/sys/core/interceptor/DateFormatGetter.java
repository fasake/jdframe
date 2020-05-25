package com.jdframe.sys.core.interceptor;

import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

import org.apache.log4j.Logger;

@SuppressWarnings("restriction")
public class DateFormatGetter implements sun.util.LocaleServiceProviderPool.LocalizedObjectGetter<java.text.spi.DateFormatProvider,DateFormat>  {
	Logger log = Logger.getLogger("");
	/**
	 * Title:  main
	 * Description: TODO(这里用一句话描述这个方法的作用)
	 * @param      
	 * @return  void  
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public DateFormat getObject(DateFormatProvider paramP, Locale paramLocale,
			String paramString, Object... paramArrayOfObject) {
		// TODO Auto-generated method stub
		System.out.println("===================================================>>>>");
		return new java.text.SimpleDateFormat("yyyy-mm-dd");
	}
 
}
