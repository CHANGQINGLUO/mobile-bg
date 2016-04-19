/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 9:37:41 am
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SYS_AUDIT")
public class AuditEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = -6611954125274022034L;
	
	@Id @GeneratedValue(generator="AUDIT_UUID")
	@GenericGenerator(name="AUDIT_UUID", strategy = "uuid")
	@Column(name = "AUDIT_UUID",length = 100)
	private String uuid;
	
	@Column(name = "AUDIT_TYPE_UUID",length = 100,nullable = false)
	private String auditTypeUUID;
	
	@Column(name = "USER_UUID",length = 100,nullable = false)
	private String userUUID;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="AUDIT_TYPE_UUID",nullable = false, insertable = false, updatable = false)
	private AuditTypeEntity auditType;
	
	@Column(name = "SESSION_ID",length = 100)
	private String sessionId;
	
	@Column(name = "CUST_CIN",length = 25)
	private String custCin;
	
	@Column(name = "CUST_NAME",length = 100)
	private String custName;
	
	@Column(name = "XMLAUDITDATA",length = 2000)
	private String data;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "audit")
	private List<AuditDetailEntity> auditDetails;


	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the auditTypeUUID
	 */
	public String getAuditTypeUUID() {
		return auditTypeUUID;
	}

	/**
	 * @param auditTypeUUID the auditTypeUUID to set
	 */
	public void setAuditTypeUUID(String auditTypeUUID) {
		this.auditTypeUUID = auditTypeUUID;
	}

	/**
	 * @return the userUUID
	 */
	public String getUserUUID() {
		return userUUID;
	}

	/**
	 * @param userUUID the userUUID to set
	 */
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	/**
	 * @return the auditType
	 */
	public AuditTypeEntity getAuditType() {
		return auditType;
	}

	/**
	 * @param auditType the auditType to set
	 */
	public void setAuditType(AuditTypeEntity auditType) {
		this.auditType = auditType;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the custCin
	 */
	public String getCustCin() {
		return custCin;
	}

	/**
	 * @param custCin the custCin to set
	 */
	public void setCustCin(String custCin) {
		this.custCin = custCin;
	}

	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the auditDetails
	 */
	public List<AuditDetailEntity> getAuditDetails() {
		return auditDetails;
	}

	/**
	 * @param auditDetails the auditDetails to set
	 */
	public void setAuditDetails(List<AuditDetailEntity> auditDetails) {
		this.auditDetails = auditDetails;
	}
	
	public AuditDetailEntity addAuditDetail(AuditDetailEntity auditDetail)
	{
		if (getAuditDetails() == null)
		{
			this.auditDetails = new ArrayList<AuditDetailEntity>();
		}

		getAuditDetails().add(auditDetail);
		auditDetail.setAudit(this);

		return auditDetail;
	}

	public AuditDetailEntity removeTopicDetail(AuditDetailEntity topicDetail)
	{
		getAuditDetails().remove(topicDetail);
		topicDetail.setAudit(null);

		return topicDetail;
	}
	
}
