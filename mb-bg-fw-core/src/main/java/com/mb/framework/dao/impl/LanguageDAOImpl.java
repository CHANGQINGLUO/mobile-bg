/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @since 2014-12-17T18:10:22
 * @author SPA
 *
 */
package com.mb.framework.dao.impl;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.LanguageDAO;
import com.mb.framework.entity.LanguageEntity;
import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("languageDAO")
public class LanguageDAOImpl extends AbstractDAO<LanguageEntity> implements LanguageDAO {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * This method is constructor which sets LanguageEntity class
	 * 
	 * @param
	 * @return
	 */
	public LanguageDAOImpl() {
		super();
		this.setEntityClass(LanguageEntity.class);
	}

	/**
	 * This method is used for finding key data entity by id
	 * @param id
	 * @return
	 */
	public LanguageEntity findLanguageById(String id){
		logger.debug("find languageDAO by Id.");
		return findById(id);
	}

	/**
	 * This method is used to insert the LanguageEntity.
	 * 
	 * @param LanguageEntity
	 * @return
	 * @throws SQLException
	 */
	public void addLanguage(LanguageEntity languageEntity) {
		logger.debug("add LanguageEntity.");
		save(languageEntity);
	}

	/**
	 * This method is used to update the LanguageEntity.
	 * 
	 * @param LanguageEntity
	 * @return LanguageEntity
	 */
	public LanguageEntity updateLanguage(LanguageEntity languageEntity) {
		logger.debug("update LanguageEntity.");
		return update(languageEntity);
	}

	/**
	 * This method is used to delete the LanguageEntity.
	 * 
	 * @param LanguageEntity
	 * @return
	 */
	public void deleteLanguage(LanguageEntity languageEntity) {
		logger.debug("delete LanguageEntity.");
		delete(languageEntity);
	}

	@Override
	public LanguageEntity findLanguageByName(String name) {
		LanguageEntity entity = null;
		try
		{
			entity = em.createQuery("select u from LanguageEntity u where lower(u.isoAlpha2cd) = lower(:name) and u.isDeleted=:isDeleted", 
					LanguageEntity.class).setParameter("name", name).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		}
		catch (NoResultException e)
		{
			logger.info("No record found for LanguageEntity with name = " + name);
		}
		return entity;
	}

}
