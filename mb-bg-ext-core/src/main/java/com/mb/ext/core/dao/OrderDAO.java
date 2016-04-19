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
 * OrderDAO.java
 *
 */
package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.OrderEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface OrderDAO
{
	/**
	 * 
	 * This method is used for inserting order information.
	 * 
	 * @param order
	 */
	void addOrder(OrderEntity order) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public OrderEntity getOrder(String uuid) throws DAOException;
	
	public OrderEntity getOrderByNumber(String orderNumber) throws DAOException;
	
	public List<OrderEntity> getOrders() throws DAOException;
	
	public void updateOrder(OrderEntity orderEntity) throws DAOException;
	
}
