/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 28 May, 2014 5:57:10 pm
 * @author SPA
 *
 */
package com.mb.ext.web.util;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.mb.ext.core.message.ErrorCode;
import com.mb.ext.web.message.Errors;


public class MessageHelper
{
	public static Errors createError(String errorCode, String message)
	{
		Errors errors = new Errors();
		errors.appendError(errorCode, message);
		return errors;
	}

	public static String getMessageByErrorId(MessageSource messageSource,String errorCode)
	{
		Locale currentLocale = LocaleContextHolder.getLocale();
		if (StringUtils.isNotBlank(errorCode))
		{
			return messageSource.getMessage(errorCode, null, currentLocale);
		}

		return getDefaultMessage(messageSource);
	}

	public static String getDefaultMessage(MessageSource messageSource)
	{
		return messageSource.getMessage(getDefaultErrorCode(), null, LocaleContextHolder.getLocale());
	}

	public static String getDefaultMessage(MessageSource messageSource, Locale locale)
	{
		return messageSource.getMessage(getDefaultErrorCode(), null, locale);
	}

	public static String getDefaultErrorCode()
	{
		return ErrorCode.ERROR_ENTITY_NOT_FOUND;
	}
}
