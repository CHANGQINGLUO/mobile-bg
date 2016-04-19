/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 22 Jul, 2014 3:51:37 pm
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
 * @since 22 Jul, 2014 3:51:37 pm
 * @author SPA
 * @mb-bg-ext-web
 * ConnectionTestController.java
 *
 */
package com.mb.ext.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mb.ext.core.service.spec.ConnectionDTO;
import com.mb.ext.web.util.ConnectivityCheckUtil;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Controller
public class ConnectionTestController
{
	private static int refreshCount = 0;

	private static final int TOTAL_ALLOWED_REFRESH_COUNT = 200;

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private ConnectivityCheckUtil connCheckUtil;

	/**
	 * 
	 * This method is used for testing connectivity of database and service
	 * host.
	 * 
	 * @param model
	 * @return view
	 */
	@RequestMapping(value = "/testConnection", method = RequestMethod.GET)
	public String getConnectionDetails(ModelMap model)
	{
		String viewName = "testConnection";
		refreshCount++;
		if (refreshCount > TOTAL_ALLOWED_REFRESH_COUNT)
		{
			viewName = "connError";
		}
		else
		{

			try
			{

				logger.info("getConnectionDetails");
				List<ConnectionDTO> connList = new ArrayList<ConnectionDTO>();
				// test database connectivity
				ConnectionDTO dbConn = connCheckUtil.getDBConnectivity();
				connList.add(dbConn);
				// test host service connectivity
//				ConnectionDTO hostConn = connCheckUtil.getHostConnectivity();
//				connList.add(hostConn);
				model.addAttribute("connDetails", connList);
			}
			catch (Exception e)
			{
				logger.error("Exception occurred in connectivity test controller", e);
			}
		}
		return viewName;
	}
}
