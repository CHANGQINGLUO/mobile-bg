/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 9:26:02 am
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
@Table(name = "SYS_MESSAGE")
public class MessageEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1930967855479403410L;

	@Id
	@GeneratedValue(generator = "MESSAGE_UUID")
	@GenericGenerator(name = "MESSAGE_UUID", strategy = "uuid")
	@Column(name = "MESSAGE_UUID",length = 100)
	private String uuid;

	@Column(name = "MESSAGE_KEY", nullable = false, length = 13)
	private String messageKey;

	@Column(name = "MESSAGE_VALUE", length = 1024)
	private String messageValue;

	@Column(name = "CATEGORY_ENUM", length = 13)
	private String categoryEnum;

	@Column(name = "LANGUAGE", length = 10)
	private String language;

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
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * @param messageKey the messageKey to set
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * @return the messageValue
	 */
	public String getMessageValue() {
		return messageValue;
	}

	/**
	 * @param messageValue the messageValue to set
	 */
	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

	/**
	 * @return the categoryEnum
	 */
	public String getCategoryEnum() {
		return categoryEnum;
	}

	/**
	 * @param categoryEnum the categoryEnum to set
	 */
	public void setCategoryEnum(String categoryEnum) {
		this.categoryEnum = categoryEnum;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
