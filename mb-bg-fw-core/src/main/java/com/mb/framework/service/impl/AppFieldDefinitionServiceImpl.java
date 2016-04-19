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
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.AppFieldDefinitionDAO;
import com.mb.framework.entity.AppFieldDefinitionEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.AppFieldDefinitionService;
import com.mb.framework.util.AppFieldDefinitionMapperUtil;
import com.mb.framework.util.log.LogHelper;

@Service("appFieldDefinitionService")
public class AppFieldDefinitionServiceImpl implements AppFieldDefinitionService
{

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private AppFieldDefinitionDAO appFieldDefinitionDAO;

	@Autowired
	private AppFieldDefinitionMapperUtil appFieldDefinitionMapper;

	/**
	 * 
	 * This method is used for add AppFieldDefinitionEntity
	 * 
	 * @param appFieldDefinitionEntity
	 * @throws BusinessException
	 */
	@Override
	public AppFieldDefinitionEntity addAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException
	{

		try
		{
			appFieldDefinitionDAO.addAppFieldDefinition(appFieldDefinitionEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to add AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}
		
		return appFieldDefinitionEntity;
	}

	/**
	 * 
	 * This method is used for update AppFieldDefinitionEntity
	 * 
	 * @param appFieldDefinitionEntity
	 * @return AppFieldDefinitionEntity
	 * @throws BusinessException
	 */
	@Override
	public AppFieldDefinitionEntity updateAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException
	{

		AppFieldDefinitionEntity returnAppFieldDefinitionEntity = null;
		try
		{
			returnAppFieldDefinitionEntity = appFieldDefinitionDAO.updateAppFieldDefinition(appFieldDefinitionEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to update AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnAppFieldDefinitionEntity;
	}

	/**
	 * 
	 * This method is used for delete AppFieldDefinitionEntity
	 * 
	 * @param appFieldDefinitionEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity) throws BusinessException
	{

		try
		{
			appFieldDefinitionDAO.deleteAppFieldDefinition(appFieldDefinitionEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to  delete AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}

	/**
	 * This method is used for getting AppFieldDefinition by name and type, if
	 * it doesn't have it , then create a new one.
	 * 
	 * @param filedType
	 * @param fieldName
	 * @return
	 * @throws BusinessException
	 */
	public AppFieldDefinitionEntity getAppFieldDefinitionByName(String fieldType, String fieldName) throws BusinessException
	{
		AppFieldDefinitionEntity entity = null;

		try
		{
			entity = appFieldDefinitionDAO.getAppFieldDefinitionByName(fieldType, fieldName);
			if (entity == null)
			{
				entity = appFieldDefinitionMapper.createAppFieldDefinition(fieldType, fieldName);
				entity = addAppFieldDefinition(entity);
			}
		}
		catch (Exception ex)
		{
			logger.error("Failed to  fetch AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.APP_FIELD_DEFINATION_NOT_FOUND);
		}
		return entity;
	}

	public AppFieldDefinitionEntity getAppFieldDefinitionByTypeName(String fieldType, String fieldName) throws BusinessException
	{
		AppFieldDefinitionEntity entity = null;
		try
		{
			entity = appFieldDefinitionDAO.getAppFieldDefinitionByName(fieldType, fieldName);
		}
		catch (Exception ex)
		{
			logger.error("Failed to  fetch AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.APP_FIELD_DEFINATION_NOT_FOUND);
		}
		return entity;
	}

	/**
	 * This method is used for 
	 * @param fieldType
	 * @param uuid
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public AppFieldDefinitionEntity getAppFieldDefinitionByUUIDType(String fieldType, String uuid) throws BusinessException {
		AppFieldDefinitionEntity entity = null;
		try
		{
			entity = appFieldDefinitionDAO.getAppFieldDefinitionByUUIDType(fieldType, uuid);
		}
		catch (Exception ex)
		{
			logger.error("Failed to  fetch AppFieldDefinitionEntity", ex);
			throw new BusinessException(ErrorCodes.APP_FIELD_DEFINATION_NOT_FOUND);
		}
		return entity;
	}
}
