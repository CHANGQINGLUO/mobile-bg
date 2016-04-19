/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Jul 14, 2013 8:26:56 PM
 * @author SPA

 *
 */
/**
 * 
 */
package com.mb.framework.service.spec;

import java.io.Serializable;

import com.mb.framework.util.StringUtil;


/**
 * @author SPA
 *
 */
public abstract class AbstractBaseDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get object in form of string
	 * @return
	 */
	public String toString()
	{
		return StringUtil.objectToString(this);
	}

}
