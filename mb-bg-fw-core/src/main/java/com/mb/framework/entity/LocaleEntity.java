package com.mb.framework.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the SYS_LOCALE_CODE database table.
 * 
 */
@Entity
@Table(name="SYS_LOCALE_CODE")
public class LocaleEntity extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2365803278912193047L;

	@Id @GeneratedValue(generator="LOCALE_CODE_UUID")
	@GenericGenerator(name="LOCALE_CODE_UUID", strategy = "uuid")
	@Column(name="LOCALE_CODE_UUID")
	private String localeCodeUuid;

	@Column(name="COUNTRY_CODE_UUID")
	private String countryCodeUuid;

	@Column(name="DISPLAY_SEQUENCE")
	private BigDecimal displaySequence;

	@Column(name="IMAGE_FILE_NAME")
	private String imageFileName;

	@Column(name="IS_DEFAULT")
	private boolean isDefault;

	@Column(name="LANGUAGE_CODE_UUID")
	private String languageCodeUuid;

	@Column(name="NAME")
	private String name;

	public LocaleEntity() {
	}

	public String getLocaleCodeUuid() {
		return this.localeCodeUuid;
	}

	public void setLocaleCodeUuid(String localeCodeUuid) {
		this.localeCodeUuid = localeCodeUuid;
	}

	public String getCountryCodeUuid() {
		return this.countryCodeUuid;
	}

	public void setCountryCodeUuid(String countryCodeUuid) {
		this.countryCodeUuid = countryCodeUuid;
	}


	public BigDecimal getDisplaySequence() {
		return this.displaySequence;
	}

	public void setDisplaySequence(BigDecimal displaySequence) {
		this.displaySequence = displaySequence;
	}

	public String getImageFileName() {
		return this.imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getLanguageCodeUuid() {
		return this.languageCodeUuid;
	}

	public void setLanguageCodeUuid(String languageCodeUuid) {
		this.languageCodeUuid = languageCodeUuid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isDefault
	 */
	public final boolean isDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public final void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

}