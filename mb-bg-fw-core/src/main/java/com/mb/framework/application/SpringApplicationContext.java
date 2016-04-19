/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 17 Oct, 2014 11:40:43 am
 * @author SPA
 * @my-workbench-core-sg
 * SpringApplicationContext.java
 *
 */
package com.mb.framework.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author SPA
 *
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware
{

	private ApplicationContext applicationContext;
	/**
	 * 
	 */
	public SpringApplicationContext()
	{
	}

	/**
	 * This method is used for 
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;
	}

	/**
	 * @return the context
	 */
	public final ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

}
