/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 28 May, 2014 5:47:42 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
package com.mb.ext.web.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Errors implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<ErrorMessage> errors =  new ArrayList<ErrorMessage>();;

	public void appendError(String errorCode, String message)
	{
		ErrorMessage error = new ErrorMessage(errorCode, message);
		errors.add(error);
	}

	public List<ErrorMessage> getErrors()
	{
		return errors;
	}

	public void setErrors(List<ErrorMessage> errors)
	{
		this.errors = errors;
	}

}
