/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jun, 2014 3:04:19 pm
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mb.framework.entity.MessageEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.service.MessageService;
import com.mb.framework.service.spec.MessageDTO;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;

@Component
public class TranslationManager
{

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private MessageService messageService;

	@Autowired
	private PropertyRepository propertyRepository;

	private static Map<String, Map<String, MessageEntity>> cache = new HashMap<String, Map<String, MessageEntity>>();

	/**
	 * This method is used for getting translation
	 * 
	 * @param name
	 * @return
	 */
	public String getMessageKey(final String name)
	{
		return null;
	}

	/**
	 * This method is used for getting translation by message key
	 * 
	 * @param messageKey
	 * @return
	 */
	public MessageDTO getMessageByDefaultLanguage(final String messageKey)
	{
		String language = propertyRepository.getProperty(ConfigConstants.DEFAULT_LANGUAGE);
		language = language == null ? "en" : language;
		return getMessage(messageKey, language);
	}

	/**
	 * retrieve message from cache by message key and language
	 * 
	 * @param messageKey
	 * @param language
	 * @return
	 */
	public MessageDTO getMessage(final String messageKey, final String language)
	{
		MessageEntity message = getMessageByLanguage(messageKey, language);
		MessageDTO dto = null;
		if (message != null)
		{
			dto = new MessageDTO();
			dto.setLanguage(message.getLanguage());
			dto.setMessageKey(message.getMessageKey());
			dto.setMessageValue(message.getMessageValue());
		}
		return dto;
	}

	/**
	 * This method is used for getting message from cache
	 * 
	 * @param messageKey
	 * @return
	 */
	private MessageEntity getMessageByLanguage(String messsageKey, String language)
	{
		Map<String, MessageEntity> messages = new HashMap<String, MessageEntity>();
		if (cache != null && !cache.isEmpty())
		{
			messages = cache.get(language);
		}

		if (messages == null || messages.size() < 1)
		{
			loadMessages(language);

			// reload from cache
			messages = cache.get(language);
		}

		MessageEntity entity = null;
		if (messages != null && messages.size() > 0)
		{
			entity = messages.get(messsageKey);
		}

		return entity;
	}

	/**
	 * This method is used for loading message from database and save into cache
	 * 
	 * @param messageKey
	 */
	private void loadMessages(String language)
	{
		try
		{
			List<MessageEntity> messages = messageService.getAllMessageByLanguage(language);
			if (!messages.isEmpty())
			{
				Map<String, MessageEntity> messageMap = new HashMap<String, MessageEntity>();
				for (MessageEntity message : messages)
				{
					messageMap.put(message.getMessageKey(), message);
				}
				cache.put(language, messageMap);
			}
		}
		catch (BusinessException e)
		{
			logger.error("Failed to retrieve message for language = " + language, e);
		}
	}
}
