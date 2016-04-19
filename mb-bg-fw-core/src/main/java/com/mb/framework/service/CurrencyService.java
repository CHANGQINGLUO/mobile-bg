/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2014-12-17T17:36:32
 * @author SPA
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.CurrencyEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface CurrencyService{

	/**
	 * This method is used to insert the CurrencyEntity
	 * 
	 * @param CurrencyEntity
	 * @return 
	 */
	public void addCurrency(CurrencyEntity currencyEntity) throws BusinessException;
	
	/**
	 * This method is used to update the CurrencyEntity
	 * 
	 * @param CurrencyEntity
	 * @return CurrencyEntity
	 */
	public CurrencyEntity updateCurrency(CurrencyEntity currencyEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteCurrency(CurrencyEntity currencyEntity) throws BusinessException;
	
	/**
	 * 
	 * This method is used for findByNumbericCurCode
	 * @param numbericCurCode
	 * @return
	 * @throws BusinessException
	 */
	public CurrencyEntity findByNumbericCurCode(String numbericCurCode) throws BusinessException;
	
	
	/**
	 * 
	 * This method is used for findByTextCurCode
	 * @param textCurCode
	 * @return
	 * @throws BusinessException
	 */
	public CurrencyEntity findByTextCurCode(String textCurCode) throws BusinessException;
	
	
	/**
	 * 
	 * This method is used for getCurUuidByNumbericCurCode
	 * @param textCurCode
	 * @return
	 * @throws BusinessException
	 */
	public String getCurUuidByNumbericCurCode(String numbericCurCode) throws BusinessException;
	
	
	/**
	 * 
	 * This method is used for getCurUuidByTextCurCode
	 * @param textCurCode
	 * @return
	 * @throws BusinessException
	 */
	public String getCurUuidByTextCurCode(String textCurCode) throws BusinessException;
	
	/**
	 * 
	 * This method is used for 
	 * @param currencyUuid
	 * @return
	 * @throws BusinessException
	 */
	public String getCurrencyByCurrencyUuid(String currencyUuid) throws BusinessException;
}
