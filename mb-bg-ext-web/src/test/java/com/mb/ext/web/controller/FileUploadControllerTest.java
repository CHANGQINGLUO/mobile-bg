package com.mb.ext.web.controller;
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-web
 *
 *//*
*//**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2 Jul, 2014 2:54:06 pm
 * @author SPA
 * @mb-bg-ext-web
 * FileUploadControllerTest.java
 *
 *//*
package com.mb.ext.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.web.controller.FileUploadController;

*//**
 * @author SPA
 * 
 *//*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestRestServiceWebConfig.class })
public class FileUploadControllerTest
{

	private MockMvc mockMvc;

	@InjectMocks
	private FileUploadController fileUploadController;


	*//**
	 * 
	 * This method is used for initializing the mock controller
	 *//*
	@Before
	public void setUp()
	{

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(fileUploadController).build();

	}

	*//**
	 * 
	 * This method is used for testing controller post method.
	 * 
	 * @throws Exception
	 *//*
	@Test
	public void testCreate() throws Exception
	{

		FileInputStream inputFile = new FileInputStream("D:\\Test.pdf");
		MockMultipartFile file = new MockMultipartFile("file", "Test.pdf", "multipart/form-data", inputFile);

		this.mockMvc.perform(fileUpload("/sendMail").file(file).param("customerEmail", "swapnildigambar@gmail.com").param("rmEmail", "swapnildigambar@gmail.com")).andExpect(status().isOk());
	}

	*//**
	 * 
	 * This method is used to create mock request.
	 * 
	 * @return
	 *//*
	private RequestDTO createRequest()
	{
		String userName = "testUser";

		RequestDTO request = new RequestDTO();

		HeaderDTO header = new HeaderDTO();
		header.setAppName("YFP");
		header.setCustomerEmailToSend("prithakundu@gmail.com");
		header.setRmEmailAddress("thuminkyaw@gmail.com");
		header.setRequestType("save");
		header.setUser(userName);
		request.setHeader(header);
		return request;
	}
	
	

}
*/