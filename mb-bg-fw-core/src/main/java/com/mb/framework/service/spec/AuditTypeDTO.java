/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 19 Jun, 2014 2:29:33 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
/**
 * 
 */
package com.mb.framework.service.spec;

import java.util.Date;

/**
 * @author SPA
 * 
 */
public class AuditTypeDTO extends AbstractBaseDTO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2584849677137301178L;

	private String channelUUID;

	private String componentKey;

	private String functionKey;
	
	private Date createDate;

	/**
	 * @return the channelUUID
	 */
	public String getChannelUUID()
	{
		return channelUUID;
	}

	/**
	 * @param channelUUID
	 *            the channelUUID to set
	 */
	public void setChannelUUID(String channelUUID)
	{
		this.channelUUID = channelUUID;
	}

	/**
	 * @return the componentKey
	 */
	public String getComponentKey()
	{
		return componentKey;
	}

	/**
	 * @param componentKey
	 *            the componentKey to set
	 */
	public void setComponentKey(String componentKey)
	{
		this.componentKey = componentKey;
	}

	/**
	 * @return the functionKey
	 */
	public String getFunctionKey()
	{
		return functionKey;
	}

	/**
	 * @param functionKey
	 *            the functionKey to set
	 */
	public void setFunctionKey(String functionKey)
	{
		this.functionKey = functionKey;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate()
	{
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

}
