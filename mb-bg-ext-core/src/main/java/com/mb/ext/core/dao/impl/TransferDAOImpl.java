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

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.TransferDAO;
import com.mb.ext.core.entity.TransferEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("transferDAO")
@Qualifier("transferDAO")
public class TransferDAOImpl extends AbstractDAO<TransferEntity> implements TransferDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public TransferDAOImpl()
	{
		super();
		this.setEntityClass(TransferEntity.class);
	}

	/**
	 * This method is used for inserting transfer information.
	 * 
	 * @param user
	 */
	@Override
	public void addTransfer(TransferEntity transfer)
	{
		save(transfer);
		logger.debug("The transfer added is " + transfer.getTransferUuid());
	}
	
	/**
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	@Override
	public TransferEntity getTransfer(String uuid) throws DAOException {
		logger.debug("TransferDAOImpl - retrieve transfer by  id.");
		TransferEntity entity = null;
		try {
			entity = (TransferEntity)em.createQuery("select b from TransferEntity b where b.transferUuid = :UUID and b.isDeleted=:isDeleted order by b.createDate desc",TransferEntity.class).setParameter("UUID", uuid).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

	@Override
	public List<TransferEntity> getTransfers() throws DAOException {
		logger.debug("TransferDAOImpl - retrieve transfers.");
		List<TransferEntity> entityList = null;
		try {
			entityList = em.createQuery("select b from TransferEntity b where b.isDeleted=:isDeleted order by b.createDate desc",TransferEntity.class).setParameter("isDeleted", Boolean.FALSE).getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entityList;
	}

}
