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

import com.mb.framework.dao.ParamDAO;
import com.mb.framework.entity.ParamEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.ParamService;
import com.mb.framework.util.log.LogHelper;

@Service("paramService")
public class ParamServiceImpl implements ParamService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public ParamDAO paramDAO;

	/**
	 * 
	 * This method is used for insert ParamEntity
	 * @param param
	 * @throws BusinessException
	 */
	@Override
	public void addParam(ParamEntity param) throws BusinessException {
		logger.debug("ParamServiceImpl - add for the param type is "
				+ param.getParamType() + ", param code -"
				+ param.getParamCode());
		try {
			paramDAO.addParam(param);
		} catch (Exception ex) {
			logger.error("Failed to add PARAM", ex);
			throw new BusinessException(ErrorCodes.FM00016);
		}

	}

	/**
	 * 
	 * This method is used for update ParamEntity
	 * @param param
	 * @return ParamEntity
	 * @throws BusinessException
	 */
	@Override
	public ParamEntity updateParam(ParamEntity param) throws BusinessException {
		logger.debug("ParamServiceImpl - update for the param type is "
				+ param.getParamType() + ", param code -"
				+ param.getParamCode());
		ParamEntity paramEntity = null;
		try {
			paramEntity = paramDAO.updateParam(param);
		} catch (Exception ex) {
			logger.error("Failed to update Param", ex);
			throw new BusinessException(ErrorCodes.FM00017);
		}

		return paramEntity;
	}

	/**
	 * 
	 * This method is used for delete ParamEntity
	 * @param param
	 * @throws BusinessException
	 */
	@Override
	public void deleteParam(ParamEntity param) throws BusinessException {
		logger.debug("ParamServiceImpl - delete for the param type is "
				+ param.getParamType() + ", param code - "
				+ param.getParamCode());
		try {
			paramDAO.deleteParam(param);
		} catch (Exception ex) {
			logger.error("Failed to delete Param", ex);
			throw new BusinessException(ErrorCodes.FM00018);
		}
	}

	/**
	 * 
	 * This method is used for get ParamEntity by Param code and type
	 * @param paramCode
	 * @param paramType
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public ParamEntity getByParamCodeAndType(String paramCode, String paramType)
			throws BusinessException {
		logger.debug("ParamServiceImpl- get for the param type is " + paramType
				+ ", param code - " + paramCode);
		try {
			return paramDAO.getByParamCodeAndType(paramCode, paramType);
		} catch (Exception ex) {
			logger.error("Failed to get id is " + paramCode, ex);
			throw new BusinessException(ErrorCodes.FM00019);
		}
	}

}
