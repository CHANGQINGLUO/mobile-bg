/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 21 May, 2014 3:55:54 pm
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

public class CorsFilter extends OncePerRequestFilter
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	public static final String OPTIONS ="OPTIONS";
	public static final String GET ="GET";
	public static final String POST ="POST";
	

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

		if (OPTIONS.equals(request.getMethod()) || GET.equals(request.getMethod()) || POST.equals(request.getMethod()))
		{

			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
			response.addHeader("Access-Control-Max-Age", "1800");// 30 min

		}
		try
		{
			filterChain.doFilter(request, response);
		}
		catch (Exception e)
		{
			logger.error("Encounter error while perform CORS filter.",e);
		}
	}
}
