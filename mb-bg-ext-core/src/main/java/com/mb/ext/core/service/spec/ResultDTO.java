/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 16 Jun, 2014 7:52:09 pm
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
public class ResultDTO extends AbstractBaseDTO
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7308629992968567471L;

	private String code;

	private String message;
	
	private Object body;

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	/**
	 * 
	 */
	public ResultDTO()
	{
		super();
	}

	/**
	 * 
	 * @param statusCode
	 * @param statusMessage
	 */
	public ResultDTO(String statusCode, String statusMessage)
	{
		super();
		this.code = statusCode;
		this.message = statusMessage;
	}

	/**
	 * 
	 * @param statusCode
	 * 
	 */
	public ResultDTO(String statusCode)
	{
		super();
		this.code = statusCode;
	}

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

}
