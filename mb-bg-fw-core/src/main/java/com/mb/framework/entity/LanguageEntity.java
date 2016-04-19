package com.mb.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the SYS_LANGUAGE_CODE database table.
 * 
 */
@Entity
@Table(name="SYS_LANGUAGE_CODE")
public class LanguageEntity extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4275581979342430260L;

	@Id @GeneratedValue(generator="LANGUAGE_CODE_UUID")
	@GenericGenerator(name="LANGUAGE_CODE_UUID", strategy = "uuid")
	@Column(name="LANGUAGE_CODE_UUID")
	private String languageCodeUuid;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="ISO_ALPHA_2CD")
	private String isoAlpha2cd;

	@Column(name="ISO_ALPHA_3BCD")
	private String isoAlpha3bcd;

	@Column(name="ISO_ALPHA_3TCD")
	private String isoAlpha3tcd;

	@Column(name="NAME_MSG_KEY")
	private String nameMsgKey;

	public LanguageEntity() {
	}

	public String getLanguageCodeUuid() {
		return this.languageCodeUuid;
	}

	public void setLanguageCodeUuid(String languageCodeUuid) {
		this.languageCodeUuid = languageCodeUuid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsoAlpha2cd() {
		return this.isoAlpha2cd;
	}

	public void setIsoAlpha2cd(String isoAlpha2cd) {
		this.isoAlpha2cd = isoAlpha2cd;
	}

	public String getIsoAlpha3bcd() {
		return this.isoAlpha3bcd;
	}

	public void setIsoAlpha3bcd(String isoAlpha3bcd) {
		this.isoAlpha3bcd = isoAlpha3bcd;
	}

	public String getIsoAlpha3tcd() {
		return this.isoAlpha3tcd;
	}

	public void setIsoAlpha3tcd(String isoAlpha3tcd) {
		this.isoAlpha3tcd = isoAlpha3tcd;
	}

	public String getNameMsgKey() {
		return this.nameMsgKey;
	}

	public void setNameMsgKey(String nameMsgKey) {
		this.nameMsgKey = nameMsgKey;
	}

}