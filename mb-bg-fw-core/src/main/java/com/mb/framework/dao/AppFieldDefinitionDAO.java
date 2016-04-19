/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @since 2014-11-07T16:17:24
 * @author SPA
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.AppFieldDefinitionEntity;

public interface AppFieldDefinitionDAO
{

	/**
	 * This method is used for AppFieldDefinition data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public AppFieldDefinitionEntity findAppFieldDefinitionById(String id);

	/**
	 * This method is used to insert the AppFieldDefinitionEntity .
	 * 
	 * @param appFieldDefinitionEntity
	 * @return
	 */
	public void addAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity);

	/**
	 * This method is used to update the AppFieldDefinitionEntity.
	 * 
	 * @param appFieldDefinitionEntity
	 * @return AppFieldDefinitionEntity
	 */
	public AppFieldDefinitionEntity updateAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity);

	/**
	 * This method is used to delete the AppFieldDefinitionEntity .
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return
	 */
	public void deleteAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity);

	/**
	 * This method is used for fetch AppFieldDefinition by name and type
	 * 
	 * @param fieldType
	 * @param fieldName
	 * @return
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByName(String fieldType, String fieldName);

	/**
	 * This method is used for 
	 * @param fieldType
	 * @param uuid
	 * @return 
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByUUIDType(String fieldType, String uuid);
}
