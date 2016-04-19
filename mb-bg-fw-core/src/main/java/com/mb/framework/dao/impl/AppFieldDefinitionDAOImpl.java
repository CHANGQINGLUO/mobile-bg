/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @since 2014-11-07T16:17:23
 * @author SPA
 *
 */
package com.mb.framework.dao.impl;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.AppFieldDefinitionDAO;
import com.mb.framework.entity.AppFieldDefinitionEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("appFieldDefinitionDAO")
public class AppFieldDefinitionDAOImpl extends AbstractDAO<AppFieldDefinitionEntity> implements AppFieldDefinitionDAO
{

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * This method is constructor which sets AppFieldDefinitionEntity class
	 * 
	 * @param
	 * @return
	 */
	public AppFieldDefinitionDAOImpl()
	{
		super();
		this.setEntityClass(AppFieldDefinitionEntity.class);
	}

	/**
	 * This method is used for finding key data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public AppFieldDefinitionEntity findAppFieldDefinitionById(String id)
	{
		logger.debug("find appFieldDefinitionDAO by Id.");
		return findById(id);
	}

	/**
	 * This method is used to insert the AppFieldDefinitionEntity.
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return
	 * @throws SQLException
	 */
	public void addAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity)
	{
		logger.debug("add AppFieldDefinitionEntity.");
		save(appFieldDefinitionEntity);
	}

	/**
	 * This method is used to update the AppFieldDefinitionEntity.
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return AppFieldDefinitionEntity
	 */
	public AppFieldDefinitionEntity updateAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity)
	{
		logger.debug("update AppFieldDefinitionEntity.");
		return update(appFieldDefinitionEntity);
	}

	/**
	 * This method is used to delete the AppFieldDefinitionEntity.
	 * 
	 * @param AppFieldDefinitionEntity
	 * @return
	 */
	public void deleteAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinitionEntity)
	{
		logger.debug("delete AppFieldDefinitionEntity.");
		delete(appFieldDefinitionEntity);
	}

	/**
	 * This method is used for
	 * 
	 * @param filedType
	 * @param name
	 * @return
	 */
	@Override
	public AppFieldDefinitionEntity getAppFieldDefinitionByName(String fieldType, String fieldName)
	{
		AppFieldDefinitionEntity entity = null;
		try
		{
			entity = em.createQuery("select u from AppFieldDefinitionEntity u where u.fieldType = :fieldType and u.fieldName = :fieldName and u.isDeleted=:isDeleted", AppFieldDefinitionEntity.class).setParameter("fieldType", fieldType).setParameter("fieldName", fieldName).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		}
		catch (NoResultException e)
		{
			logger.info("No record found for AppFieldDefinitionEntity with fieldType = " + fieldType + " and fieldName = " + fieldName);
		}
		return entity;
	}

	/**
	 * This method is used for 
	 * @param fieldType
	 * @param uuid
	 * @return
	 */
	@Override
	public AppFieldDefinitionEntity getAppFieldDefinitionByUUIDType(String fieldType, String uuid) {
		AppFieldDefinitionEntity entity = null;
		try
		{
			entity = em.createQuery("select u from AppFieldDefinitionEntity u where u.fieldType = :fieldType and u.fieldDefUuid = :fieldDefUuid and u.isDeleted=:isDeleted", AppFieldDefinitionEntity.class).setParameter("fieldType", fieldType).setParameter("fieldDefUuid", uuid).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		}
		catch (NoResultException e)
		{
			logger.info("No record found for AppFieldDefinitionEntity with fieldType = " + fieldType + " and uuid = " + uuid);
		}
		return entity;
	}

}
