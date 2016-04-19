/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Jul 12, 2013 10:25:48 AM
 * @author SPA

 *
 */
/**
 * 
 */
package com.mb.framework.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.framework.util.property.PropertyRepository;


/**
 * @author SPA
 *
 */
public abstract class AbstractService
{
	
	@Autowired
	protected PropertyRepository propertyRepository;
	
}
