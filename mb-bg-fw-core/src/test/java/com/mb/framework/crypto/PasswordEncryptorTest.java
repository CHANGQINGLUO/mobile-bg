/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 15 Sep, 2014 7:55:38 pm
 * @author SPA
 * @mb-bg-fw-core
 * PasswordEncryptorTest.java
 *
 */
package com.mb.framework.crypto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.framework.crypto.PasswordEncryptor;

/**
 * @author SPA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
public class PasswordEncryptorTest
{
	@Autowired
	private PasswordEncryptor cryptor ;
	
	@Test
	public void getPassword()
	{
		String password = cryptor.getPassword();
		Assert.assertEquals(password, "password");
	}

}
