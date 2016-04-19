/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.framework.dao.EnumDAO;
import com.mb.framework.entity.EnumEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.EnumService;
import com.mb.framework.util.log.LogHelper;

@Service("enumService")
public class EnumServiceImpl implements EnumService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public EnumDAO enumDAO;

	/**
	 * 
	 * This method is used for insert EnumEntity
	 * @param enumEntity
	 * @throws BusinessException
	 */
	@Override
	public void addEnum(EnumEntity enumEntity) throws BusinessException {

		logger.debug("EnumServiceImpl add for the message key is "
				+ enumEntity.getMessageKey());
		try {
			enumDAO.addEnum(enumEntity);
		} catch (Exception ex) {
			logger.error("Failed to add Enum", ex);
			throw new BusinessException(ErrorCodes.FM00010);
		}
	}

	/**
	 * 
	 * This method is used for update EnumEntity
	 * @param enumEntity
	 * @return EnumEntity
	 * @throws BusinessException
	 */
	@Override
	public EnumEntity updateEnum(EnumEntity enumEntity)
			throws BusinessException {

		logger.debug("EnumServiceImpl update for the message key is "
				+ enumEntity.getMessageKey());
		EnumEntity returnEnumEntity = null;
		try {
			returnEnumEntity = enumDAO.updateEnum(enumEntity);
		} catch (Exception ex) {
			logger.error("Failed to update Enum", ex);
			throw new BusinessException(ErrorCodes.FM00011);
		}
		return returnEnumEntity;
	}
	
	/**
	 * 
	 * This method is used for delete EnumEntity
	 * @param enumEntity
	 * @throws BusinessException
	 */

	@Override
	public void deleteEnum(EnumEntity enumEntity) throws BusinessException {

		logger.debug("EnumServiceImpl delete for the message key is "
				+ enumEntity.getMessageKey());
		try {
			enumDAO.deleteEnum(enumEntity);
		} catch (Exception ex) {
			logger.error("Failed to delete Enum", ex);
			throw new BusinessException(ErrorCodes.FM00012);
		}
	}

	/**
	 * 
	 * This method is used for get EnumEntity by Messagekey
	 * @param messageKey
	 * @return EnumEntity
	 * @throws BusinessException
	 */
	@Override
	public EnumEntity getByMessagekey(String messageKey)
			throws BusinessException {

		logger.debug("EnumServiceImpl get for the message key is " + messageKey);
		try {
			return enumDAO.getByMessagekey(messageKey);
		} catch (Exception ex) {
			logger.error("Failed to get Enum entity", ex);
			throw new BusinessException(ErrorCodes.FM00021);
		}
	}

}
