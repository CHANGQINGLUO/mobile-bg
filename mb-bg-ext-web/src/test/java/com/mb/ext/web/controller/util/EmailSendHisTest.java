package com.mb.ext.web.controller.util;
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 14 Jun, 2014 7:59:33 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 *//*
*//**
 * 
 *//*
package com.mb.ext.web.controller.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.web.util.EmailSendHis;
import com.mb.framework.exception.BusinessException;

*//**
 * @author 
 * 
 *//*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-web-index.xml")
public class EmailSendHisTest
{
	@Autowired
	private EmailSendHis emailSendHis;
	
	*//**
	 * Test method for user positive scenario.
	 *//*
	@Test
	public void logEmaiSendHisTest() throws BusinessException
	{
		try{
			HeaderDTO header = new HeaderDTO();
			header.setCustomerEmailToSend("ribtwuser1@gmail.com");
			header.setRmEmailAddress("sparm56@gmail.com");
			
			emailSendHis.logEmaiSendHis(header,"343", "1");
			
			System.out.println("success!!!!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
*/