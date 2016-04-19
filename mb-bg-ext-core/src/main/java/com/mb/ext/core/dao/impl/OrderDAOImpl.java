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

import com.mb.ext.core.dao.OrderDAO;
import com.mb.ext.core.entity.OrderEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("orderDAO")
@Qualifier("orderDAO")
public class OrderDAOImpl extends AbstractDAO<OrderEntity> implements OrderDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public OrderDAOImpl()
	{
		super();
		this.setEntityClass(OrderEntity.class);
	}

	/**
	 * This method is used for inserting user information.
	 * 
	 * @param user
	 */
	@Override
	public void addOrder(OrderEntity order)
	{
		save(order);
		logger.debug("The user added is " + order.getOrderUuid());
	}
	
	/**
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	@Override
	public OrderEntity getOrder(String uuid) throws DAOException {
		logger.debug("OrderDAOImpl - retrieve order by  id.");
		OrderEntity entity = null;
		try {
			entity = (OrderEntity)em.createQuery("select b from OrderEntity b where b.orderUuid = :UUID and b.isDeleted=:isDeleted",OrderEntity.class).setParameter("UUID", uuid).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

	@Override
	public void updateOrder(OrderEntity orderEntity) throws DAOException {
		save(orderEntity);
	}

	@Override
	public List<OrderEntity> getOrders() throws DAOException {
		logger.debug("OrderDAOImpl - retrieve order by  id.");
		List<OrderEntity> entityList = null;
		try {
			entityList = em.createQuery("select b from OrderEntity b where b.isDeleted=:isDeleted order by b.createDate desc",OrderEntity.class).setParameter("isDeleted", Boolean.FALSE).getResultList();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entityList;
	}

	@Override
	public OrderEntity getOrderByNumber(String orderNumber) throws DAOException {
		logger.debug("OrderDAOImpl - retrieve order by  id.");
		OrderEntity entity = null;
		try {
			entity = (OrderEntity)em.createQuery("select b from OrderEntity b where b.orderNumber = :ORDERNUMBER and b.isDeleted=:isDeleted",OrderEntity.class).setParameter("ORDERNUMBER", orderNumber).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}



}
