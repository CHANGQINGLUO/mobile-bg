/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.AuditTypeEntity;

public interface AuditTypeDAO {
	/**
	 * This method is used to insert the AuditTypeEntity in SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 */
	public String addAuditType(AuditTypeEntity auditTypeEntity);

	/**
	 * This method is used to update the AuditTypeEntity in SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity updateAuditType(AuditTypeEntity auditTypeEntity);

	/**
	 * This method is used to delete the AuditTypeEntity from SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 */
	public void deleteAuditType(AuditTypeEntity auditTypeEntity);

	/**
	 * This method is used to get the AuditTypeEntity from SYS_AUDITTYPE table.
	 * @param componentkey
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity getByComponentKey(String componentKey);

	/**
	 * This method is used to get AuditTypeEntity by componentType and functionType 
	 * @param componentType
	 * @param functionType
	 * @return 
	 */
	public AuditTypeEntity getByCompAndFunc(String componentType, String functionType);

}
