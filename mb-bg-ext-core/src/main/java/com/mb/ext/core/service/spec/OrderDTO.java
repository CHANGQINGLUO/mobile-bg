package com.mb.ext.core.service.spec;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mb.ext.core.constant.Constants;
import com.mb.framework.service.spec.AbstractBaseDTO;

public class OrderDTO  extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String userUuid;
	private Date createDate;
	private String orderNumber;
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCreateDateStr(){
		if (getCreateDate() == null)
			return "";
		else
			return new SimpleDateFormat(
				Constants.DATE_FORMAT).format(getCreateDate());
	}
	
	public String getLoginId() {
		return loginId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	private String loginId;
	private String productId;
	private String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	private BigDecimal productPrice;
	private String productDescription;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	private String productUuid;
	private BigDecimal amount;
	private int count;
	private String status;
	private String mailAddress;
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
	public String getProductUuid() {
		return productUuid;
	}
	public void setProductUuid(String productUuid) {
		this.productUuid = productUuid;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String customerName;
	private String phone;
	
	public String getStatusDescription(){
		if(Constants.ORDER_STATUS_CREATED.equals(getStatus()))
			return "已下单";
		else if(Constants.ORDER_STATUS_PAYED.equals(getStatus()))
			return "已支付";
		else if(Constants.ORDER_STATUS_INPROGRESS.equals(getStatus()))
			return "检测中";
		else if(Constants.ORDER_STATUS_COMPLETED.equals(getStatus()))
			return "已完成";
		else return "未知状态";	}
	
}
