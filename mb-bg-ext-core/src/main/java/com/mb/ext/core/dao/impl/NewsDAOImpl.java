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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.NewsDAO;
import com.mb.ext.core.entity.ArticleEntity;
import com.mb.ext.core.entity.NewsEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("newsDAO")
@Qualifier("newsDAO")
public class NewsDAOImpl extends AbstractDAO<NewsEntity> implements NewsDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public NewsDAOImpl()
	{
		super();
		this.setEntityClass(NewsEntity.class);
	}

	/**
	 * This method is used for inserting news information.
	 * 
	 * @param news
	 */
	@Override
	public void addNews(NewsEntity news)
	{
		save(news);
		logger.debug("The news added is " + news.getNewsUuid());
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public List<NewsEntity> getNews() throws DAOException {
		logger.debug("NewsDAOImpl - retrieve news.");
		List<NewsEntity> entityList = new ArrayList<NewsEntity>();
		try {
			entityList = em.createQuery("select b from NewsEntity b where b.isDeleted=:isDeleted and b.status=:status",NewsEntity.class).setParameter("isDeleted", Boolean.FALSE).setParameter("status", "P").getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for news.");
		}
		return entityList;
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public NewsEntity getNewsByUUID(String uuid) throws DAOException {
		logger.debug("NewsDAOImpl - retrieve news.");
		NewsEntity entity = new NewsEntity();
		try {
			entity = (NewsEntity)em.createQuery("select b from NewsEntity b where b.newsUuid=:uuid",NewsEntity.class).setParameter("uuid", uuid).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for news.");
		}
		return entity;
	}

}
