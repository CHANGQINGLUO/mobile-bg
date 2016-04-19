/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.EnumDAO;
import com.mb.framework.entity.EnumEntity;

@Repository("enumDAO")
public class EnumDAOImpl extends AbstractDAO<EnumEntity> implements EnumDAO
{

	/**
	 * constructor
	 */
	public EnumDAOImpl()
	{
		super();
		this.setEntityClass(EnumEntity.class);
	}

	/**
	 * This method is used to insert the EnumEntity in SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 */
	public void addEnum(EnumEntity enumEntity)
	{
		save(enumEntity);
	}

	/**
	 * This method is used to update the EnumEntity in SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 * @return EnumEntity
	 */
	public EnumEntity updateEnum(EnumEntity enumEntity)
	{
		return update(enumEntity);
	}

	/**
	 * This method is used to delete the EnumEntity from SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 */
	public void deleteEnum(EnumEntity enumEntity)
	{
		delete(enumEntity);
	}

	/**
	 * This method is used to get EnumEntity by messageKey from SYS_ENUM table.
	 * 
	 * @param messageKey
	 * @return EnumEntity
	 */
	public EnumEntity getByMessagekey(String messageKey)
	{
		return em.createQuery("select ee from EnumEntity ee where ee.messageKey = :messageKey and ee.isDeleted=:isDeleted", EnumEntity.class).setParameter("messageKey", messageKey).setParameter("isDeleted", false).getSingleResult();
	}

	/**
	 * 
	 * This method is used for get enum entity list by category
	 * 
	 * @param category
	 * @return
	 */
	public List<EnumEntity> getByCategory(String category)
	{
		return em.createQuery("select ee from EnumEntity ee where ee.category = :category and ee.isDeleted=:isDeleted", EnumEntity.class).setParameter("category", category).setParameter("isDeleted", false).getResultList();

	}

}
