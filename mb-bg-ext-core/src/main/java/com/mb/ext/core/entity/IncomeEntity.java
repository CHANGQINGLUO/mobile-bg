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
@Table(name = "INCOME")
@NamedQuery(name = "IncomeEntity.findAll", query = "SELECT u FROM IncomeEntity u")
public class IncomeEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(generator = "INCOME_UUID")
	@GenericGenerator(name = "INCOME_UUID", strategy = "uuid")
	@Column(name = "INCOME_UUID", nullable = false, length = 100)
	private String incomeUuid;

	@Column(name = "AMOUNT", precision=12, scale=2)
	private BigDecimal amount ;
	
	@Column(name = "RATE", precision=12, scale=2)
	private BigDecimal rate ;
	
	
	public String getIncomeUuid() {
		return incomeUuid;
	}

	public void setIncomeUuid(String incomeUuid) {
		this.incomeUuid = incomeUuid;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_UUID")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_UUID")
	private OrderEntity order;

	
}