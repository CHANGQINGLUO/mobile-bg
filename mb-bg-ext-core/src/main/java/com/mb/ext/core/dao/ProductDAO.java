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
 * ProductDAO.java
 *
 */
package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.ArticleEntity;
import com.mb.ext.core.entity.ProductEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface ProductDAO
{
	/**
	 * 
	 * This method is used for inserting product information.
	 * 
	 * @param product
	 */
	void addProduct(ProductEntity product) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public ProductEntity getProduct(String id) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public ProductEntity getProductByName(String name) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public ProductEntity getProductByUUID(String uuid) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public List<ProductEntity> getProductsByType(String type) throws DAOException;
	
	void updateProduct(ProductEntity productEntity) throws DAOException;
	
	void deleteProduct(ProductEntity productEntity) throws DAOException;
}
