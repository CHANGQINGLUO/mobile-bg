/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jul, 2014 5:37:26 pm
 * @author SPA
 * @mb-bg-fw-web
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jul, 2014 5:37:26 pm
 * @author SPA
 * @mb-bg-fw-web
 * RequestLoggerFilter.java
 *
 */
package com.mb.framework.web.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

/**
 * @author SPA
 * 
 */
public class RequestLoggerFilter extends AbstractRequestLoggingFilter {
	public RequestLoggerFilter() {
		super.setMaxPayloadLength(Integer.MAX_VALUE);
	}

	@Override
	protected void afterRequest(HttpServletRequest arg0, String arg1) {
		SingletonLogger.getInstance().info(arg1);
	}

	@Override
	protected void beforeRequest(HttpServletRequest arg0, String arg1) {
		return;
	}}
