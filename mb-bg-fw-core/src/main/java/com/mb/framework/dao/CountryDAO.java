/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @since 2014-12-17T18:09:10
 * @author SPA
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.CountryEntity;
import com.mb.framework.entity.CurrencyEntity;

public interface CountryDAO {

	/**
	 * This method is used for Country data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public CountryEntity findCountryById(String id);
	
	/**
	 * This method is used to insert the CountryEntity .
	 * 
	 * @param countryEntity
	 * @return
	 */
	public void addCountry(CountryEntity countryEntity);

	/**
	 * This method is used to update the CountryEntity.
	 * 
	 * @param countryEntity
	 * @return CountryEntity
	 */
	public CountryEntity updateCountry(CountryEntity countryEntity);

	/**
	 * This method is used to delete the CountryEntity .
	 * 
	 * @param CountryEntity
	 * @return
	 */
	public void deleteCountry(CountryEntity countryEntity);
	
	/**
	 * 
	 * This method is used for findByAlpha2Cd
	 * @param textCurCode
	 * @return
	 */
	public CountryEntity findByAlpha2Cd(String alpha2Cd);

}
