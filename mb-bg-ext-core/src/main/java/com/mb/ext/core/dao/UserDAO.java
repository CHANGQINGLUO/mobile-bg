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

import com.mb.ext.core.entity.UserEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface UserDAO
{
	/**
	 * 
	 * This method is used for inserting user information.
	 * 
	 * @param user
	 */
	void addUser(UserEntity user);
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public UserEntity getUser(String id) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public UserEntity getUserByUUID(String uuid) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public UserEntity getUserByClientCode(String clientCode) throws DAOException;
}
