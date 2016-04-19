/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms.  *
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.AuditDAO;
import com.mb.framework.entity.AuditEntity;

@Repository("auditDAO")
public class AuditDAOImpl extends AbstractDAO<AuditEntity> implements AuditDAO {
	
	/**
	 * This method is constructor which sets AuditEntity class
	 */
	public AuditDAOImpl() {
		super();
		this.setEntityClass(AuditEntity.class);
	}

	/**
	 * This method is used to insert the Audit Entity in SYS_AUDIT table.
	 * @param AuditEntity
	 */
	public void addAudit(AuditEntity auditEntity) {
		save(auditEntity);
	}

	/**
	 * This method is used to update the AuditEntity in SYS_AUDIT table.
	 * @param AuditEntity
	 * @return AuditEntity
	 */
	public AuditEntity updateAudit(AuditEntity auditEntity) {
		return update(auditEntity);
	}

	/**
	 * This method is used to delete the AuditEntity from SYS_AUDIT table.
	 * @param AuditEntity
	 */
	public void deleteAudit(AuditEntity auditEntity) {
		delete(auditEntity);
	}

	/**
	 * This method is used to get the Audit Entity by Customer CIN from SYS_AUDIT table.
	 * @param cutomerCin
	 * @return AuditEntity
	 */
	public AuditEntity getByCustomerCin(String cutomerCin) {
		return em
				.createQuery(
						"select ae from AuditEntity ae where ae.custCin = :custCin and ae.isDeleted=:isDeleted",
						AuditEntity.class).setParameter("custCin", cutomerCin)
				.setParameter("isDeleted", false).getSingleResult();
	}

	/**
	 * This method is used to get the Audit Entity by User UUID from SYS_AUDIT table.
	 * @param userUUID
	 * @return AuditEntity
	 */
	public AuditEntity getByUserUUID(String userUUID) {
		return em
				.createQuery(
						"select ae from AuditEntity ae where ae.userUUID = :userUUID and ae.isDeleted=:isDeleted",
						AuditEntity.class).setParameter("userUUID", userUUID)
				.setParameter("isDeleted", false).getSingleResult();
	}

}
