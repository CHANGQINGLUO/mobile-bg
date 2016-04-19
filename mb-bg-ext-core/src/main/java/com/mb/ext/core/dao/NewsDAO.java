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

import com.mb.ext.core.entity.NewsEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface NewsDAO
{
	/**
	 * 
	 * This method is used for inserting news information.
	 * 
	 * @param user
	 */
	void addNews(NewsEntity news) throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public List<NewsEntity> getNews() throws DAOException;
	
	/**
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public NewsEntity getNewsByUUID(String uuid) throws DAOException;
}
