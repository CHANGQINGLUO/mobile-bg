package com.mb.ext.core.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "ORDER")
@NamedQuery(name = "OrderEntity.findAll", query = "SELECT u FROM OrderEntity u")
public class OrderEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(generator = "ORDER_UUID")
	@GenericGenerator(name = "ORDER_UUID", strategy = "uuid")
	@Column(name = "ORDER_UUID", nullable = false, length = 100)
	private String orderUuid;

	@Column(name = "COUNT")
	private int count;

	@Column(name = "STATUS", length = 1)
	private String status;
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "ORDER_NUM", length = 32)
	private String orderNumber;
	
	@Column(name = "MAILADDRESS", length = 100)
	private String mailAddress;
	
	@Column(name = "CUSTOMERNAME", length = 10)
	private String customerName;
	
	@Column(name = "PHONE", length = 11)
	private String phone;
	
	@Column(name = "AMOUNT", precision=12, scale=2)
	private BigDecimal amount ;
	
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getOrderUuid() {
		return orderUuid;
	}

	public void setOrderUuid(String orderUuid) {
		this.orderUuid = orderUuid;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_UUID")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_UUID")
	private ProductEntity product;


	

	
}