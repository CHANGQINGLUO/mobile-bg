/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2014-12-17T18:10:22
 * @author SPA
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.LanguageEntity;
import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface LanguageService{

	/**
	 * This method is used to insert the LanguageEntity
	 * 
	 * @param LanguageEntity
	 * @return 
	 */
	public void addLanguage(LanguageEntity languageEntity) throws BusinessException;
	
	/**
	 * This method is used to update the LanguageEntity
	 * 
	 * @param LanguageEntity
	 * @return LanguageEntity
	 */
	public LanguageEntity updateLanguage(LanguageEntity languageEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteLanguage(LanguageEntity languageEntity) throws BusinessException;
	
	/**
	 * @param alpha_2cd
	 * @return
	 * @throws BusinessException
	 */
	public LanguageEntity findByName(String alpha_2cd) throws BusinessException;
	
}
