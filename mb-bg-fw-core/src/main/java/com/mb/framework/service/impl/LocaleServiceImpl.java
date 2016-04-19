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
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.LocaleDAO;
import com.mb.framework.entity.LocaleEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.LocaleService;
import com.mb.framework.util.log.LogHelper;

@Service("localeService")
public class LocaleServiceImpl implements LocaleService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private LocaleDAO localeDAO;

	/**
	 * 
	 * This method is used for add LocaleEntity
	 * @param localeEntity
	 * @throws BusinessException
	 */
	@Override
	public void addLocale(LocaleEntity localeEntity)
			throws BusinessException {

		try {
			localeDAO.addLocale(localeEntity);
		} catch (Exception ex) {
			logger.error("Failed to add LocaleEntity", ex);
			throw new BusinessException(ErrorCodes.FM00007);
		}

	}

	/**
	 * 
	 * This method is used for update LocaleEntity
	 * @param localeEntity
	 * @return LocaleEntity
	 * @throws BusinessException
	 */
	@Override
	public LocaleEntity updateLocale(LocaleEntity localeEntity)
			throws BusinessException {

		LocaleEntity returnLocaleEntity = null;
		try {
			returnLocaleEntity = localeDAO.updateLocale(localeEntity);
		} catch (Exception ex) {
			logger.error("Failed to update LocaleEntity", ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnLocaleEntity;
	}

	/**
	 * 
	 * This method is used for delete LocaleEntity
	 * @param localeEntity
	 * @throws BusinessException
	 */
	@Override
	public void deleteLocale(LocaleEntity localeEntity)
			throws BusinessException {

		try {
			localeDAO.deleteLocale(localeEntity);
		} catch (Exception ex) {
			logger.error("Failed to  delete LocaleEntity", ex);
			throw new BusinessException(ErrorCodes.FM00009);
		}
	}

	/**
	 * 
	 * This method is used for find LocaleEntity by name
	 * @param name
	 * @return LocaleEntity
	 * @throws BusinessException
	 */
	@Override
	public LocaleEntity findByName(String name) throws BusinessException {
		LocaleEntity returnLocaleEntity = null;
		try {
			returnLocaleEntity = localeDAO.findByName(name);
		} catch (Exception ex) {
			logger.error("Failed to findByName = "+ name, ex);
			throw new BusinessException(ErrorCodes.FM00008);
		}
		return returnLocaleEntity;
	}

}
