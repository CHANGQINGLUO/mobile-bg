/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2014-11-07T16:17:24
 * @author SPA
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.AppFieldDefinitionEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface AppFieldDefinitionService{

	/**
	 * This method is used to insert the AppFieldDefinitionEntity
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return 
	 */
	public AppFieldDefinitionEntity addAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException;
	
	/**
	 * This method is used to update the AppFieldDefinitionEntity
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return AppFieldDefinitionEntity
	 */
	public AppFieldDefinitionEntity updateAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException;
	
	/**
	 * This method is used for getting AppFieldDefinition by name and type, if
	 * it doesn't have it , then create a new one.
	 * 
	 * @param filedType
	 * @param fieldName
	 * @return
	 * @throws BusinessException
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByName(String fieldType, String fieldName) throws BusinessException;
	
	/**
	 * @param fieldType
	 * @param fieldName
	 * @return
	 * @throws BusinessException
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByTypeName(String fieldType, String fieldName) throws BusinessException;
	
	/**
	 * This method is used for 
	 * @param fieldType
	 * @param uuid
	 * @return
	 * @throws BusinessException 
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByUUIDType(String fieldType, String uuid) throws BusinessException;
}
