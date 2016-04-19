/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.MessageDAO;
import com.mb.framework.entity.MessageEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.MessageService;
import com.mb.framework.util.log.LogHelper;

@Service("messageService")
public class MessageServiceImpl implements MessageService
{

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public MessageDAO messageDAO;

	/**
	 * 
	 * This method is used for insert MessageEntity
	 * 
	 * @param messageEntity
	 * @throws BusinessException
	 */
	@Override
	public void addMessage(MessageEntity messageEntity) throws BusinessException
	{

		logger.debug("MessageServiceImpl add for the message key is " + messageEntity.getMessageKey());
		try
		{
			messageDAO.addMessage(messageEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to add Message", ex);
			throw new BusinessException(ErrorCodes.FM00013);
		}
	}

	/**
	 * 
	 * This method is used for update MessageEntity
	 * 
	 * @param messageEntity
	 * @return MessageEntity
	 * @throws BusinessException
	 */
	@Override
	public MessageEntity updateMessage(MessageEntity messageEntity) throws BusinessException
	{

		logger.debug("MessageServiceImpl update for the message key is " + messageEntity.getMessageKey());
		MessageEntity returnMessageEntity = null;
		try
		{
			returnMessageEntity = messageDAO.updateMessage(messageEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to update Message", ex);
			throw new BusinessException(ErrorCodes.FM00014);
		}
		return returnMessageEntity;
	}

	/**
	 * 
	 * This method is used for delete MessageEntity
	 * 
	 * @param messageEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteMessage(MessageEntity messageEntity) throws BusinessException
	{

		logger.debug("MessageServiceImpl delete for the message key is " + messageEntity.getMessageKey());
		try
		{
			messageDAO.deleteMessage(messageEntity);
		}
		catch (Exception ex)
		{
			logger.error("Failed to delete Message", ex);
			throw new BusinessException(ErrorCodes.FM00015);
		}
	}

	/**
	 * This method is used to get messageEntity from SYS_MESSAGE table.
	 * 
	 * @param String
	 * @return MessageEntity
	 */
	@Override
	public List<MessageEntity> getByMessagekey(String messageKey) throws BusinessException
	{
		logger.debug("MessageServiceImpl get for the message key is " + messageKey);
		try
		{
			return messageDAO.getByMessagekey(messageKey);
		}
		catch (Exception ex)
		{
			logger.error("Failed to get Message entity", ex);
			throw new BusinessException(ErrorCodes.FM00020);
		}
	}

	/**
	 * This method is used to retrieve the message by message key and language
	 * 
	 * @param messagekey
	 * @return MessageEntity
	 */
	public MessageEntity getByMessagekey(String messageKey, String language) throws BusinessException
	{
		try
		{
			return messageDAO.getByMessagekey(messageKey, language);
		}
		catch (Exception ex)
		{
			logger.error("Failed to get Message entity", ex);
			throw new BusinessException(ErrorCodes.FM00020);
		}
	}

	/**
	 * retrieve all active messages
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<MessageEntity> getAllMessages() throws BusinessException
	{
		try
		{
			return messageDAO.getAllMessages();
		}
		catch (Exception ex)
		{
			logger.error("Failed to get Message entity", ex);
			throw new BusinessException(ErrorCodes.FM00020);
		}
	}

	/**
	 * This method is used to retrieve the message by language from SYS_MESSAGE
	 * table.
	 * 
	 * @param language
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<MessageEntity> getAllMessageByLanguage(String language) throws BusinessException
	{
		try
		{
			return messageDAO.getAllMessagesByLanguage(language);
		}
		catch (Exception ex)
		{
			logger.error("Failed to get Message entity by language: " + language, ex);
			throw new BusinessException(ErrorCodes.FM00020);
		}
	}

}
