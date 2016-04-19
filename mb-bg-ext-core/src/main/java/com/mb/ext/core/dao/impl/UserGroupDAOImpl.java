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

import com.mb.ext.core.dao.UserGroupDAO;
import com.mb.ext.core.entity.UserGroupEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("userGroupDAO")
@Qualifier("userGroupDAO")
public class UserGroupDAOImpl extends AbstractDAO<UserGroupEntity> implements UserGroupDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public UserGroupDAOImpl()
	{
		super();
		this.setEntityClass(UserGroupEntity.class);
	}

	/**
	 * This method is used for inserting user user information.
	 * 
	 * @param userUser
	 */
	@Override
	public void addUserGroup(UserGroupEntity userGroup) throws DAOException
	{
		try{
			save(userGroup);
			logger.debug("The user group added is " + userGroup.getUserGroupUuid());
		}catch(Exception e){
			throw new DAOException(e);
		}
	}

}
