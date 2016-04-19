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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.IMessageDAO;
import com.mb.ext.core.entity.IMessageEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("iMessageDAO")
@Qualifier("iMessageDAO")
public class MessageDAOImpl extends AbstractDAO<IMessageEntity> implements IMessageDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public MessageDAOImpl()
	{
		super();
		this.setEntityClass(IMessageEntity.class);
	}

	/**
	 * This method is used for inserting news information.
	 * 
	 * @param message
	 */
	@Override
	public void addMessage(IMessageEntity message)
	{
		save(message);
		logger.debug("The news added is " + message.getMessageUuid());
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public List<IMessageEntity> getMessages() throws DAOException {
		logger.debug("MessageDAOImpl - retrieve message.");
		List<IMessageEntity> entityList = new ArrayList<IMessageEntity>();
		try {
			entityList = em.createQuery("select b from IMessageEntity b where b.isDeleted=:isDeleted and b.status=:status",IMessageEntity.class).setParameter("isDeleted", Boolean.FALSE).setParameter("status", "P").getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for news.");
		}
		return entityList;
	}
	


}
