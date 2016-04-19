package com.mb.framework.service.impl;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.framework.entity.ChannelEntity;
import com.mb.framework.service.ChannelService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChannelServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public ChannelService channelService;
	
	
	/**
	 * 
	 * This method is used for test addChannel
	 */
	@Test
	public void test1AddChannel()
	{
		try{
			
		ChannelEntity channelEntity = new ChannelEntity();
		
		channelEntity.setChannelId(101);
		channelEntity.setNameMsgKey("testMessage");
		channelEntity.setCreateBy("testUser");
		channelEntity.setCreateDate(GregorianCalendar.getInstance().getTime());
		
		channelService.addChannel(channelEntity);
		Assert.assertNotNull(channelEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to add ChannelEntity", ex);
		}
	}
	

	/**
	 * 
	 * This method is used for test updateChannel
	 */
	@Test
	public void test2UpdateChannel()
	{
		try{
			ChannelEntity channelEntity = channelService.getByChannelId(101);
			
			channelEntity.setNameMsgKey("testUpdate");
			channelEntity.setUpdateBy("tesUpdatetUser");
			channelEntity.setUpdateDate(GregorianCalendar.getInstance().getTime());
			
			ChannelEntity returnChannelEntity = channelService.updateChannel(channelEntity);
			Assert.assertNotNull(returnChannelEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to update ChannelEntity", ex);
		}
	}
	
	
	/**
	 * 
	 * This method is used for test deleteChannel
	 */
	@Test
	public void test3DeleteChannel()
	{
		try{
			
			ChannelEntity channelEntity = channelService.getByChannelId(101);
			
			channelService.deleteChannel(channelEntity);
			Assert.assertTrue(channelEntity.isDeleted());
		
		}catch(Exception ex){
			logger.error("Failed to delete ChannelEntity", ex);
		}
	}

	
	
	
}
