/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @since 2014-12-17T17:36:32
 * @author SPA
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.CurrencyEntity;

public interface CurrencyDAO {

	/**
	 * This method is used for Currency data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public CurrencyEntity findCurrencyById(String id);
	
	/**
	 * This method is used to insert the CurrencyEntity .
	 * 
	 * @param currencyEntity
	 * @return
	 */
	public void addCurrency(CurrencyEntity currencyEntity);

	/**
	 * This method is used to update the CurrencyEntity.
	 * 
	 * @param currencyEntity
	 * @return CurrencyEntity
	 */
	public CurrencyEntity updateCurrency(CurrencyEntity currencyEntity);

	/**
	 * This method is used to delete the CurrencyEntity .
	 * 
	 * @param CurrencyEntity
	 * @return
	 */
	public void deleteCurrency(CurrencyEntity currencyEntity);
	
	
	/**
	 * 
	 * This method is used for findByNumbericCurCode
	 * @param numbericCurCode
	 * @return
	 */
	public CurrencyEntity findByNumbericCurCode(String numbericCurCode);
	
	/**
	 * 
	 * This method is used for findByTextCurCode
	 * @param textCurCode
	 * @return
	 */
	public CurrencyEntity findByTextCurCode(String textCurCode);

}
