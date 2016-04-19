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

import com.mb.framework.entity.AuditEntity;
import com.mb.framework.service.AuditService;
import com.mb.framework.service.spec.AuditDTO;
import com.mb.framework.service.spec.AuditTypeDTO;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditServiceImplTest {
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public AuditService auditService;
	

	/**
	 * 
	 * This method is used for test addAudit
	 */
	@Test
	public void test1AddAudit()
	{
		try {

		AuditDTO auditDTO = new AuditDTO();
		AuditTypeDTO auditType = new AuditTypeDTO();
		auditType.setComponentKey("Test");
		auditType.setFunctionKey("insert");
		auditType.setCreateDate(GregorianCalendar.getInstance().getTime());
		auditDTO.setAuditType(auditType);
		
		auditDTO.setUserUUID("402881f046a2cd6c0146a2cd74e80000");
		auditDTO.setSessionId("testSessionId");
		auditDTO.setCustCin("testCustID");
		auditDTO.setCustName("testCustName");
		auditDTO.setCreateDate(GregorianCalendar.getInstance().getTime());


		auditDTO.setData(new Object());

		
			auditService.addAudit(auditDTO);
			Assert.assertNotNull(auditDTO.getCustName());
			
			
		}catch(Exception ex){
			logger.error("Failed to add AuditEntity", ex);
		}
		

	}

	
	/**
	 * 
	 * This method is used for test updateAuditByCustCIN
	 */
	@Test
	public void test2UpdateAuditByCustCIN()
	{
		try{
			
			AuditEntity auditEntity = auditService.getByCustomerCin("testCustID");
			
			auditEntity.setSessionId("testSessionId");
			auditEntity.setCustName("testUpdateName");
			
			auditEntity.setUpdateBy("testupdateUser");
			auditEntity.setUpdateDate(GregorianCalendar.getInstance().getTime());
			
			AuditEntity returnAuditEntity = auditService.updateAudit(auditEntity);
			Assert.assertNotNull(returnAuditEntity.getUuid());
			
		
		}catch(Exception ex){
			logger.error("Failed to update AuditEntity by Cust CIN", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for test updateAuditByUserUUID
	 */
	@Test
	public void test3UpdateAuditByUserUUID()
	{
		try{
			
			AuditEntity auditEntity = auditService.getByUserUUID("402881f046a2cd6c0146a2cd74e80000");
			
			auditEntity.setSessionId("testSessionId");
			auditEntity.setCustName("testUpdateName");
			
			auditEntity.setUpdateBy("testupdateUser");
			auditEntity.setUpdateDate(GregorianCalendar.getInstance().getTime());
			
			AuditEntity returnAuditEntity = auditService.updateAudit(auditEntity);
			Assert.assertNotNull(returnAuditEntity.getUuid());
			
		
		}catch(Exception ex){
			logger.error("Failed to update AuditEntity by User UUID", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for test deleteAudit
	 */
	@Test
	public void test4DeleteAudit()
	{
		try{
			
			AuditEntity auditEntity = auditService.getByCustomerCin("testCustID");
			auditService.deleteAudit(auditEntity);
			Assert.assertTrue(auditEntity.isDeleted());
		
		}catch(Exception ex){
			logger.error("Failed to delte AuditEntity", ex);
		}
	}

	
	
	
}
