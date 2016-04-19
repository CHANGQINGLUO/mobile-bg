/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @since 2014-12-17T17:36:32
 * @author SPA
 *
 */
package com.mb.framework.dao.impl;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.CurrencyDAO;
import com.mb.framework.entity.CurrencyEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("currencyDAO")
public class CurrencyDAOImpl extends AbstractDAO<CurrencyEntity> implements CurrencyDAO {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * This method is constructor which sets CurrencyEntity class
	 * 
	 * @param
	 * @return
	 */
	public CurrencyDAOImpl() {
		super();
		this.setEntityClass(CurrencyEntity.class);
	}

	/**
	 * This method is used for finding key data entity by id
	 * @param id
	 * @return
	 */
	public CurrencyEntity findCurrencyById(String id){
		logger.debug("find currencyDAO by Id.");
		return findById(id);
	}

	/**
	 * This method is used to insert the CurrencyEntity.
	 * 
	 * @param CurrencyEntity
	 * @return
	 * @throws SQLException
	 */
	public void addCurrency(CurrencyEntity currencyEntity) {
		logger.debug("add CurrencyEntity.");
		save(currencyEntity);
	}

	/**
	 * This method is used to update the CurrencyEntity.
	 * 
	 * @param CurrencyEntity
	 * @return CurrencyEntity
	 */
	public CurrencyEntity updateCurrency(CurrencyEntity currencyEntity) {
		logger.debug("update CurrencyEntity.");
		return update(currencyEntity);
	}

	/**
	 * This method is used to delete the CurrencyEntity.
	 * 
	 * @param CurrencyEntity
	 * @return
	 */
	public void deleteCurrency(CurrencyEntity currencyEntity) {
		logger.debug("delete CurrencyEntity.");
		delete(currencyEntity);
	}
	
	
	/**
	 * 
	 * This method is used for 
	 * @param numberCurrencyCode findByNumCurrencyCode
	 * @return
	 */
	@Override
	public CurrencyEntity findByNumbericCurCode(String numbericCurCode) {
		
		CurrencyEntity entity = null;
		logger.debug(this.getClass().getName() + "findByNumbericCurCode(" + numbericCurCode + ")");
		try
		{
			entity = em.createQuery("select c from CurrencyEntity c where c.numbericCurCode = :numbericCurCode and c.isDeleted=:isDeleted", CurrencyEntity.class).setParameter("numbericCurCode", numbericCurCode).setParameter("isDeleted", Boolean.FALSE).getSingleResult();

		}
		catch (NoResultException e)
		{
			logger.info("No record found for numbericCurCode  = " + numbericCurCode);
		}
		return entity;
	}

	/**
	 * This method is used for findByTextCurCode
	 * @param textCurCode
	 * @return
	 */
	@Override
	public CurrencyEntity findByTextCurCode(String textCurCode) {
		
		CurrencyEntity entity = null;
		logger.debug(this.getClass().getName() + "findByTextCurCode(" + textCurCode + ")");
		try
		{
			entity = em.createQuery("select c from CurrencyEntity c where c.textCurCode = :textCurCode and c.isDeleted=:isDeleted", CurrencyEntity.class).setParameter("textCurCode", textCurCode).setParameter("isDeleted", Boolean.FALSE).getSingleResult();

		}
		catch (NoResultException e)
		{
			logger.info("No record found for textCurCode  = " + textCurCode);
		}
		return entity;		
	}

}
