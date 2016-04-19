/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 16 Jun, 2014 5:52:19 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
/**
 * 
 */
package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

/**
 * @author SPA
 * 
 */
public class HeaderDTO extends AbstractBaseDTO
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String appName;

	private String user;

	private String requestDateTime;

	private String requestType;

	private String customerEmailToSend;
	
	private String customerName;
	

	/**
	 * @return the appName
	 */
	public String getAppName()
	{
		return appName;
	}

	/**
	 * @param appName
	 *            the appName to set
	 */
	public void setAppName(String appName)
	{
		this.appName = appName;
	}

	/**
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user)
	{
		this.user = user;
	}

	/**
	 * @return the requestDateTime
	 */
	public String getRequestDateTime()
	{
		return requestDateTime;
	}

	/**
	 * @param requestDateTime
	 *            the requestDateTime to set
	 */
	public void setRequestDateTime(String requestDateTime)
	{
		this.requestDateTime = requestDateTime;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType()
	{
		return requestType;
	}

	/**
	 * @param requestType
	 *            the requestType to set
	 */
	public void setRequestType(String requestType)
	{
		this.requestType = requestType;
	}

	/**
	 * @return the customerEmailToSend
	 */
	public String getCustomerEmailToSend()
	{
		return customerEmailToSend;
	}

	/**
	 * @param customerEmailToSend
	 *            the customerEmailToSend to set
	 */
	public void setCustomerEmailToSend(String customerEmailToSend)
	{
		this.customerEmailToSend = customerEmailToSend;
	}


	/**
	 * @return the customerName
	 */
	public String getCustomerName()
	{
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	
	
	

}
