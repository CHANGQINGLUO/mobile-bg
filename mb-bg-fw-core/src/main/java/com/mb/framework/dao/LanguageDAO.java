/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @since 2014-12-17T18:10:22
 * @author SPA
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.LanguageEntity;

public interface LanguageDAO {

	/**
	 * This method is used for Language data entity by id
	 * 
	 * @param id
	 * @return
	 */
	public LanguageEntity findLanguageById(String id);
	
	/**
	 * This method is used for Language data entity by name
	 * 
	 * @param id
	 * @return
	 */
	public LanguageEntity findLanguageByName(String name);
	
	/**
	 * This method is used to insert the LanguageEntity .
	 * 
	 * @param languageEntity
	 * @return
	 */
	public void addLanguage(LanguageEntity languageEntity);

	/**
	 * This method is used to update the LanguageEntity.
	 * 
	 * @param languageEntity
	 * @return LanguageEntity
	 */
	public LanguageEntity updateLanguage(LanguageEntity languageEntity);

	/**
	 * This method is used to delete the LanguageEntity .
	 * 
	 * @param LanguageEntity
	 * @return
	 */
	public void deleteLanguage(LanguageEntity languageEntity);

}
