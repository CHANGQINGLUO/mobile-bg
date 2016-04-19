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
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.LanguageDAO;
import com.mb.framework.entity.LanguageEntity;
import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.LanguageService;
import com.mb.framework.util.log.LogHelper;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * 
	 * This method is used for add LanguageEntity
	 * @param languageEntity
	 * @throws BusinessException
	 */
	@Override
	public void addLanguage(LanguageEntity languageEntity)
			throws BusinessException {

		try {
			languageDAO.addLanguage(languageEntity);
		} catch (Exception ex) {
			logger.error("Failed to add LanguageEntity", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}

	}

	/**
	 * 
	 * This method is used for update LanguageEntity
	 * @param languageEntity
	 * @return LanguageEntity
	 * @throws BusinessException
	 */
	@Override
	public LanguageEntity updateLanguage(LanguageEntity languageEntity)
			throws BusinessException {

		LanguageEntity returnLanguageEntity = null;
		try {
			returnLanguageEntity = languageDAO.updateLanguage(languageEntity);
		} catch (Exception ex) {
			logger.error("Failed to update LanguageEntity", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnLanguageEntity;
	}

	/**
	 * 
	 * This method is used for delete LanguageEntity
	 * @param languageEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteLanguage(LanguageEntity languageEntity)
			throws BusinessException {

		try {
			languageDAO.deleteLanguage(languageEntity);
		} catch (Exception ex) {
			logger.error("Failed to  delete LanguageEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}
	/**
	 * 
	 * This method is used to query language entity
	 * @param languageEntity
	 * @throws BusinessException
	 */
	@Override
	public LanguageEntity findByName(String alpha_2cd) throws BusinessException {
		LanguageEntity entity;
		try {
			entity = languageDAO.findLanguageByName(alpha_2cd);
		} catch (Exception ex) {
			logger.error("Failed to  find LanguageEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
		return entity;
	}
	
	

}
