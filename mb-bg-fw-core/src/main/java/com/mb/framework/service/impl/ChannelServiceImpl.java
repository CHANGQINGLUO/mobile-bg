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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.ChannelDAO;
import com.mb.framework.entity.ChannelEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.ChannelService;
import com.mb.framework.util.log.LogHelper;

@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public ChannelDAO channelDAO;

	/**
	 * 
	 * This method is used for add ChannelEntity
	 * @param channelEntity
	 * @throws BusinessException
	 */
	@Override
	public void addChannel(ChannelEntity channelEntity)
			throws BusinessException {

		logger.debug("ChannelServiceImpl - add for the Message Key - "
				+ channelEntity.getNameMsgKey() + " ChannelId is "
				+ channelEntity.getChannelId());

		try {
			channelDAO.addChannel(channelEntity);
		} catch (Exception ex) {
			logger.error("Failed to  channel add", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}

	}

	/**
	 * 
	 * This method is used for update ChannelEntity
	 * @param channelEntity
	 * @return ChannelEntity
	 * @throws BusinessException
	 */
	@Override
	public ChannelEntity updateChannel(ChannelEntity channelEntity)
			throws BusinessException {

		logger.debug("ChannelServiceImpl - update for the Message Key - "
				+ channelEntity.getNameMsgKey() + " ChannelId is "
				+ channelEntity.getChannelId());
		ChannelEntity returnChannelEntity = null;
		try {
			returnChannelEntity = channelDAO.updateChannel(channelEntity);
		} catch (Exception ex) {
			logger.error("Failed to  channel update", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnChannelEntity;
	}

	/**
	 * 
	 * This method is used for delete ChannelEntity
	 * @param channelEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteChannel(ChannelEntity channelEntity)
			throws BusinessException {

		logger.debug("ChannelServiceImpl - delete for the Message Key - "
				+ channelEntity.getNameMsgKey() + " ChannelId is "
				+ channelEntity.getChannelId());
		try {
			channelDAO.deleteChannel(channelEntity);
		} catch (Exception ex) {
			logger.error("Failed to  channel delete", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}

	/**
	 * 
	 * This method is used for get ChannelEntity by Channel Id
	 * @param channelId
	 * @return ChannelEntity
	 * @throws BusinessException
	 */
	@Override
	public ChannelEntity getByChannelId(int channelId) throws BusinessException {

		logger.debug("ChannelServiceImpl get for the ChannelId is " + channelId);
		try {
			return channelDAO.getByChannelId(channelId);
		} catch (Exception ex) {
			logger.error("Failed to get Channel entity", ex);
			throw new BusinessException(ErrorCodes.FM00022);
		}
	}
	

	/**
	 * This method is used to get ChannelEntity by message key
	 * table.
	 * 
	 * @param messageCode
	 * @return
	 * @throws BusinessException 
	 */
	public ChannelEntity getByMessageKey(String messageKey) throws BusinessException{
		logger.debug("ChannelServiceImpl get ChannelEntity for the messageKey is " + messageKey);
		try {
			return channelDAO.getByMessageKey(messageKey);
		} catch (Exception ex) {
			logger.error("Failed to get Channel entity", ex);
			throw new BusinessException(ErrorCodes.FM00022);
		}
	}

}
