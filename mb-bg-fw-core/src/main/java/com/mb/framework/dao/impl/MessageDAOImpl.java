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

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.MessageDAO;
import com.mb.framework.entity.MessageEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("messageDAO")
public class MessageDAOImpl extends AbstractDAO<MessageEntity> implements
		MessageDAO {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * constructor
	 */
	public MessageDAOImpl() {
		super();
		this.setEntityClass(MessageEntity.class);
	}

	/**
	 * This method is used to insert the MessageEntity in SYS_MESSAGE table.
	 * @param MessageEntity
	 */
	public void addMessage(MessageEntity messageEntity) {
		save(messageEntity);
	}

	/**
	 * This method is used to update the MessageEntity in SYS_MESSAGE table.
	 * @param MessageEntity
	 * @return MessageEntity
	 */
	public MessageEntity updateMessage(MessageEntity messageEntity) {
		return update(messageEntity);
	}

	/**
	 * This method is used to delete the MessageEntity from SYS_MESSAGE table.
	 * @param MessageEntity
	 */
	public void deleteMessage(MessageEntity messageEntity) {
		delete(messageEntity);
	}

	/**
	 * This method is used to delete the MessageEntity from SYS_MESSAGE table.
	 * @param messagekey
	 * @return MessageEntity list
	 */
	public List<MessageEntity> getByMessagekey(String messageKey) {
		List<MessageEntity> entity = null;
		try
		{
			entity = em.createQuery("select me from MessageEntity me where me.messageKey = :messageKey and me.isDeleted=:isDeleted",MessageEntity.class)
					.setParameter("messageKey", messageKey)
					.setParameter("isDeleted", false).getResultList();
		}catch (NoResultException e)
		{
			logger.info("No record found for getAllMessages");
		}
		return entity;
	}

	/**
	 * This method is used to retrieve the MessageEntity by messageKey,language from SYS_MESSAGE table.
	 * @param messagekey
	 * @param language
	 * @return MessageEntity
	 */
	public MessageEntity getByMessagekey(String messageKey, String language) {
		MessageEntity entity = null;
		try
		{
			entity = em.createQuery("select me from MessageEntity me where me.messageKey = :messageKey and me.language = :language and me.isDeleted=:isDeleted",MessageEntity.class)
					.setParameter("messageKey", messageKey)
					.setParameter("language", language)
					.setParameter("isDeleted", false).getSingleResult();
		}catch (NoResultException e)
		{
			logger.info("No record found for getAllMessages");
		}
		return entity;
	}

	/**
	 * retrieve all active messages
O	 */
	public List<MessageEntity> getAllMessages() {
		
		List<MessageEntity> entity = null;
		try
		{
			entity = em.createQuery("select me from MessageEntity me where me.isDeleted=:isDeleted",MessageEntity.class).setParameter("isDeleted", false).getResultList();
			
		}catch (NoResultException e)
		{
			logger.info("No record found for getAllMessages");
		}
		return entity;
	}

	/**
	 * This method is used for retrieve the message by language from SYS_MESSAGE table.
	 * @param language
	 * @return
	 */
	@Override
	public List<MessageEntity> getAllMessagesByLanguage(String language) {
		
		List<MessageEntity> entity = null;
		try
		{
			entity = em.createQuery("select me from MessageEntity me where me.language=:language and me.isDeleted=:isDeleted", MessageEntity.class).setParameter("language", language).setParameter("isDeleted", false).getResultList();
			
		}catch (NoResultException e)
		{
			logger.info("No record found for getAllMessagesByLanguage  language = " + language);
		}
		return entity;
	}
}
