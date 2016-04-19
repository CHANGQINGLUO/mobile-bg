/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 25 Jun, 2014 2:31:22 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 25 Jun, 2014 2:31:22 pm
 * @author SPA
 * @mb-bg-ext-web
 * TestrestServiceWebConfig.java
 *
 */
package com.mb.ext.web.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/00-context-servlet.xml","00-context-web-index.xml"})
@ComponentScan(basePackages = {
        "com.mb.ext.web.controller"
})
public class TestRestServiceWebConfig extends WebMvcConfigurerAdapter {
	
	
	
	

}
