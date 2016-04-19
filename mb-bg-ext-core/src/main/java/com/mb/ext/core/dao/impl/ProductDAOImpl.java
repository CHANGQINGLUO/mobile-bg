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

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.ProductDAO;
import com.mb.ext.core.entity.ArticleEntity;
import com.mb.ext.core.entity.ProductEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("productDAO")
@Qualifier("productDAO")
public class ProductDAOImpl extends AbstractDAO<ProductEntity> implements ProductDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public ProductDAOImpl()
	{
		super();
		this.setEntityClass(ProductEntity.class);
	}

	/**
	 * This method is used for inserting user information.
	 * 
	 * @param user
	 */
	@Override
	public void addProduct(ProductEntity product)
	{
		save(product);
		logger.debug("The user added is " + product.getProductUuid());
	}
	
	/**
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	@Override
	public ProductEntity getProduct(String id) throws DAOException {
		logger.debug("ProductDAOImpl - retrieve product by  id.");
		ProductEntity entity = null;
		try {
			entity = (ProductEntity)em.createQuery("select b from ProductEntity b where b.id = :ID and b.isDeleted=:isDeleted",ProductEntity.class).setParameter("ID", id).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}


	@Override
	public List<ProductEntity> getProductsByType(String type)
			throws DAOException {
		logger.debug("ProductDAOImpl - retrieve product by  type.");
		List<ProductEntity> entityList = null;
		try {
			entityList = em.createQuery("select b from ProductEntity b where b.type = :TYPE and b.isDeleted=:isDeleted",ProductEntity.class).setParameter("TYPE", type).setParameter("isDeleted", Boolean.FALSE).getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entityList;
	}

	@Override
	public ProductEntity getProductByUUID(String uuid) throws DAOException {
		logger.debug("ProductDAOImpl - retrieve product by  id.");
		ProductEntity entity = null;
		try {
			entity = (ProductEntity)em.createQuery("select b from ProductEntity b where b.productUuid = :UUID and b.isDeleted=:isDeleted",ProductEntity.class).setParameter("UUID", uuid).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

	@Override
	public void updateProduct(ProductEntity productEntity) throws DAOException {
		update(productEntity);
		logger.debug("The product updated is " + productEntity.getProductUuid());
		
	}

	@Override
	public void deleteProduct(ProductEntity productEntity) throws DAOException {
		delete(productEntity);
		
	}

	@Override
	public ProductEntity getProductByName(String name) throws DAOException {
		logger.debug("ProductDAOImpl - retrieve product by  name.");
		ProductEntity entity = null;
		try {
			entity = em.createQuery("select b from ProductEntity b where b.name = :NAME and b.isDeleted=:isDeleted",ProductEntity.class).setParameter("NAME", name).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

}
