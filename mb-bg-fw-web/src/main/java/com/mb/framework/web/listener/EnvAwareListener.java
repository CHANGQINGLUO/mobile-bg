/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Jul 23, 2013 4:19:47 PM
 * @author SPA

 *
 */
/**
 * 
 */
package com.mb.framework.web.listener;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mb.framework.constant.AppConstant;
import com.mb.framework.exception.SystemException;
import com.mb.framework.util.StringUtil;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * Determine the application environment based on host name and set environment flag.
 * Similar to HostnameAwareList Property file list holder, 
 * but it's to help with other resource loading outside of spring e.g. log4j
 *  
 * It should be first listener loaded by container, hence, 
 * should not use spring or any other libraries for this
 * 
 * Expected 2 context params APP_ENV_FLAG_ID and ENV_HOST_MAPPING
 *
 *  */

/* * APP_ENV_FLAG_ID : application specific key to set System property
 
 * ENV_HOST_MAPPING expected format: <ENV>-<HOSTNAME1>,<HOSTNAME2>,<HOSTNAME3>;
		 * e.g.
		  	SIT-a01bapp1a; 
			UAT-a01sapp1a, a01sapp2a;
			PROD-a01gapp1a, a01gapp2a;
	
 * once loaded, env system property will be set  
 *   
 */
public class EnvAwareListener implements ServletContextListener
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	private static final String APP_ENV_FLAG_ID = "APP_ENV_FLAG_ID";
	private static final String ENV_HOST_MAPPING = "ENV_HOST_MAPPING";
	
	private String flagId;
	private Map<String, String> envHostMap;
	private final String currentHostname;
	private String currentEnv;
	
	/**
	 * constructor
	 * @throws UnknownHostException
	 */
	public EnvAwareListener()throws UnknownHostException
	{
		 currentHostname = InetAddress.getLocalHost().getHostName().toUpperCase();
		 logger.info("EnvAwareListener Resolved hostname: "+currentHostname);
		 
		 if(StringUtil.isEmtpy(currentHostname))
		 {
			 throw new UnknownHostException("Error resolving hostname, hostname is null or empty: "+ currentHostname);
		 }
	}
	
	/**
	 * 
	 * This method is used for contextInitialized
	 * @param contextEvent
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextEvent)
	{
		ServletContext context = contextEvent.getServletContext();
		
		// read application specific env flag id from web.xml 
		loadFlagId(context);
		// read env host mapping from web.xml
		loadEnvHostMapping(context);
		
		determineCurrentEnv();
		
		//set system property 
		System.setProperty(flagId, currentEnv);
	}
	
	private void determineCurrentEnv()
	{
		currentEnv = AppConstant.ENV_DEV;
		for(String env : envHostMap.keySet()) 
		{
			String hostnames = envHostMap.get(env);
			hostnames = hostnames.toUpperCase().trim();
			if(hostnames.equals(currentHostname) || hostnames.startsWith(currentHostname+",") || hostnames.indexOf(","+currentHostname+",")>-1 || hostnames.endsWith(","+currentHostname)) 
			{
				logger.info("Found a match for current host: "+currentHostname+" matching with hostnames key: "+hostnames);
				logger.info("Environment for hostname: "+currentHostname+", ENV: "+currentEnv);
				currentEnv = env;
				break;
			}
		}
	}
	
	private void loadFlagId(ServletContext context)
	{
		flagId = context.getInitParameter(APP_ENV_FLAG_ID);
		if(StringUtil.isEmtpy(flagId))
		{
			throw new SystemException("Please set the context param: APP_ENV_FLAG_ID");
		}
	}
	
	private void loadEnvHostMapping(ServletContext context)
	{
		String hostEnvMapping = context.getInitParameter(ENV_HOST_MAPPING);
		if(StringUtil.isEmtpy(hostEnvMapping))
		{
			throw new SystemException("Please set the context param: ENV_HOST_MAPPING");
		}
		
		String[] hostEnvArray = StringUtil.split(hostEnvMapping, ";");
		String[] hostEnv = null;
		envHostMap = new HashMap<String, String>();
		for(String entry: hostEnvArray)
		{
			hostEnv = StringUtil.split(entry.trim(), "-");
			envHostMap.put(hostEnv[0].trim(), hostEnv[1].trim());
		}
	}
	
	/**
	 * 
	 * This method is used for contextDestroyed
	 * @param context
	 */
	@Override
	public void contextDestroyed(ServletContextEvent context)
	{
		logger.info("contextDestroyed method");
	}

	
}
