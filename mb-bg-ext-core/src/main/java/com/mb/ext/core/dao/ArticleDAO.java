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

import com.mb.ext.core.entity.ArticleEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface ArticleDAO
{
	/**
	 * 
	 * This method is used for inserting article information.
	 * 
	 * @param article
	 */
	void addArticle(ArticleEntity articleEntity) throws DAOException;
	/**
	 * 
	 * This method is used for inserting article information.
	 * 
	 * @param article
	 */
	void updateArticle(ArticleEntity articleEntity) throws DAOException;
	
	/**
	 * 
	 * This method is used for inserting article information.
	 * 
	 * @param article
	 */
	void deleteArticle(ArticleEntity articleEntity) throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public List<ArticleEntity> getArticles() throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public ArticleEntity getArticleByUUID(String uuid) throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public List<ArticleEntity> getArticleByType(String type) throws DAOException;
}
