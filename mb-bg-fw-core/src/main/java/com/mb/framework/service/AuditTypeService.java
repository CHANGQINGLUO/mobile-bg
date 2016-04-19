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

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface AuditTypeService
{

	/**
	 * This method is used to insert the AuditTypeEntity
	 * 
	 * @param AuditTypeEntity
	 * @return String
	 */
	public String addAuditType(AuditTypeEntity auditTypeEntity) throws BusinessException;;
	

	/**
	 * This method is used to update the AuditTypeEntity
	 * 
	 * @param AuditTypeEntity
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity updateAuditType(AuditTypeEntity auditTypeEntity) throws BusinessException;

	/**
	 * This method is used to delete the AuditTypeEntity
	 * 
	 * @param AuditTypeEntity
	 * @return 
	 */
	public void deleteAuditType(AuditTypeEntity auditTypeEntity) throws BusinessException;


	/**
	 * This method is used to get Audit Entity by component Key
	 * 
	 * @param String
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity getByComponentKey(String componentKey) throws BusinessException;


	/**
	 * This method is used to get Audit Entity by componentType and functionType
	 * @param componentType
	 * @param functionType
	 * @return 
	 * @throws BusinessException 
	 */
	public AuditTypeEntity getByCompAndFunc(String componentType, String functionType) throws BusinessException;

}
