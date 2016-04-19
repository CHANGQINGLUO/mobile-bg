/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 9:38:22 am
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
@Table(name = "SYS_AUDIT_TYPE")
public class AuditTypeEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = -5310254565344705223L;

	@Id @GeneratedValue(generator="AUDIT_TYPE_UUID")
	@GenericGenerator(name="AUDIT_TYPE_UUID", strategy = "uuid")
	@Column(name = "AUDIT_TYPE_UUID",length = 100)
	private String uuid;
	
	@Column(name = "CHANNEL_UUID",length = 100)
	private String channelUUID;
	
	@Column(name = "COMPONENT_KEY", length = 13)
	private String componentKey;
	
	@Column(name = "FUNCTION_KEY", length = 13)
	private String functionKey;

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
	 * @return the channelUUID
	 */
	public String getChannelUUID() {
		return channelUUID;
	}

	/**
	 * @param channelUUID the channelUUID to set
	 */
	public void setChannelUUID(String channelUUID) {
		this.channelUUID = channelUUID;
	}

	/**
	 * @return the componentKey
	 */
	public String getComponentKey() {
		return componentKey;
	}

	/**
	 * @param componentKey the componentKey to set
	 */
	public void setComponentKey(String componentKey) {
		this.componentKey = componentKey;
	}

	/**
	 * @return the functionKey
	 */
	public String getFunctionKey() {
		return functionKey;
	}

	/**
	 * @param functionKey the functionKey to set
	 */
	public void setFunctionKey(String functionKey) {
		this.functionKey = functionKey;
	}


	

}
