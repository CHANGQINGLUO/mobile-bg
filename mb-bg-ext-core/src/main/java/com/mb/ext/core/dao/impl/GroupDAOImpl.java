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

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.GroupDAO;
import com.mb.ext.core.entity.GroupEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("groupDAO")
@Qualifier("groupDAO")
public class GroupDAOImpl extends AbstractDAO<GroupEntity> implements GroupDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public GroupDAOImpl()
	{
		super();
		this.setEntityClass(GroupEntity.class);
	}

	/**
	 * This method is used for inserting user information.
	 * 
	 * @param user
	 */
	@Override
	public void addGroup(GroupEntity group)
	{
		save(group);
		logger.debug("The user added is " + group.getGroupUuid());
	}
	
	/**
	 * @param name
	 * @return 
	 * @throws Exception
	 */
	@Override
	public GroupEntity getGroup(String name) throws DAOException {
		logger.debug("GroupDAOImpl - retrieve group by name.");
		GroupEntity entity = null;
		try {
			entity = (GroupEntity)em.createQuery("select b from GroupEntity b where b.name = :NAME and b.isDeleted=:isDeleted",GroupEntity.class).setParameter("NAME", name).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for group.");
		}
		return entity;
	}

}
