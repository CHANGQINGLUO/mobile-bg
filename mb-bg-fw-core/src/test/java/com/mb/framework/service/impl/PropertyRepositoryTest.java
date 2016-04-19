package com.mb.framework.service.impl;

import junit.framework.TestSuite;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertyRepositoryTest extends TestSuite {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	

	@Autowired
	PropertyRepository propertyRepository;
	
	/**
	 * 
	 * This method is used for test update value based on key
	 * @throws InterruptedException
	 */
	@Test
	public void updateProperty()
	{
		logger.info(" Berfor update key value: "+propertyRepository.getProperty("jdbc.password"));
		propertyRepository.setProperty("jdbc.password", "passdword-1");
		logger.info(" after update key value: " +  propertyRepository.getProperty("jdbc.password"));
		
	}
	

	
	 	
}
