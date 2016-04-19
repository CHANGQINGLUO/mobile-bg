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
import com.mb.framework.entity.CountryEntity;
import com.mb.framework.service.EnumService;
import com.mb.framework.service.CountryService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public CountryService CountryService;
	
	
    /**
     * 
     * This method is used for update Enum entity
     */
	@Test
	public void testQueryCountry()
	{
		try{
			
			CountryEntity CountryEntity = CountryService.findByAlpha2Cd("AO");
			Assert.assertNotNull(CountryEntity.getCountryCodeUuid());
		
		}catch(Exception ex){
			logger.error("Failed to query Country", ex);
		}
	}
	
	
}
