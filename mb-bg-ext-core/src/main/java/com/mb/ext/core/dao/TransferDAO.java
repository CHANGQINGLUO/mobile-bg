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
 * TransferDAO.java
 *
 */
package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.TransferEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface TransferDAO
{
	/**
	 * 
	 * This method is used for inserting transfer information.
	 * 
	 * @param transfer
	 */
	void addTransfer(TransferEntity transfer) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public TransferEntity getTransfer(String uuid) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public List<TransferEntity> getTransfers() throws DAOException;
	
	
}
