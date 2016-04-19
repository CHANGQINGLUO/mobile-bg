/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 * UserDAOImpl.java
 *
 */
package com.mb.ext.core.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.IncomeDAO;
import com.mb.ext.core.entity.IncomeEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("incomeDAO")
@Qualifier("incomeDAO")
public class IncomeDAOImpl extends AbstractDAO<IncomeEntity> implements IncomeDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public IncomeDAOImpl()
	{
		super();
		this.setEntityClass(IncomeEntity.class);
	}

	/**
	 * This method is used for inserting income information.
	 * 
	 * @param user
	 */
	@Override
	public void addIncome(IncomeEntity income)
	{
		save(income);
		logger.debug("The income added is " + income.getIncomeUuid());
	}
	
	/**
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	@Override
	public IncomeEntity getIncome(String uuid) throws DAOException {
		logger.debug("IncomeDAOImpl - retrieve income by  id.");
		IncomeEntity entity = null;
		try {
			entity = (IncomeEntity)em.createQuery("select b from IncomeEntity b where b.incomeUuid = :UUID and b.isDeleted=:isDeleted order by b.createDate desc",IncomeEntity.class).setParameter("UUID", uuid).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

}
