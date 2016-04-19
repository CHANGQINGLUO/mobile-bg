/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 1:25:57 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.EnumEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface EnumService{

	/**
	 * This method is used to insert the EnumEntity
	 * 
	 * @param EnumEntity
	 * @return 
	 */
	public void addEnum(EnumEntity enumEntity) throws BusinessException;
	
	/**
	 * This method is used to update the EnumEntity
	 * 
	 * @param EnumEntity
	 * @return EnumEntity
	 */
	public EnumEntity updateEnum(EnumEntity enumEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the EnumEntity
	 * 
	 * @param EnumEntity
	 * @return 
	 */
	public void deleteEnum(EnumEntity enumEntity) throws BusinessException;
	
	/**
	 * This method is used to get the EnumEntity
	 * 
	 * @param String
	 * @return EnumEntity
	 */
	public EnumEntity getByMessagekey(String messageKey) throws BusinessException;
	
}
