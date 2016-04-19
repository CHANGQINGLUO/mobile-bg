package com.mb.ext.core.service.spec;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mb.ext.core.constant.Constants;
import com.mb.framework.service.spec.AbstractBaseDTO;

public class TransferDTO  extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String fromLoginId;
	private String toName;
	public String getToName() {
		return toName;
	}


	public void setToName(String toName) {
		this.toName = toName;
	}


	public String getFromLoginId() {
		return fromLoginId;
	}


	public void setFromLoginId(String fromLoginId) {
		this.fromLoginId = fromLoginId;
	}


	public String getToLoginId() {
		return toLoginId;
	}


	public void setToLoginId(String toLoginId) {
		this.toLoginId = toLoginId;
	}



	public Date getTransferDate() {
		return transferDate;
	}


	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}



	private String toLoginId;
	private Date createDate;
	private Date transferDate;
	
	public String getCreateDateStr(){
		if (getCreateDate() == null)
			return "";
		else
			return new SimpleDateFormat(
				Constants.DATE_FORMAT).format(getCreateDate());
	}
	
	public String getTransferDateStr(){
		if (getTransferDate() == null)
			return "";
		else
			return new SimpleDateFormat(
				Constants.DATE_FORMAT).format(getTransferDate());
	}
	

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	private BigDecimal amount;
	
	
}
