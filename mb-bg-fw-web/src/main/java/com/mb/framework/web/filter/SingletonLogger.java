package com.mb.framework.web.filter;

import org.apache.log4j.Logger;

public class SingletonLogger {
	private static Logger logger = Logger.getLogger(SingletonLogger.class);
	private static SingletonLogger singletonLogger;

	private SingletonLogger() {
	}

	public synchronized static SingletonLogger getInstance() {
		if (singletonLogger == null) {
			singletonLogger = new SingletonLogger();
		}
		return singletonLogger;
	}

	public void info(String message) {
		logger.trace(message);
	}

	public static Logger getLogger() {
		return logger;
	}
}
