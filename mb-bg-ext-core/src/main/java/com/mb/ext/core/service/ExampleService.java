/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.ext.core.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.ext.core.entity.UserEntity;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface ExampleService<T extends BodyDTO>
{
	/**
	 * 
	 * This method is used for inserting all the customer details
	 * information.
	 * 
	 * @param body
	 * @return 
	 */
	String addEPDetails(BodyDTO body, HeaderDTO header) throws BusinessException;


	/**
	 * 
	 * This method is used for inserting user
	 * information.
	 * 
	 * @param body
	 * @return 
	 */
	String addUser (UserDTO userDTO) throws BusinessException;
	
}
