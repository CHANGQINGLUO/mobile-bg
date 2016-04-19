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

import com.mb.ext.core.entity.UserGroupEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface UserGroupDAO 
{
	/**
	 * 
	 * This method is used for inserting user group information.
	 * 
	 * @param user
	 */
	void addUserGroup(UserGroupEntity userGroup) throws DAOException;
	

}
