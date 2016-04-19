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

import com.mb.ext.core.dao.ArticleDAO;
import com.mb.ext.core.entity.ArticleEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("articleDAO")
@Qualifier("articleDAO")
public class ArticleDAOImpl extends AbstractDAO<ArticleEntity> implements ArticleDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public ArticleDAOImpl()
	{
		super();
		this.setEntityClass(ArticleEntity.class);
	}

	/**
	 * This method is used for inserting article information.
	 * 
	 * @param news
	 */
	@Override
	public void addArticle(ArticleEntity article)
	{
		save(article);
		logger.debug("The article added is " + article.getArticleUuid());
	}
	
	/**
	 * This method is used for inserting article information.
	 * 
	 * @param news
	 */
	@Override
	public void updateArticle(ArticleEntity article)
	{
		update(article);
		logger.debug("The article added is " + article.getArticleUuid());
	}
	
	/**
	 * This method is used for delete article information.
	 * 
	 * @param news
	 */
	@Override
	public void deleteArticle(ArticleEntity article)
	{
		delete(article);
		logger.debug("The article deleted is " + article.getArticleUuid());
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public List<ArticleEntity> getArticles() throws DAOException {
		logger.debug("ArticleDAOImpl - retrieve articles.");
		List<ArticleEntity> entityList = new ArrayList<ArticleEntity>();
		try {
			entityList = em.createQuery("select b from ArticleEntity b where b.isDeleted=:isDeleted and b.status=:status",ArticleEntity.class).setParameter("isDeleted", Boolean.FALSE).setParameter("status", "P").getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for article.");
		}
		return entityList;
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public ArticleEntity getArticleByUUID(String uuid) throws DAOException {
		logger.debug("ArticleDAOImpl - retrieve articles.");
		ArticleEntity entity = new ArticleEntity();
		try {
			entity = (ArticleEntity)em.createQuery("select b from ArticleEntity b where b.articleUuid=:uuid",ArticleEntity.class).setParameter("uuid", uuid).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for article.");
		}
		return entity;
	}
	
	/**
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	@Override
	public List<ArticleEntity> getArticleByType(String type) throws DAOException {
		logger.debug("ArticleDAOImpl - retrieve articles.");
		List<ArticleEntity> entityList = new ArrayList<ArticleEntity>();
		try {
			entityList = em.createQuery("select b from ArticleEntity b where b.type=:type and b.isDeleted=:isDeleted order by b.createDate desc",ArticleEntity.class).setParameter("type", type).setParameter("isDeleted", Boolean.FALSE).getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for article.");
		}
		return entityList;
	}

}
