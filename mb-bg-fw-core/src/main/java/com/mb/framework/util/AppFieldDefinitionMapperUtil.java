/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 17 Nov, 2014 6:42:35 pm
 * @author SPA
 * @my-workbench-core-sg
 * AppFieldDefinitionMapperUtil.java
 *
 */
package com.mb.framework.util;

import org.springframework.stereotype.Component;

import com.mb.framework.entity.AppFieldDefinitionEntity;

/**
 * @author SPA
 * 
 */
@Component
public class AppFieldDefinitionMapperUtil
{

	/**
	 * This method is used for creating AppFieldDefinition entity
	 * 
	 * @param fieldType
	 * @param fieldName
	 * @return
	 */
	public AppFieldDefinitionEntity createAppFieldDefinition(String fieldType, String fieldName)
	{
		AppFieldDefinitionEntity entity = new AppFieldDefinitionEntity();
		entity.setFieldType(fieldType);
		entity.setFieldName(fieldName);
		entity.setDescription(fieldName);
		return entity;
	}
}
