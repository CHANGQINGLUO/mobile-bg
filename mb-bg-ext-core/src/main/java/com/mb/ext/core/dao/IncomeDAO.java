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
 * IncomeDAO.java
 *
 */
package com.mb.ext.core.dao;

import com.mb.ext.core.entity.IncomeEntity;
import com.mb.framework.exception.DAOException;

/**
 * @author SPA
 * 
 */
public interface IncomeDAO
{
	/**
	 * 
	 * This method is used for inserting income information.
	 * 
	 * @param income
	 */
	void addIncome(IncomeEntity income) throws DAOException;
	
	/**
	 * @param email
	 * @return 
	 * @throws DAOException
	 */
	public IncomeEntity getIncome(String uuid) throws DAOException;
	
	
}
