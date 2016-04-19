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

import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.service.AuditTypeService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditTypeServiceImplTest {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	
	@Autowired
	public AuditTypeService auditTypeService;
	
	/**
	 * 
	 * This method is used for test AddAuditType
	 */
	@Test
	public void test1AddAuditType()
	{
		try{
			
		AuditTypeEntity auditTypeEntity = new AuditTypeEntity();
		
		auditTypeEntity.setComponentKey("testComp");
		auditTypeEntity.setFunctionKey("testFunc");
		auditTypeEntity.setChannelUUID("402880ed5206d268015206d26bbf0000");
		
		
		auditTypeEntity.setCreateBy("testUser");
		auditTypeEntity.setCreateDate(GregorianCalendar.getInstance().getTime());
		
		auditTypeService.addAuditType(auditTypeEntity);
		Assert.assertNotNull(auditTypeEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to add AuditTypeEntity", ex);
		}
	}
	

	/**
	 * 
	 * This method is used for test UpdateAuditType
	 */
	@Test
	public void test2UpdateAuditType()
	{
		try{
			
			AuditTypeEntity auditTypeEntity = auditTypeService.getByComponentKey("testComp");
			
			auditTypeEntity.setFunctionKey("testUpdateKey");
			
			
			auditTypeEntity.setUpdateBy("testUser");
			auditTypeEntity.setUpdateDate(GregorianCalendar.getInstance().getTime());
			
			AuditTypeEntity returnAuditTypeEntity = auditTypeService.updateAuditType(auditTypeEntity);
			Assert.assertNotNull(returnAuditTypeEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to update AuditTypeEntity", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for test DeleteAuditType
	 */
	@Test
	public void test3DeleteAuditType()
	{
		try{
			
			
			AuditTypeEntity auditTypeEntity =  auditTypeService.getByComponentKey("testComp");
			
			auditTypeService.deleteAuditType(auditTypeEntity);
			Assert.assertTrue(auditTypeEntity.isDeleted());
		
		}catch(Exception ex){
			logger.error("Failed to delete AuditTypeEntity", ex);
		}
	}

	
	
	
}
