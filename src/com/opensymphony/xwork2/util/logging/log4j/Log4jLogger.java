package com.opensymphony.xwork2.util.logging.log4j;


import org.apache.log4j.Priority;
import org.apache.log4j.Logger;

public class Log4jLogger implements com.opensymphony.xwork2.util.logging.Logger {
	
	private org.apache.log4j.Logger log;
	
	public Log4jLogger(org.apache.log4j.Logger logger){
		this.log = logger;
	}
	@Override
	public void trace(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.trace(msg);
	}

	@Override
	public void trace(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.trace(msg, ex);
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return log.isTraceEnabled();
	}

	@Override
	public void debug(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.debug(msg);
	}

	@Override
	public void debug(String msg, Object... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i].toString());
		}
		log.debug(msg);
	}

	@Override
	public void debug(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.debug(msg, ex);
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return log.isDebugEnabled();
	}

	@Override
	public void info(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.info(msg);
	}

	@Override
	public void info(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.info(msg, ex);
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return log.isInfoEnabled();
	}

	@Override
	public void warn(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.warn(msg);
	}

	@Override
	public void warn(String msg, Object... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i].toString());
		}
		log.warn(msg);
	}

	@Override
	public void warn(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.warn(msg, ex);
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return log.isEnabledFor(Priority.WARN);
	}

	@Override
	public void error(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.error(msg);
	}

	@Override
	public void error(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.error(msg,ex);
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return log.isEnabledFor(Priority.ERROR);
	}

	@Override
	public void fatal(String msg, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.fatal(msg);
	}

	@Override
	public void fatal(String msg, Throwable ex, String... args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			msg = msg.replace("(#"+i+")", args[i]);
		}
		log.fatal(msg, ex);
	}

	@Override
	public boolean isFatalEnabled() {
		// TODO Auto-generated method stub
		return log.isEnabledFor(Priority.FATAL);
	}

	 

}
