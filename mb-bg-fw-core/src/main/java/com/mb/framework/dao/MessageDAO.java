/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao;

import java.util.List;

import com.mb.framework.entity.MessageEntity;

public interface MessageDAO {
	
	/**
	 * This method is used to insert the MessageEntity in SYS_MESSAGE table.
	 * @param MessageEntity
	 */
	public void addMessage(MessageEntity messageEntity);

	/**
	 * This method is used to update the MessageEntity in SYS_MESSAGE table.
	 * @param MessageEntity
	 * @return MessageEntity
	 */
	public MessageEntity updateMessage(MessageEntity messageEntity);

	/**
	 * This method is used to delete the MessageEntity from SYS_MESSAGE table.
	 * @param MessageEntity
	 * @return
	 */
	public void deleteMessage(MessageEntity messageEntity);

	/**
	 * This method is used to get MessageEntity by messageKey from SYS_MESSAGE table.
	 * @param messageKey
	 * @return MessageEntity list
	 */
	public List<MessageEntity> getByMessagekey(String messageKey);

	/**
	 * This method is used to retrieve the MessageEntity by messageKey,language from SYS_MESSAGE table.
	 * @param messagekey
	 * @param language
	 * @return MessageEntity
	 */
	public MessageEntity getByMessagekey(String messageKey, String language);

	/**
	 * retrieve all active messages
	 * @return MessageEntity list
	 */
	public List<MessageEntity> getAllMessages();

	/**
	 * This method is used for retrieve the message by language from SYS_MESSAGE table.
	 * @param language
	 * @return 
	 */
	public List<MessageEntity> getAllMessagesByLanguage(String language);

}
