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
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.CurrencyDAO;
import com.mb.framework.entity.CurrencyEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.CurrencyService;
import com.mb.framework.util.log.LogHelper;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private CurrencyDAO currencyDAO;

	/**
	 * 
	 * This method is used for add CurrencyEntity
	 * @param currencyEntity
	 * @throws BusinessException
	 */
	@Override
	public void addCurrency(CurrencyEntity currencyEntity)
			throws BusinessException {

		try {
			currencyDAO.addCurrency(currencyEntity);
		} catch (Exception ex) {
			logger.error("Failed to add CurrencyEntity", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}

	}

	/**
	 * 
	 * This method is used for update CurrencyEntity
	 * @param currencyEntity
	 * @return CurrencyEntity
	 * @throws BusinessException
	 */
	@Override
	public CurrencyEntity updateCurrency(CurrencyEntity currencyEntity)
			throws BusinessException {

		CurrencyEntity returnCurrencyEntity = null;
		try {
			returnCurrencyEntity = currencyDAO.updateCurrency(currencyEntity);
		} catch (Exception ex) {
			logger.error("Failed to update CurrencyEntity", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnCurrencyEntity;
	}

	/**
	 * 
	 * This method is used for delete CurrencyEntity
	 * @param currencyEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteCurrency(CurrencyEntity currencyEntity)
			throws BusinessException {

		try {
			currencyDAO.deleteCurrency(currencyEntity);
		} catch (Exception ex) {
			logger.error("Failed to  delete CurrencyEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}

	/**
	 * This method is used for findByNumbericCurCode
	 * @param numbericCurCode
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public CurrencyEntity findByNumbericCurCode(String numbericCurCode) throws BusinessException {
		CurrencyEntity currencyEntity = null;
		try {
			currencyEntity = currencyDAO.findByNumbericCurCode(numbericCurCode);
		} catch (Exception ex) {
			logger.error("Failed to findByNumbericCurCode ", ex);
			throw new BusinessException(ErrorCodes.FM00027);
		}
		return currencyEntity;
	}

	/**
	 * This method is used for findByTextCurCode
	 * @param textCurCode
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public CurrencyEntity findByTextCurCode(String textCurCode) throws BusinessException {
		CurrencyEntity currencyEntity = null;
		try {
			currencyEntity = currencyDAO.findByTextCurCode(textCurCode);
		} catch (Exception ex) {
			logger.error("Failed to findByTextCurCode ", ex);
			throw new BusinessException(ErrorCodes.FM00028);
		}
		return currencyEntity;		
	}

	/**
	 * This method is used for getCurUuidByNumbericCurCode
	 * @param numbericCurCode
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public String getCurUuidByNumbericCurCode(String numbericCurCode) throws BusinessException {
		String uuid = null;
		CurrencyEntity currencyEntity = currencyDAO.findByNumbericCurCode(numbericCurCode);
		if(currencyEntity != null){
			uuid = currencyEntity.getCurrencyUuid();
		}
		return uuid;
	}

	/**
	 * This method is used for getCurUuidByTextCurCode
	 * @param textCurCode
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public String getCurUuidByTextCurCode(String textCurCode) throws BusinessException {
		String uuid = null;
		CurrencyEntity currencyEntity = currencyDAO.findByTextCurCode(textCurCode);
		if(currencyEntity != null){
			uuid = currencyEntity.getCurrencyUuid();
		}
		return uuid;
	}

	/**
	 * This method is used for 
	 * @param currencyUuid
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public String getCurrencyByCurrencyUuid(String currencyUuid) throws BusinessException {
		String currency = null;
		try {
			CurrencyEntity currencyEntity = currencyDAO.findCurrencyById(currencyUuid);
			currency = currencyEntity.getTextCurCode();
		} catch (Exception ex) {
			logger.error("Failed to getCurrencyByCurrencyUuid ", ex);
		}
			return currency;
	}

}
