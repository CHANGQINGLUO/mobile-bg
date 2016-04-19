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
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.CountryEntity;
import com.mb.framework.entity.CurrencyEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface CountryService{

	/**
	 * This method is used to insert the CountryEntity
	 * 
	 * @param CountryEntity
	 * @return 
	 */
	public void addCountry(CountryEntity countryEntity) throws BusinessException;
	
	/**
	 * This method is used to update the CountryEntity
	 * 
	 * @param CountryEntity
	 * @return CountryEntity
	 */
	public CountryEntity updateCountry(CountryEntity countryEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteCountry(CountryEntity countryEntity) throws BusinessException;
	
	/**
	 * 
	 * This method is used for findByAlpha2Cd
	 * @param alpha2Cd
	 * @return
	 * @throws BusinessException
	 */
	public CountryEntity findByAlpha2Cd(String alpha2Cd) throws BusinessException;
	
}
