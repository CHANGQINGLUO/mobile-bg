/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 2014-12-17T18:10:49
 * @author SPA
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface LocaleService{

	/**
	 * This method is used to insert the LocaleEntity
	 * 
	 * @param LocaleEntity
	 * @return 
	 */
	public void addLocale(LocaleEntity localeEntity) throws BusinessException;
	
	/**
	 * This method is used to update the LocaleEntity
	 * 
	 * @param LocaleEntity
	 * @return LocaleEntity
	 */
	public LocaleEntity updateLocale(LocaleEntity localeEntity) throws BusinessException;
	
	/**
	 * This method is used to delete the ChannelEntity
	 * 
	 * @param ChannelEntity
	 * @return 
	 */
	public void deleteLocale(LocaleEntity localeEntity) throws BusinessException;
	
	/**
	 * @param name
	 * @return
	 * @throws BusinessException
	 */
	public LocaleEntity findByName(String name) throws BusinessException;
}
