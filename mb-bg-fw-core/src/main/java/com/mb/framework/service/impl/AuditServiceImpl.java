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

import com.mb.framework.dao.AuditDAO;
import com.mb.framework.dao.AuditTypeDAO;
import com.mb.framework.entity.AppFieldDefinitionEntity;
import com.mb.framework.entity.AuditDetailEntity;
import com.mb.framework.entity.AuditEntity;
import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.message.ErrorCodes;
import com.mb.framework.service.AppFieldDefinitionService;
import com.mb.framework.service.AuditService;
import com.mb.framework.service.AuditTypeService;
import com.mb.framework.service.spec.AuditDTO;
import com.mb.framework.util.AuditMapperUtil;
import com.mb.framework.util.ObjectXMLConversionUtil;
import com.mb.framework.util.log.LogHelper;

@Service("auditService")
public class AuditServiceImpl implements AuditService {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	public AuditDAO auditDAO;

	@Autowired
	public AuditTypeDAO auditTypeDAO;

	@Autowired
	public ObjectXMLConversionUtil objectXMLConversionUtil;

	@Autowired
	public AuditMapperUtil auditMapperUtil;
	
	@Autowired
	private AuditTypeService auditTypeService;
	
	@Autowired
	private AppFieldDefinitionService appFieldDefinitionService;

	/**
	 * This method is used to insert the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditDTO
	 * @return 
	 */
	@Override
	public void addAudit(AuditDTO audit) throws BusinessException {

		logger.debug("AuditServiceImpl - add for the audit Customer CIN is "
				+ audit.getCustName());
		try {

			AuditEntity auditEntity = auditMapperUtil
					.copyAuditDTOtoEntity(audit);
			AuditTypeEntity auditType = auditEntity.getAuditType();
			// insert the auditType
			if (null != auditType && null != auditType.getComponentKey()) {

				auditTypeDAO.addAuditType(auditType);
				auditEntity.setAuditTypeUUID(auditType.getUuid());
			}

			String data = objectXMLConversionUtil.convertObjectToXML(audit
					.getData());
			// set the data
			auditEntity.setData(data);
			auditDAO.addAudit(auditEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit add", ex);
			throw new BusinessException(ErrorCodes.FM00001);
		}
	}

	/**
	 * This method is used to update the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditEntity
	 * @return AuditEntity
	 */
	@Override
	public AuditEntity updateAudit(AuditEntity auditEntity)
			throws BusinessException {

		logger.debug("AuditServiceImpl - update for the audit Customer CIN is "
				+ auditEntity.getCustCin());
		AuditEntity returnAuditEntity = null;
		try {
			returnAuditEntity = auditDAO.updateAudit(auditEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit update", ex);
			throw new BusinessException(ErrorCodes.FM00002);
		}
		return returnAuditEntity;
	}

	/**
	 * This method is used to delete the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditEntity
	 * @return 
	 */
	@Override
	public void deleteAudit(AuditEntity auditEntity) throws BusinessException {

		logger.debug("AuditServiceImpl - delete for the audit Customer CIN is "
				+ auditEntity.getCustCin());
		try {
			auditDAO.deleteAudit(auditEntity);
		} catch (Exception ex) {
			logger.error("Failed to  Audit delete", ex);
			throw new BusinessException(ErrorCodes.FM00003);
		}
	}

	/**
	 * This method is used to get Audit Entity based on cutomerCin.
	 * 
	 * @param String
	 * @return AuditEntity
	 */
	@Override
	public AuditEntity getByCustomerCin(String cutomerCin)
			throws BusinessException {

		logger.debug("AuditServiceImpl - get  for the cutomer Cin is "
				+ cutomerCin);
		try {
			return auditDAO.getByCustomerCin(cutomerCin);
		} catch (Exception ex) {
			logger.error("Failed to  get cutomer Cin ", ex);
			throw new BusinessException(ErrorCodes.FM00024);
		}
	}

	/**
	 * This method is used to get Audit Entity based on userUUID.
	 * 
	 * @param String
	 * @return AuditEntity
	 */
	@Override
	public AuditEntity getByUserUUID(String userUUID) throws BusinessException {

		logger.debug("AuditServiceImpl - get  for the User UUID is " + userUUID);
		try {
			return auditDAO.getByUserUUID(userUUID);
		} catch (Exception ex) {
			logger.error("Failed to  get the User UUID is ", ex);
			throw new BusinessException(ErrorCodes.FM00025);
		}
	}

	/**
	 * This method is used to add a AuditEntry in SYS_AUDIT_TABLE 
	 * @param auditEntity
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public void insertAudit(AuditEntity auditEntity) throws BusinessException {
		logger.debug("Insert Audit");

		try {
			auditDAO.addAudit(auditEntity);
		} catch (Exception e) {
			logger.error("Failed to  Audit add", e);
			throw new BusinessException(ErrorCodes.FM00001);
		}
	}

	/**
	 * This method is used to add a audit record for every rest service calling. 
	 * @param auditEntity
	 * @param componentType
	 * @param functionType
	 * @throws BusinessException 
	 */
	@Override
	public void insertAudit(AuditEntity auditEntity, String componentType, String functionType) throws BusinessException {
		logger.debug("Insert Audit");
		auditEntity.setAuditTypeUUID(getAuditTypeUUid(componentType, functionType));
		if (auditEntity.getAuditDetails() != null && auditEntity.getAuditDetails().size() > 0){
			for (int i = 0; i < auditEntity.getAuditDetails().size(); i++){
				AuditDetailEntity auditDetail = auditEntity.getAuditDetails().get(i);
				AppFieldDefinitionEntity field = auditDetail.getAppFieldDefinition();
				if (field != null){
					field = appFieldDefinitionService.getAppFieldDefinitionByName(field.getFieldType(), field.getFieldName());
					auditDetail.setAppFieldDefinition(field);
				}
			}
		}
		
		try {
			auditDAO.addAudit(auditEntity);
		} catch (Exception e) {
			logger.error("Failed to  Audit add", e);
			throw new BusinessException(ErrorCodes.FM00001);
		}
		
	}

	/**
	 * This method is used for 
	 * @param componentType
	 * @param functionType
	 * @return 
	 * @throws BusinessException 
	 */
	private String getAuditTypeUUid(String componentType, String functionType) throws BusinessException {
		String auditTypeUuid = "";
		AuditTypeEntity auditTypeEntity = auditTypeService.getByCompAndFunc(componentType, functionType);
		if (auditTypeEntity == null)
		{
			auditTypeEntity = new AuditTypeEntity();
			auditTypeEntity.setComponentKey(componentType);
			auditTypeEntity.setFunctionKey(functionType);
			auditTypeUuid = auditTypeService.addAuditType(auditTypeEntity);
		}
		else
		{
			auditTypeUuid = auditTypeEntity.getUuid();
		}

		return auditTypeUuid;
	}

}
