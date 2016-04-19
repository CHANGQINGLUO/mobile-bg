/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 10 Jun, 2014 7:26:48 pm
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SYS_PARAM")
public class ParamEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1536060692815110932L;
	
	@Id @GeneratedValue(generator="PARAM_UUID")
	@GenericGenerator(name="PARAM_UUID", strategy = "uuid")
	@Column(name = "PARAM_UUID",length = 100)
	private String uuid;
	
	@Column(name = "PARAM_TYPE",length = 10)
	private String paramType;
	
	@Column(name = "PARAM_CODE",length = 100)
	private String paramCode; 
	
	@Column(name = "PARAM_VALUE",length = 100)
	private String paramValue;
	
	@Column(name = "BUNDLE_ID",length = 10)
	private String bundleId;

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
	 * @return the paramType
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * @param paramType the paramType to set
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * @return the paramCode
	 */
	public String getParamCode() {
		return paramCode;
	}

	/**
	 * @param paramCode the paramCode to set
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	/**
	 * @return the paramValue
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * @param paramValue the paramValue to set
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * @return the bundleId
	 */
	public String getBundleId() {
		return bundleId;
	}

	/**
	 * @param bundleId the bundleId to set
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}
	

}
