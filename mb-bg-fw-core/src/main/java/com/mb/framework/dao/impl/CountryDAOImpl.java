/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @since 2014-12-17T18:09:10
 * @author SPA
 *
 */
package com.mb.framework.dao.impl;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.CountryDAO;
import com.mb.framework.entity.CountryEntity;
import com.mb.framework.entity.CountryEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("countryDAO")
public class CountryDAOImpl extends AbstractDAO<CountryEntity> implements CountryDAO {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * This method is constructor which sets CountryEntity class
	 * 
	 * @param
	 * @return
	 */
	public CountryDAOImpl() {
		super();
		this.setEntityClass(CountryEntity.class);
	}

	/**
	 * This method is used for finding key data entity by id
	 * @param id
	 * @return
	 */
	public CountryEntity findCountryById(String id){
		logger.debug("find countryDAO by Id.");
		return findById(id);
	}

	/**
	 * This method is used to insert the CountryEntity.
	 * 
	 * @param CountryEntity
	 * @return
	 * @throws SQLException
	 */
	public void addCountry(CountryEntity countryEntity) {
		logger.debug("add CountryEntity.");
		save(countryEntity);
	}

	/**
	 * This method is used to update the CountryEntity.
	 * 
	 * @param CountryEntity
	 * @return CountryEntity
	 */
	public CountryEntity updateCountry(CountryEntity countryEntity) {
		logger.debug("update CountryEntity.");
		return update(countryEntity);
	}

	/**
	 * This method is used to delete the CountryEntity.
	 * 
	 * @param CountryEntity
	 * @return
	 */
	public void deleteCountry(CountryEntity countryEntity) {
		logger.debug("delete CountryEntity.");
		delete(countryEntity);
	}

	@Override
	public CountryEntity findByAlpha2Cd(String alpha2Cd) {
		CountryEntity entity = null;
		logger.debug(this.getClass().getName() + "findByAlpha2Cd(" + alpha2Cd + ")");
		try
		{
			entity = em.createQuery("select c from CountryEntity c where c.isoAlpha2cd = :alpha2Cd and c.isDeleted=:isDeleted", CountryEntity.class).setParameter("alpha2Cd", alpha2Cd).setParameter("isDeleted", Boolean.FALSE).getSingleResult();

		}
		catch (NoResultException e)
		{
			logger.info("No record found for findByAlpha2Cd  = " + alpha2Cd);
		}
		return entity;
	}

}
