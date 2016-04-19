/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jun, 2014 4:05:20 pm
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.util;

import com.mb.framework.util.property.PropertyRepository;


public class ConfigurationManager extends PropertyRepository
{
	/**
	 * This method is used for getting default language
	 * @return
	 */
	public String getDefaultLanguage(){
		return repository.getProperty(ConfigConstants.DEFAULT_LANGUAGE);
	}
	
}
