package com.mb.ext.core.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "TRANSFER")
@NamedQuery(name = "TransferEntity.findAll", query = "SELECT u FROM TransferEntity u")
public class TransferEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(generator = "TRANSFER_UUID")
	@GenericGenerator(name = "TRANSFER_UUID", strategy = "uuid")
	@Column(name = "TRANSFER_UUID", nullable = false, length = 100)
	private String transferUuid;

	@Column(name = "AMOUNT", precision=12, scale=2)
	private BigDecimal amount ;
	
	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	@Column(name = "TRANSFER_DATE")
	private Date transferDate ;
	
	public String getTransferUuid() {
		return transferUuid;
	}

	public void setTransferUuid(String transferUuid) {
		this.transferUuid = transferUuid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UserEntity getFrom_user() {
		return from_user;
	}

	public void setFrom_user(UserEntity from_user) {
		this.from_user = from_user;
	}

	public UserEntity getTo_user() {
		return to_user;
	}

	public void setTo_user(UserEntity to_user) {
		this.to_user = to_user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM_USER_UUID")
	private UserEntity from_user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_USER_UUID")
	private UserEntity to_user;

	
}