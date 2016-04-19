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

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.ChannelEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface ChannelService{

	/**
	 * This method is used to insert the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void addChannel(ChannelEntity channelEntity) throws BusinessException;
	
	/**
	 * This method is used to update the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return ChannelEntity
	 */
	public ChannelEntity updateChannel(ChannelEntity channelEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteChannel(ChannelEntity channelEntity) throws BusinessException;
	
	/**
	 * This method is used to get the ChannelEntity
	 * 
	 * @param int
	 * @return ChannelEntity
	 */
	public ChannelEntity getByChannelId(int channelId) throws BusinessException;
	
	/**
	 * This method is used to get ChannelEntity by message key
	 * table.
	 * 
	 * @param messageCode
	 * @return
	 * @throws BusinessException 
	 */
	public ChannelEntity getByMessageKey(String messageKey) throws BusinessException;
	
}
