package com.mb.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the SYS_AUDIT_DETAIL database table.
 * 
 */
@Entity
@Table(name="SYS_AUDIT_DETAIL")
public class AuditDetailEntity extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3390320651109754638L;

	@Id @GeneratedValue(generator="AUDIT_DETAIL_UUID")
	@GenericGenerator(name="AUDIT_DETAIL_UUID", strategy = "uuid")
	@Column(name="AUDIT_DETAIL_UUID")
	private String auditDetailUuid;

	@Column(name="AUDIT_VALUE")
	private String auditValue;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name="RANK")
	private int rank;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUDIT_UUID")
	private AuditEntity audit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIELD_DEF_UUID")
	private AppFieldDefinitionEntity appFieldDefinition;
	
	public String getAuditDetailUuid() {
		return this.auditDetailUuid;
	}

	public void setAuditDetailUuid(String auditDetailUuid) {
		this.auditDetailUuid = auditDetailUuid;
	}

	public String getAuditValue() {
		return this.auditValue;
	}

	public void setAuditValue(String auditValue) {
		this.auditValue = auditValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the appFieldDefinition
	 */
	public AppFieldDefinitionEntity getAppFieldDefinition() {
		return appFieldDefinition;
	}

	/**
	 * @param appFieldDefinition the appFieldDefinition to set
	 */
	public void setAppFieldDefinition(AppFieldDefinitionEntity appFieldDefinition) {
		this.appFieldDefinition = appFieldDefinition;
	}

	/**
	 * @return the audit
	 */
	public AuditEntity getAudit() {
		return audit;
	}

	/**
	 * @param audit the audit to set
	 */
	public void setAudit(AuditEntity audit) {
		this.audit = audit;
	}

}