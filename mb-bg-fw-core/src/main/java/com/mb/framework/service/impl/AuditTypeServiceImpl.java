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

import com.mb.framework.dao.AuditTypeDAO;
import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.AuditTypeService;
import com.mb.framework.util.log.LogHelper;

@Service("auditTypeService")
public class AuditTypeServiceImpl implements AuditTypeService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public AuditTypeDAO auditTypeDAO;

	/**
	 * 
	 * This method is used for add AuditTypeEntity
	 * @param auditTypeEntity
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public String addAuditType(AuditTypeEntity auditTypeEntity)
			throws BusinessException {
		String auditTypeUuid = "";

		logger.debug("AuditTypeServiceImpl - add  for the channel UUID is "
				+ auditTypeEntity.getChannelUUID() + " and Component Key - "
				+ auditTypeEntity.getComponentKey());
		try {
			auditTypeUuid = auditTypeDAO.addAuditType(auditTypeEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit Tyep add", ex);
			throw new BusinessException(ErrorCodes.FM00004);
		}
		return auditTypeUuid;
	}

	/**
	 * 
	 * This method is used for update AuditTypeEntity
	 * @param auditTypeEntity
	 * @return AuditTypeEntity
	 * @throws BusinessException
	 */
	@Override
	public AuditTypeEntity updateAuditType(AuditTypeEntity auditTypeEntity)
			throws BusinessException {

		logger.debug("AuditTypeServiceImpl - update  for the channel UUID is "
				+ auditTypeEntity.getChannelUUID() + " and Component Key - "
				+ auditTypeEntity.getComponentKey());
		AuditTypeEntity returnAuditTypeEntity = null;
		try {
			returnAuditTypeEntity = auditTypeDAO
					.updateAuditType(auditTypeEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit update", ex);
			throw new BusinessException(ErrorCodes.FM00005);
		}
		return returnAuditTypeEntity;
	}

	/**
	 * 
	 * This method is used for delete AuditTypeEntity
	 * @param auditTypeEntity
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public void deleteAuditType(AuditTypeEntity auditTypeEntity)
			throws BusinessException {

		logger.debug("AuditTypeServiceImpl - delete  for the channel UUID is "
				+ auditTypeEntity.getChannelUUID() + " and Component Key - "
				+ auditTypeEntity.getComponentKey());
		try {
			auditTypeDAO.deleteAuditType(auditTypeEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit delete", ex);
			throw new BusinessException(ErrorCodes.FM00006);
		}
	}

	/**
	 * 
	 * This method is used for get AuditTypeEntity by componentKey
	 * @param componentKey
	 * @return AuditTypeEntity
	 * @throws BusinessException
	 */
	public AuditTypeEntity getByComponentKey(String componentKey)
			throws BusinessException {
		logger.debug("AuditTypeServiceImpl - get  for the Component Key is "
				+ componentKey);
		try {
			return auditTypeDAO.getByComponentKey(componentKey);
		} catch (Exception ex) {
			logger.error("Failed to  get Component key ", ex);
			throw new BusinessException(ErrorCodes.FM00023);
		}
	}

	/**
	 * This method is used to get AuditTypeEntity by componentType and functionType 
	 * @param componentType
	 * @param functionType
	 * @return
	 * @throws BusinessException 
	 */
	@Override
	public AuditTypeEntity getByCompAndFunc(String componentType, String functionType) throws BusinessException {
		logger.debug("AuditTypeServiceImpl - get AuditTypeEntity for componentType: "
				+ componentType +", functionType: "+functionType);
		try {
			return auditTypeDAO.getByCompAndFunc(componentType, functionType);
		} catch (Exception ex) {
			logger.error("Failed to get AuditTypeEntity by componentType and functionType", ex);
			throw new BusinessException(ErrorCodes.FM00023);
		}
	}

}
