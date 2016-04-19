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
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 * UserDAO.java
 *
 */
package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.IMessageEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface IMessageDAO
{
	/**
	 * 
	 * This method is used for inserting message information.
	 * 
	 * @param message
	 */
	void addMessage(IMessageEntity message) throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public List<IMessageEntity> getMessages() throws DAOException;
	

}
