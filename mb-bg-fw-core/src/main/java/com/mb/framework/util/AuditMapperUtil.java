/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 19 Jun, 2014 2:44:45 pm
 * @author SPA
 * @mb-bg-fw-core
 *
 */
/**
 * 
 */
package com.mb.framework.util;

import org.springframework.stereotype.Component;

import com.mb.framework.entity.AuditEntity;
import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.service.spec.AuditDTO;
import com.mb.framework.service.spec.AuditTypeDTO;

/**
 * @author SPA
 * 
 */
@Component
public class AuditMapperUtil
{
	/**
	 * This method is used for clone auditDTO to auditEntity
	 * @param auditDTO
	 * @return
	 */
	public AuditEntity copyAuditDTOtoEntity(AuditDTO auditDTO)
	{
		AuditEntity audit = new AuditEntity();
		audit.setCustName(auditDTO.getCustName());
		audit.setUserUUID(auditDTO.getUserUUID());
		audit.setCreateDate(auditDTO.getCreateDate());
		if (null != auditDTO.getAuditType())
		{
			audit.setAuditType(copyAuditTypeDTOtoEntity(auditDTO.getAuditType()));
		}
		return audit;
	}

	/**
	 * This method is used for clone auditTypeDTO to auditTypeEntity
	 * @param auditTypeDTO
	 * @return
	 */
	public AuditTypeEntity copyAuditTypeDTOtoEntity(AuditTypeDTO auditTypeDTO)
	{
		AuditTypeEntity auditType = new AuditTypeEntity();
		auditType.setComponentKey(auditTypeDTO.getComponentKey());
		auditType.setFunctionKey(auditTypeDTO.getFunctionKey());
		auditType.setCreateDate(auditTypeDTO.getCreateDate());
		return auditType;
	}

}
