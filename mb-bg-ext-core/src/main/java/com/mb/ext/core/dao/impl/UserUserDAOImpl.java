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
 * UserDAOImpl.java
 *
 */
package com.mb.ext.core.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.UserUserDAO;
import com.mb.ext.core.entity.UserUserEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("userUserDAO")
@Qualifier("userUserDAO")
public class UserUserDAOImpl extends AbstractDAO<UserUserEntity> implements UserUserDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public UserUserDAOImpl()
	{
		super();
		this.setEntityClass(UserUserEntity.class);
	}

	/**
	 * This method is used for inserting user user information.
	 * 
	 * @param userUser
	 */
	@Override
	public void addUserUser(UserUserEntity userUser)
	{
		save(userUser);
		logger.debug("The user user added is " + userUser.getUserUserUuid());
	}

}
