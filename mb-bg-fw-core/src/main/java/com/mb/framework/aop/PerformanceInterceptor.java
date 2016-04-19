/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Aug 12, 2013 5:42:29 PM
 * @author SPA

 *
 */
/**
 * 
 */
package com.mb.framework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.mb.framework.util.log.LogHelper;


/**
 * @author SPA
 * 
 * Interceptor to measure method performance.. AOP style.
 * Use only for SIT, turn it off for UAT onwards
 *
 */
public class PerformanceInterceptor implements MethodInterceptor 
{
	private LogHelper log = LogHelper.getInstance(PerformanceInterceptor.class.getName());
	
	/**
	 * 
	 * This method is used for invoke method
	 * @param methodInvocation
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable 
	{
		boolean isSuccess=false;
		long start = System.currentTimeMillis();
		try 
		{
			Object result = methodInvocation.proceed();
			isSuccess = true;
			return result;
		}
		finally 
		{
			long end = System.currentTimeMillis();
			long timeMs = end - start;

			//Short class name
			String className = methodInvocation.getMethod().getDeclaringClass().getSimpleName();
			Object[] arguments = methodInvocation.getArguments();
			
			String argumentTypes = getArgumentTypes(arguments);
			
			log.info("["+className+"."+ methodInvocation.getMethod().getName()+ argumentTypes + " ] took: " + timeMs +"ms., isSuccess: "+isSuccess);
		}
	}
	
	private String getArgumentTypes(Object[] arguments)
	{
		StringBuilder argumentTypes = null;
		String argument = "()";
		
		if(arguments!=null && arguments.length >0)
		{
			argumentTypes = new StringBuilder("( ");
			for(int i=0; i< arguments.length; i++)
			{
				if(arguments[i] != null)
				{
					argumentTypes.append(arguments[i].getClass().getSimpleName());	
				}
				
				if(i < arguments.length -1)
				{
					argumentTypes.append(" ,");
				}
			}
			argumentTypes.append(" )");
		}
		if(argumentTypes!=null){ 
			argument = argumentTypes.toString();
		}
		
		return argument;
	}
	
	/**
	 * 
	 * This method is used for set logger name
	 * @param logger
	 */
	public void setLoggerName(String logger)
	{
		log = LogHelper.getInstance(logger);
	}

}

