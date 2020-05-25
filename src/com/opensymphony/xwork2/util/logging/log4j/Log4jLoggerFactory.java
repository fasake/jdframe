package com.opensymphony.xwork2.util.logging.log4j;


import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class Log4jLoggerFactory extends LoggerFactory {

	@Override
	protected Logger getLoggerImpl(Class<?> cls) {
		// TODO Auto-generated method stub
		return new Log4jLogger( org.apache.log4j.Logger.getLogger(cls));
	}

	@Override
	protected Logger getLoggerImpl(String name) {
		// TODO Auto-generated method stub
		return new Log4jLogger( org.apache.log4j.Logger.getLogger(name));
	}

	 

}
