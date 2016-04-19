package com.mb.ext.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionCheckFilter  extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
	{
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathInfo = uri.substring(uri.indexOf(contextPath) + contextPath.length());
		if(!pathInfo.equals("/web/admin_login") && 
				!pathInfo.equals("/web/admin_login_submit")&&
				!pathInfo.equals("/web/admin_logout")){
		
			String sessionId = request.getSession().getId();
			String loginId = (String) request.getSession().getAttribute(sessionId);
			if(loginId == null){
				//response.sendError(400);
				response.sendRedirect("/mb-bg-ext-web/web/admin_login");
			}
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
