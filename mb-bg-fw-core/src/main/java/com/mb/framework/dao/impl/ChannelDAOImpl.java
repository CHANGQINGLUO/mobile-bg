/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.ChannelDAO;
import com.mb.framework.entity.ChannelEntity;

@Repository("channelDAO")
public class ChannelDAOImpl extends AbstractDAO<ChannelEntity> implements ChannelDAO
{

	/**
	 * default constructor
	 */
	public ChannelDAOImpl()
	{
		super();
		this.setEntityClass(ChannelEntity.class);
	}

	/**
	 * This method is used to insert the Channel in SYS_CHANNEL table.
	 * 
	 * @param ChannelEntity
	 */
	public void addChannel(ChannelEntity channelEntity)
	{
		save(channelEntity);
	}

	/**
	 * This method is used to update the Channel in SYS_CHANNEL table.
	 * 
	 * @param ChannelEntity
	 * @return ChannelEntity
	 */
	public ChannelEntity updateChannel(ChannelEntity channelEntity)
	{
		return update(channelEntity);
	}

	/**
	 * This method is used to delete the Channel from SYS_CHANNEL table.
	 * 
	 * @param ChannelEntity
	 */
	public void deleteChannel(ChannelEntity channelEntity)
	{
		delete(channelEntity);
	}

	/**
	 * This method is used to get channelEntity by Channel Id from SYS_CHANNEL
	 * table.
	 * 
	 * @param channelId
	 * @return ChannelEntity
	 */
	public ChannelEntity getByChannelId(int channelId)
	{
		return em.createQuery("select ce from ChannelEntity ce where ce.channelId = :channelId and ce.isDeleted=:isDeleted", ChannelEntity.class).setParameter("channelId", channelId).setParameter("isDeleted", false).getSingleResult();
	}

	/**
	 * This method is used to get ChannelEntity by messageCode from SYS_CHANNEL
	 * table.
	 * 
	 * @param messageCode
	 * @return
	 */
	public ChannelEntity getByMessageKey(String messageKey)
	{
		return em.createQuery("select ce from ChannelEntity ce where ce.nameMsgKey = :messageKey and ce.isDeleted=:isDeleted", ChannelEntity.class).setParameter("messageKey", messageKey).setParameter("isDeleted", false).getSingleResult();
	}

}
