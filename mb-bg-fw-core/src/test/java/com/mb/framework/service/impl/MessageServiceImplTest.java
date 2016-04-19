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

import com.mb.framework.entity.MessageEntity;
import com.mb.framework.service.MessageService;
import com.mb.framework.util.log.LogHelper;


/**
 * 
 * @author SPA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public MessageService messageService;
	
	/**
	 * 
	 * This method is used for test add Message entity
	 */
	@Test
	public void test1AddMessage()
	{
		try{
			
		MessageEntity message = new MessageEntity();
		
		//Random randomGenerator = new Random();
		 
		//message.setMessageKey("m"+randomGenerator.nextInt(100));
		message.setMessageKey("messageKey");
		message.setMessageValue("testMessageValue");
		message.setLanguage("en");
		message.setCreateBy("testUser");
		message.setCreateDate(GregorianCalendar.getInstance().getTime());
		message.setCategoryEnum("testCategory");
		
		
		messageService.addMessage(message);
		Assert.assertNotNull(message.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to add MessageEntity", ex);
		}
	}
	

	/**
	 * 
	 * This method is used for update message entity
	 */
	@Test
	public void test2UpdateMessage()
	{
		try{
			
			MessageEntity message = messageService.getByMessagekey("messageKey","en");
			
			message.setUpdateBy("updateUser");
			message.setUpdateDate(GregorianCalendar.getInstance().getTime());
			message.setCategoryEnum("updateCateg");
			
			
			MessageEntity messageEntity = messageService.updateMessage(message);
			Assert.assertNotNull(messageEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to update MessageEntity", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for delete message entity
	 */
	@Test
	public void test3DeleteMessage()
	{
		try{
			
			MessageEntity message = messageService.getByMessagekey("messageKey","en");
			messageService.deleteMessage(message);
			Assert.assertTrue(message.isDeleted());
		
		}catch(Exception ex){
			logger.error("Failed to delete MessageEntity", ex);
		}
	}
}
