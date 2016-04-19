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
 * Log4jMDCFilter.java
 *
 */
package com.mb.framework.web.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
public class LoggerFilter extends OncePerRequestFilter {

	private final LogHelper logger = LogHelper.getInstance(this.getClass()
			.getName());

	/**
	 * 
	 * This method is used to add detail info from request in log files.
	 * 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			// Map<String, String> map = new HashMap<String, String>();

			// String user = request.getRemoteUser();
			// String uri = request.getRequestURL().toString();
			String requestId = null;
			if(request.getSession() != null)requestId = request.getSession().getId();
			if(StringUtils.isNotBlank(requestId)){
				requestId = UUID.randomUUID().toString();
			}
			
			MDC.put("RequestId", requestId);

			filterChain.doFilter(request, response);
		} catch (Exception e) {
			logger.error("Encounter error while ", e);
		} finally {
			MDC.remove("RequestId");
			// MDC.remove("URI");
		}

	}

}
