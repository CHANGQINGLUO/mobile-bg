package com.mb.ext.web.controller;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.ext.web.util.MailSenderUtil;
import com.mb.framework.util.log.LogHelper;


/**
 * 
 * @author SPA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-web-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailSendTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public MailSenderUtil mailSenderUtil;
	
	@Test
	public void testMailSend(){
		try {
			String subject = "Test Email";
			String body = "This is a test email";
			String sentTo = "37579743@qq.com";
			String ccTo = "luochangqing@outlook.com";
			
			mailSenderUtil.sendMail(subject,body,sentTo,ccTo,null);

			} catch (Exception e) {
				Assert.fail();
			}
		}
	
}
