package com.mb.ext.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the MESSAGE database table.
 * 
 */
@Entity
@Table(name = "MESSAGE")
@NamedQuery(name = "IMessageEntity.findAll", query = "SELECT u FROM IMessageEntity u")
public class IMessageEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	public String getMessageUuid() {
		return messageUuid;
	}


	public void setMessageUuid(String messageUuid) {
		this.messageUuid = messageUuid;
	}


	@Id
	@GeneratedValue(generator = "MESSAGE_UUID")
	@GenericGenerator(name = "MESSAGE_UUID", strategy = "uuid")
	@Column(name = "MESSAGE_UUID", nullable = false, length = 100)
	private String messageUuid;


	@Column(name = "CONTENT", length = 1000)
	private String content;


	@Column(name = "STATUS" , length = 1)
	private String status;



	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


}