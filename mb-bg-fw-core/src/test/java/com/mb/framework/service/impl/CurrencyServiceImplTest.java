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
import com.mb.framework.entity.CurrencyEntity;
import com.mb.framework.service.EnumService;
import com.mb.framework.service.CurrencyService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CurrencyServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public CurrencyService CurrencyService;
	
	
    /**
     * 
     * This method is used for update Enum entity
     */
	@Test
	public void testQueryCurrency()
	{
		try{
			
			CurrencyEntity CurrencyEntity = CurrencyService.findByTextCurCode("AMD");
			Assert.assertNotNull(CurrencyEntity.getCurrencyUuid());
		
		}catch(Exception ex){
			logger.error("Failed to query CurrencyEntity", ex);
		}
	}
	
	
}
