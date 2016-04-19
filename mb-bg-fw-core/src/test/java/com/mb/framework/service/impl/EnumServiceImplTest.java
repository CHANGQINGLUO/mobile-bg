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

import com.mb.framework.entity.EnumEntity;
import com.mb.framework.service.EnumService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnumServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public EnumService enumService;
	

	/**
	 * 
	 * This method is used for add Enum entity
	 */
	@Test
	public void test1AddEnum()
	{
		try{
			
		//Random randomGenerator = new Random();
			 
			
		EnumEntity enumEntity = new EnumEntity();
		
		enumEntity.setMessageKey("messageKey");
		//enumEntity.setMessageKey("m"+randomGenerator.nextInt(100));
		enumEntity.setCategory("testEnumCat");		
		enumEntity.setRanking(1);
		enumEntity.setCreateBy("testUser");
		enumEntity.setCreateDate(GregorianCalendar.getInstance().getTime());
		
		enumService.addEnum(enumEntity);
		Assert.assertNotNull(enumEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to add EnumEntity", ex);
		}
	}
	
    /**
     * 
     * This method is used for update Enum entity
     */
	@Test
	public void test2UpdateEnum()
	{
		try{
			
			EnumEntity enumEntity = enumService.getByMessagekey("messageKey");
			
			enumEntity.setCategory("updateCate");
			enumEntity.setRanking(1);
			enumEntity.setUpdateBy("testUpdateUser");
			enumEntity.setUpdateDate(GregorianCalendar.getInstance().getTime());
			
			enumService.updateEnum(enumEntity);
			Assert.assertNotNull(enumEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to update EnumEntity", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for test delete Enum entity
	 */
	@Test
	public void test3DeleteEnum()
	{
		try{
			
			EnumEntity enumEntity = enumService.getByMessagekey("messageKey");
			
			enumService.deleteEnum(enumEntity);
			Assert.assertTrue(enumEntity.isDeleted());
		
		}catch(Exception ex){
			logger.error("Failed to delete EnumEntity", ex);
		}
	}

	
	
	
}
