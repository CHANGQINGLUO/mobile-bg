/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 1:25:57 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.MessageEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface MessageService
{

	/**
	 * This method is used to insert the MessageEntity
	 * 
	 * @param MessageEntity
	 * @return
	 */
	public void addMessage(MessageEntity messageEntity) throws BusinessException;

	/**
	 * This method is used to update the MessageEntity
	 * 
	 * @param MessageEntity
	 * @return MessageEntity
	 */
	public MessageEntity updateMessage(MessageEntity messageEntity) throws BusinessException;

	/**
	 * This method is used to delete the MessageEntity
	 * 
	 * @param MessageEntity
	 * @return
	 */
	public void deleteMessage(MessageEntity messageEntity) throws BusinessException;

	/**
	 * This method is used to get list of messageEntity from SYS_MESSAGE table.
	 * 
	 * @param String
	 * @return List<MessageEntity>
	 */
	public List<MessageEntity> getByMessagekey(String messageKey) throws BusinessException;

	/**
	 * This method is used to retrieve the message by language from SYS_MESSAGE
	 * table.
	 * 
	 * @param messagekey
	 * @return MessageEntity
	 */
	public MessageEntity getByMessagekey(String messageKey, String language) throws BusinessException;

	/**
	 * This method is used to retrieve the message by language from SYS_MESSAGE
	 * table.
	 * 
	 * @param language
	 * @return List<MessageEntity>
	 */
	public List<MessageEntity> getAllMessageByLanguage(String language) throws BusinessException;

	/**
	 * retrieve all active messages
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<MessageEntity> getAllMessages() throws BusinessException;

}
