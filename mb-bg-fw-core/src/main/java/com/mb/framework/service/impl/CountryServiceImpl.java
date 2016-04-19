/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2014-12-17T18:09:10
 * @author SPA
 *
 */
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.CountryDAO;
import com.mb.framework.entity.CountryEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.CountryService;
import com.mb.framework.util.log.LogHelper;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private CountryDAO countryDAO;

	/**
	 * 
	 * This method is used for add CountryEntity
	 * @param countryEntity
	 * @throws BusinessException
	 */
	@Override
	public void addCountry(CountryEntity countryEntity)
			throws BusinessException {

		try {
			countryDAO.addCountry(countryEntity);
		} catch (Exception ex) {
			logger.error("Failed to add CountryEntity", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}

	}

	/**
	 * 
	 * This method is used for update CountryEntity
	 * @param countryEntity
	 * @return CountryEntity
	 * @throws BusinessException
	 */
	@Override
	public CountryEntity updateCountry(CountryEntity countryEntity)
			throws BusinessException {

		CountryEntity returnCountryEntity = null;
		try {
			returnCountryEntity = countryDAO.updateCountry(countryEntity);
		} catch (Exception ex) {
			logger.error("Failed to update CountryEntity", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnCountryEntity;
	}

	/**
	 * 
	 * This method is used for delete CountryEntity
	 * @param countryEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteCountry(CountryEntity countryEntity)
			throws BusinessException {

		try {
			countryDAO.deleteCountry(countryEntity);
		} catch (Exception ex) {
			logger.error("Failed to  delete CountryEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}

	@Override
	public CountryEntity findByAlpha2Cd(String alpha2Cd)
			throws BusinessException {
		CountryEntity entity;
		try {
			entity = countryDAO.findByAlpha2Cd(alpha2Cd);
		} catch (Exception ex) {
			logger.error("Failed to  qnery CountryEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
		return entity;
	}

}
