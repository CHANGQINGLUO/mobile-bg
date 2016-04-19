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

import com.mb.framework.entity.AuditEntity;

public interface AuditDAO {
	
	/**
	 * This method is used to insert the Audit Entity in SYS_AUDIT table.
	 * @param AuditEntity
	 */
	public void addAudit(AuditEntity auditEntity);

	/**
	 * This method is used to update the Audit Entity in SYS_AUDIT table.
	 * @param AuditEntity
	 * @return AuditEntity
	 */
	public AuditEntity updateAudit(AuditEntity auditEntity);

	/**
	 * This method is used to delete the Audit Entity from SYS_AUDIT table.
	 * @param AuditEntity
	 */
	public void deleteAudit(AuditEntity auditEntity);

	/**
	 * This method is used to get the Audit Entity by Customer CIN from SYS_AUDIT table.
	 * @param cutomerCin
	 * @return AuditEntity
	 */
	public AuditEntity getByCustomerCin(String cutomerCin);

	/**
	 * This method is used to get the Audit Entity by User UUID from SYS_AUDIT table.
	 * @param userUUID
	 * @return AuditEntity
	 */
	public AuditEntity getByUserUUID(String userUUID);

}
