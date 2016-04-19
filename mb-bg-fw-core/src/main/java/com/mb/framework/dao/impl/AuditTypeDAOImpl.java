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

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.AuditTypeDAO;
import com.mb.framework.entity.AuditTypeEntity;
import com.mb.framework.util.log.LogHelper;

@Repository("auditTypeDAO")
public class AuditTypeDAOImpl extends AbstractDAO<AuditTypeEntity> implements
		AuditTypeDAO {
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	/**
	 * constructor for AuditTypeDAOImpl
	 */
	public AuditTypeDAOImpl() {
		super();
		this.setEntityClass(AuditTypeEntity.class);
	}

	/**
	 * This method is used to insert the AuditTypeEntity in SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 */
	public String addAuditType(AuditTypeEntity auditTypeEntity) {
		save(auditTypeEntity);
		return auditTypeEntity.getUuid();
	}

	/**
	 * This method is used to update the AuditTypeEntity in SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity updateAuditType(AuditTypeEntity auditTypeEntity) {
		return update(auditTypeEntity);
	}

	/**
	 * This method is used to delete the AuditTypeEntity from SYS_AUDITTYPE table.
	 * @param AuditTypeEntity
	 */
	public void deleteAuditType(AuditTypeEntity auditTypeEntity) {
		delete(auditTypeEntity);
	}

	/**
	 * This method is used to get AuditTypeEntity from SYS_AUDITTYPE table.
	 * @param componentKey
	 * @return AuditTypeEntity
	 */
	public AuditTypeEntity getByComponentKey(String componentKey) {
		return em
				.createQuery(
						"select ate from AuditTypeEntity ate where ate.componentKey = :componentKey and ate.isDeleted=:isDeleted",
						AuditTypeEntity.class)
				.setParameter("componentKey", componentKey)
				.setParameter("isDeleted", false).getSingleResult();
	}

	/**
	 * This method is used to get AuditTypeEntity by componentType and functionType  
	 * @param componentType
	 * @param functionType
	 * @return
	 */
	@Override
	public AuditTypeEntity getByCompAndFunc(String componentType, String functionType) {
		AuditTypeEntity auditType = null;
		try {
			auditType = em.createQuery("select ate from AuditTypeEntity ate where ate.componentKey = :componentKey and ate.functionKey=:functionKey and ate.isDeleted=:isDeleted",
					AuditTypeEntity.class).setParameter("componentKey", componentType).setParameter("functionKey", functionType).setParameter("isDeleted", false).getSingleResult();
		} catch (NoResultException e)
		{
			logger.info("No record found to get AuditTypeEntity by componentType and functionType ");
		}
		return auditType;
	}
}
