/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.ext.core.util;

import java.util.Random;

public class KeyGenerator
{
	public synchronized  static String genertePk(){
		Random random = new Random();
		long next = random.nextInt(10000);
		return String.valueOf(next);
	}
}
