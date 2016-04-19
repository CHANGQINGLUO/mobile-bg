package com.mb.framework.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the SYS_COUNTRY_CODE database table.
 * 
 */
@Entity
@Table(name="SYS_COUNTRY_CODE")
public class CountryEntity extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -26349276088031221L;

	@Id @GeneratedValue(generator="COUNTRY_CODE_UUID")
	@GenericGenerator(name="COUNTRY_CODE_UUID", strategy = "uuid")
	@Column(name="COUNTRY_CODE_UUID")
	private String countryCodeUuid;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="IS_ACTIVED")
	private boolean isActived;

	@Column(name="ISO_ALPHA_2CD")
	private String isoAlpha2cd;

	@Column(name="ISO_ALPHA_3CD")
	private String isoAlpha3cd;

	@Column(name="ISO_NUMERIC_CODE")
	private BigDecimal isoNumericCode;

	@Column(name="LONG_NAME_MSG_KEY")
	private String longNameMsgKey;

	@Column(name="SHORT_NAME_MSG_KEY")
	private String shortNameMsgKey;

	public CountryEntity() {
	}

	public String getCountryCodeUuid() {
		return this.countryCodeUuid;
	}

	public void setCountryCodeUuid(String countryCodeUuid) {
		this.countryCodeUuid = countryCodeUuid;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsActived() {
		return this.isActived;
	}

	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}

	public String getIsoAlpha2cd() {
		return this.isoAlpha2cd;
	}

	public void setIsoAlpha2cd(String isoAlpha2cd) {
		this.isoAlpha2cd = isoAlpha2cd;
	}

	public String getIsoAlpha3cd() {
		return this.isoAlpha3cd;
	}

	public void setIsoAlpha3cd(String isoAlpha3cd) {
		this.isoAlpha3cd = isoAlpha3cd;
	}

	public BigDecimal getIsoNumericCode() {
		return this.isoNumericCode;
	}

	public void setIsoNumericCode(BigDecimal isoNumericCode) {
		this.isoNumericCode = isoNumericCode;
	}

	public String getLongNameMsgKey() {
		return this.longNameMsgKey;
	}

	public void setLongNameMsgKey(String longNameMsgKey) {
		this.longNameMsgKey = longNameMsgKey;
	}

	public String getShortNameMsgKey() {
		return this.shortNameMsgKey;
	}

	public void setShortNameMsgKey(String shortNameMsgKey) {
		this.shortNameMsgKey = shortNameMsgKey;
	}

}