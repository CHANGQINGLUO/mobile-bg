/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 20 Aug, 2014 11:48:07 am
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
 * @since 20 Aug, 2014 11:48:07 am
 * @author SPA
 * @mb-bg-fw-web
 * ReqRespLoggerFilter.java
 *
 */
package com.mb.framework.web.filter;

/**
 * @author SPA
 *
 */
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.log.mask.DataMaskingUtil;

/**
 * 
 * @author SPA
 * 
 */
public class ReqRespLoggerFilter implements Filter {

	private final LogHelper logger = LogHelper.getInstance(this.getClass()
			.getName());
	
	private DataMaskingUtil dataMaskingUtil;

	/**
	 * 
	 * This method is not implemented
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	   
		ServletContext servletContext = filterConfig.getServletContext();
	    
		WebApplicationContext webApplicationContext = 
	            WebApplicationContextUtils.getWebApplicationContext(servletContext);

	    AutowireCapableBeanFactory autowireCapableBeanFactory =
	           webApplicationContext.getAutowireCapableBeanFactory();

	    autowireCapableBeanFactory.autowireBeanProperties(
				this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
		
		logger.trace("This method implementation not needed");
	}

	/**
	 * 
	 * This method is used to log the request and response body.
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)

	throws IOException, ServletException {

		try {

			HttpServletRequest httpServletRequest = (HttpServletRequest) request;

			HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//			Map<String, String> requestMap = this
//					.getTypesafeRequestMap(httpServletRequest);

			BufferedRequestWrapper bufferedReqest = new BufferedRequestWrapper(
					httpServletRequest);

			BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(
					httpServletResponse);

			long startTime = System.currentTimeMillis();

			// Create the log message for Request
			final StringBuilder logMessage = new StringBuilder("[")
					.append(httpServletRequest.getRemoteAddr()).append(" ")
					.append(httpServletRequest.getMethod()).append(" ")
					.append(httpServletRequest.getPathInfo()).append("]");

			String requestBody = bufferedReqest.getRequestBody();

			try{
				mdcUser(requestBody);
			}catch(Exception e){
				logger.error("failed to add mdc user");
			}
			
			logger.info("REQ:" + logMessage.toString() + " " + dataMaskingUtil.jsonMaskData(requestBody));
			chain.doFilter(bufferedReqest, bufferedResponse);
			logger.info("RES:" + logMessage.toString() + " "+ dataMaskingUtil.jsonMaskData(bufferedResponse.getContent()));

			long endTime = System.currentTimeMillis();

			logger.info("SERVICES PROCESS PERF : "
					+ httpServletRequest.getPathInfo() + ", Duration: "
					+ (endTime - startTime) + "ms");

		} catch (Exception e) {
			logger.error("Error occurred in logging the request and response",
					e);
		} finally {
			MDC.remove("User");
		}

	}

	private void mdcUser(String requestBody) {
		int indexofUser = requestBody.indexOf("user");
		int indexOfServerDateTime = requestBody.indexOf("serverDateTime");
		if (indexofUser > -1 && indexOfServerDateTime > 2) {
			String userPair = requestBody.substring(indexofUser,indexOfServerDateTime - 2);
			int indexOf = userPair.indexOf(":");
			if(indexOf > -1){
				String user = userPair.substring(indexOf + 1);
				if(StringUtils.isNotBlank(user)){
					user = removeDoubleQuetos(user);
				}else
					user = "NA";
				MDC.put("User", user.trim());
			}
		}
	}

	private String removeDoubleQuetos(String value) {
		String temp = value;
		if (StringUtils.isNotBlank(temp)) {
			temp = value.replaceAll("\"", "");
		}
		return temp;
	}

	/**
	 * 
	 * This method is used for fetching the request method parameters.
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	private Map<String, String> getTypesafeRequestMap(HttpServletRequest request) {

		Map<String, String> typesafeRequestMap = new HashMap<String, String>();

		Enumeration<?> requestParamNames = request.getParameterNames();

		while (requestParamNames.hasMoreElements()) {

			String requestParamName = (String) requestParamNames.nextElement();

			String requestParamValue = request.getParameter(requestParamName);

			typesafeRequestMap.put(requestParamName, requestParamValue);

		}

		return typesafeRequestMap;

	}

	/**
	 * 
	 * This method is not implemented
	 */
	@Override
	public void destroy() {
		logger.trace("This method implementation not needed");
	}

	/**
	 * @return the dataMaskingUtil
	 */
	public final DataMaskingUtil getDataMaskingUtil() {
		return dataMaskingUtil;
	}

	/**
	 * @param dataMaskingUtil the dataMaskingUtil to set
	 */
	public final void setDataMaskingUtil(DataMaskingUtil dataMaskingUtil) {
		this.dataMaskingUtil = dataMaskingUtil;
	}

}