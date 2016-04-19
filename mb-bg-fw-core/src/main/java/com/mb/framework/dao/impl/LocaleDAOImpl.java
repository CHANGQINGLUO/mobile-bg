/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @since 2014-12-17T18:10:48
 * @author SPA
 *
 */
package com.mb.framework.dao.impl;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.LocaleDAO;
import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("localeDAO")
public class LocaleDAOImpl extends AbstractDAO<LocaleEntity> implements LocaleDAO {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * This method is constructor which sets LocaleEntity class
	 * 
	 * @param
	 * @return
	 */
	public LocaleDAOImpl() {
		super();
		this.setEntityClass(LocaleEntity.class);
	}

	/**
	 * This method is used for finding key data entity by id
	 * @param id
	 * @return
	 */
	public LocaleEntity findLocaleById(String id){
		logger.debug("find localeDAO by Id.");
		return findById(id);
	}

	/**
	 * This method is used to insert the LocaleEntity.
	 * 
	 * @param LocaleEntity
	 * @return
	 * @throws SQLException
	 */
	public void addLocale(LocaleEntity localeEntity) {
		logger.debug("add LocaleEntity.");
		save(localeEntity);
	}

	/**
	 * This method is used to update the LocaleEntity.
	 * 
	 * @param LocaleEntity
	 * @return LocaleEntity
	 */
	public LocaleEntity updateLocale(LocaleEntity localeEntity) {
		logger.debug("update LocaleEntity.");
		return update(localeEntity);
	}

	/**
	 * This method is used to delete the LocaleEntity.
	 * 
	 * @param LocaleEntity
	 * @return
	 */
	public void deleteLocale(LocaleEntity localeEntity) {
		logger.debug("delete LocaleEntity.");
		delete(localeEntity);
	}
	
	/**
	 * 
	 * This method is used for find LocaleEntity by name
	 * @param name
	 * @return LocaleEntity
	 */
	@Override
	public LocaleEntity findByName(String name) {
		LocaleEntity entity = null;
		try
		{
			entity = em.createQuery("select u from LocaleEntity u where lower(u.name) = lower(:name) and u.isDeleted=:isDeleted", 
					LocaleEntity.class).setParameter("name", name).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		}
		catch (NoResultException e)
		{
			logger.info("No record found for LocaleEntity with name = " + name);
		}
		return entity;
	}

}
