package com.mb.ext.core.service.spec;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mb.ext.core.constant.Constants;
import com.mb.framework.service.spec.AbstractBaseDTO;

public class IncomeDTO  extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String userUuid;
	private Date createDate;
	private BigDecimal totalIncome;
	private BigDecimal totalPayment;
	private BigDecimal totalOutstanding;
	
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}


	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}


	public BigDecimal getTotalPayment() {
		return totalPayment;
	}


	public void setTotalPayment(BigDecimal totalPayment) {
		this.totalPayment = totalPayment;
	}


	public BigDecimal getTotalOutstanding() {
		return totalOutstanding;
	}


	public void setTotalOutstanding(BigDecimal totalOutstanding) {
		this.totalOutstanding = totalOutstanding;
	}


	public String getCreateDateStr(){
		if (getCreateDate() == null)
			return "";
		else
			return new SimpleDateFormat(
				Constants.DATE_FORMAT).format(getCreateDate());
	}
	

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getOrderUuid() {
		return orderUuid;
	}
	public void setOrderUuid(String orderUuid) {
		this.orderUuid = orderUuid;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}


	private String loginId;

	private String orderUuid;
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}


	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}


	private BigDecimal amount;
	private BigDecimal rate;
	
	private OrderDTO orderDTO;
	private UserDTO userDTO;

	public UserDTO getUserDTO() {
		return userDTO;
	}


	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
