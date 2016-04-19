/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 25 Jun, 2014 4:22:32 pm
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
 * @since 25 Jun, 2014 4:22:32 pm
 * @author SPA
 * @mb-bg-ext-web
 * TestUtil.java
 *
 */
package com.mb.ext.web.controller;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * @author SPA
 * 
 */
public class TestUtil
{
	/**
	 * Convert object to byte array 03.
	 * 
	 * @param object
	 * 
	 * @return
	 */
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
	
	/**
	* Convert object to JSON String
	* @param object
	* @return
	* @throws JsonGenerationException
	* @throws JsonMappingException
	* @throws IOException
	*/

	public static String fromJavaToJson(Serializable object)

	throws JsonGenerationException, JsonMappingException, IOException {

	ObjectMapper jsonMapper = new ObjectMapper();
	
	return jsonMapper.writeValueAsString(object);
	
	}
}
