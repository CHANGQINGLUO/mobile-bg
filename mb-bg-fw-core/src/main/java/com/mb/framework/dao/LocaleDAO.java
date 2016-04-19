/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @since 2014-12-17T18:10:48
 * @author SPA
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.LocaleEntity;

public interface LocaleDAO {

	/**
	 * This method is used for Locale data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public LocaleEntity findLocaleById(String id);
	
	/**
	 * This method is used to insert the LocaleEntity .
	 * 
	 * @param localeEntity
	 * @return
	 */
	public void addLocale(LocaleEntity localeEntity);

	/**
	 * This method is used to update the LocaleEntity.
	 * 
	 * @param localeEntity
	 * @return LocaleEntity
	 */
	public LocaleEntity updateLocale(LocaleEntity localeEntity);

	/**
	 * This method is used to delete the LocaleEntity .
	 * 
	 * @param LocaleEntity
	 * @return
	 */
	public void deleteLocale(LocaleEntity localeEntity);

	/**
	 * @param name
	 * @return
	 */
	public LocaleEntity findByName(String name);
}
