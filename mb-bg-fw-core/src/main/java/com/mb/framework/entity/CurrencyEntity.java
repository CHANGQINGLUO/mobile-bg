package com.mb.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the CURRENCY database table.
 * 
 */
@Entity
@Table(name="SYS_CURRENCY")
public class CurrencyEntity extends AbstractBaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8901794615805681337L;

	@Id
	@GeneratedValue(generator = "CURRENCY_UUID")
	@GenericGenerator(name = "CURRENCY_UUID", strategy = "uuid")
	@Column(name="CURRENCY_UUID")
	private String currencyUuid;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="MARKUP_TEXT")
	private String markupText;

	@Column(name="NAME_MSG_KEY")
	private String nameMsgKey;

	@Column(name="NUMBERIC_CUR_CODE")
	private Integer numbericCurCode;

	@Column(name="SCALE")
	private Integer scale;

	@Column(name="SYMBOL_MSG_KEY")
	private String symbolMsgKey;

	@Column(name="TEXT_CUR_CODE")
	private String textCurCode;

	public CurrencyEntity() {
	}

	public String getCurrencyUuid() {
		return this.currencyUuid;
	}

	public void setCurrencyUuid(String currencyUuid) {
		this.currencyUuid = currencyUuid;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getMarkupText() {
		return this.markupText;
	}

	public void setMarkupText(String markupText) {
		this.markupText = markupText;
	}

	public String getNameMsgKey() {
		return this.nameMsgKey;
	}

	public void setNameMsgKey(String nameMsgKey) {
		this.nameMsgKey = nameMsgKey;
	}

	public Integer getNumbericCurCode() {
		return this.numbericCurCode;
	}

	public void setNumbericCurCode(Integer numbericCurCode) {
		this.numbericCurCode = numbericCurCode;
	}

	public Integer getScale() {
		return this.scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getSymbolMsgKey() {
		return this.symbolMsgKey;
	}

	public void setSymbolMsgKey(String symbolMsgKey) {
		this.symbolMsgKey = symbolMsgKey;
	}

	public String getTextCurCode() {
		return this.textCurCode;
	}

	public void setTextCurCode(String textCurCode) {
		this.textCurCode = textCurCode;
	}

}
