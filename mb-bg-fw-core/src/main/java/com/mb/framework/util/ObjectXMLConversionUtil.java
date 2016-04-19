/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of My Company
 * Use is subjected to license terms. 
 *
 * @since 18 Jun, 2014 6:01:12 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * 
 */
package com.mb.framework.util;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;

/**
 * @author SPA
 * 
 */
@Component
public class ObjectXMLConversionUtil
{

	
	/**
	 * 
	 * This method is used to convert object to xml string.
	 * 
	 * @param Object
	 * @return String
	 * 
	 */
	public String convertObjectToXML(final Object obj)
	{
		String resultString = null;
		final XStream xs = new XStream();
		xs.autodetectAnnotations(true);

		resultString = xs.toXML(obj);
		if (null != resultString)
		{
			resultString = resultString.replaceAll("\\r|\\n|\\s", "");

		}

		return resultString;
	}

	/**
	 * 
	 * This method is used to convert xml string to object.
	 * 
	 * @param String
	 * @return Object
	 * 
	 */
	public Object convertXMLToObject(final String xmlString)
	{
	
		final XStream xs = new XStream();
		xs.autodetectAnnotations(true);
		final Object obj = xs.fromXML(xmlString);

		return obj;
	}

}
