package com.qa.opencart.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	public static final Logger logger = LogManager.getLogger(Log.class);
	
	public static void info(String message) {
		logger.info(message);
	}
	
	public static void warn(String message) {
		logger.warn(message);
	}
	
	public static void error(String message) {
		logger.warn(message);
	}
	
	public static void error(String message, Exception e) {
		logger.warn(message,e);
	}
	
	public static void debug(String message) {
		logger.debug(message);
	}

}
