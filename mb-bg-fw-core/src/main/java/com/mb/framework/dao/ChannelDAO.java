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

import com.mb.framework.entity.ChannelEntity;

public interface ChannelDAO {
	/**
	 * This method is used to insert the ChannelEntity in SYS_CHANNEL table.
	 * @param ChannelEntity
	 */
	public void addChannel(ChannelEntity channelEntity);

	/**
	 * This method is used to update the ChannelEntity in SYS_CHANNEL table.
	 * @param ChannelEntity
	 * @return ChannelEntity
	 */
	public ChannelEntity updateChannel(ChannelEntity channelEntity);

	/**
	 * This method is used to delete the ChannelEntity from SYS_CHANNEL table.
	 * @param ChannelEntity
	 */
	public void deleteChannel(ChannelEntity channelEntity);

	/**
	 * This method is used to get ChannelEntity by Channel Id from SYS_CHANNEL table.
	 * @param channelId
	 * @return ChannelEntity
	 */
	public ChannelEntity getByChannelId(int channelId);
	
	/**
	 * This method is used to get ChannelEntity by messageCode from SYS_CHANNEL table.
	 * @param messageCode
	 * @return ChannelEntity
	 */
	public ChannelEntity getByMessageKey(String messageCode);
	
}
