/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 21 May, 2014 4:13:23 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
package com.mb.framework.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.mb.framework.util.log.LogHelper;

public class BadRequestFilter extends OncePerRequestFilter
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * 
	 * This method is used for filter request
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathInfo = uri.substring(uri.indexOf(contextPath) + contextPath.length());
		if(!pathInfo.startsWith("/images")&&!pathInfo.startsWith("/script")&&!pathInfo.startsWith("/styles")&&!pathInfo.startsWith("/rest") && !"/index.jsp".equals(pathInfo) && !"/login.jsp".equals(pathInfo) && !"/".equals(pathInfo)){
			response.sendError(400);
			response.sendRedirect("error.jsp");
		}
		
		try
		{
			filterChain.doFilter(request, response);
		}
		catch (Exception e)
		{
			logger.error("Encounter error while ", e);
		}
		
		
	}

}
