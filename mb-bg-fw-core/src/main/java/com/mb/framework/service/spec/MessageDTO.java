/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jun, 2014 3:25:12 pm
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.service.spec;

public class MessageDTO extends AbstractBaseDTO
{
	private static final long serialVersionUID = 854019083355402736L;

	private String messageKey;

	private String messageValue;

	private String language;

	/**
	 * @return the messageKey
	 */
	public String getMessageKey()
	{
		return messageKey;
	}

	/**
	 * @param messageKey
	 *            the messageKey to set
	 */
	public void setMessageKey(String messageKey)
	{
		this.messageKey = messageKey;
	}

	/**
	 * @return the messageValue
	 */
	public String getMessageValue()
	{
		return messageValue;
	}

	/**
	 * @param messageValue
	 *            the messageValue to set
	 */
	public void setMessageValue(String messageValue)
	{
		this.messageValue = messageValue;
	}

	/**
	 * @return the language
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

}
