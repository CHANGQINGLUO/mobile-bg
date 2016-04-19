/**
 * Copyright (C) 20"14 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 10 Jun, 2014 7:11:41 pm
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
@Table(name = "SYS_CHANNEL")
public class ChannelEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 5781728711206215827L;

	@Id @GeneratedValue(generator="CHANNEL_UUID")
	@GenericGenerator(name="CHANNEL_UUID", strategy = "uuid")
	@Column(name = "CHANNEL_UUID",length = 100)
	private String uuid;
	
	@Column(name = "CHANNEL_ID",nullable = false )
	private int channelId;
	
	@Column(name = "NAME_MESSAGE_KEY" , nullable = false, length = 13)
	private String nameMsgKey;

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
	 * @return the channelId
	 */
	public int getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the nameMsgKey
	 */
	public String getNameMsgKey() {
		return nameMsgKey;
	}

	/**
	 * @param nameMsgKey the nameMsgKey to set
	 */
	public void setNameMsgKey(String nameMsgKey) {
		this.nameMsgKey = nameMsgKey;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
