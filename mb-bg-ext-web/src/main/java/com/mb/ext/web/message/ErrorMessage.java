/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 28 May, 2014 5:44:32 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
package com.mb.ext.web.message;

import java.io.Serializable;

public class ErrorMessage implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String message;
	
	public ErrorMessage(String errorCode, String message)
	{
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public ErrorMessage()
	{
		super();
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getErrorCode()
	{
		return errorCode;
	}
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

}
