/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 1:25:57 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.AuditEntity;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.service.spec.AuditDTO;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public interface AuditService
{

	/**
	 * This method is used to insert the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditDTO
	 * @return 
	 */
	public void addAudit(AuditDTO audit) throws BusinessException;
	
	/**
	 * 
	 * This method is used to add a AuditEntry in SYS_AUDIT_TABLE 
	 * @param AuditEntity
	 * @throws BusinessException
	 */
	public void insertAudit(AuditEntity auditEntity) throws BusinessException;;

	/**
	 * This method is used to update the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditEntity
	 * @return AuditEntity
	 */
	public AuditEntity updateAudit(AuditEntity auditEntity) throws BusinessException;;

	/**
	 * This method is used to delete the AuditEntity in SYS_AUDIT table.
	 * 
	 * @param AuditEntity
	 * @return 
	 */
	public void deleteAudit(AuditEntity auditEntity) throws BusinessException;;
	
	/**
	 * This method is used to get Audit Entity based on cutomerCin.
	 * 
	 * @param String
	 * @return AuditEntity
	 */
	public AuditEntity getByCustomerCin(String cutomerCin) throws BusinessException;;

	/**
	 * This method is used to get Audit Entity based on userUUID.
	 * 
	 * @param String
	 * @return AuditEntity
	 */
	public AuditEntity getByUserUUID(String userUUID) throws BusinessException;

	/**
	 * This method is used to add a audit record for every rest service calling.
	 * @param auditEntity
	 * @param componentType
	 * @param functionType 
	 */
	public void insertAudit(AuditEntity auditEntity, String componentType, String functionType) throws BusinessException;

}
