package com.mb.ext.core.entity;

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
@Table(name = "USER_USER")
@NamedQuery(name = "UserUserEntity.findAll", query = "SELECT u FROM UserUserEntity u")
public class UserUserEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "USER_USER_UUID")
	@GenericGenerator(name = "USER_USER_UUID", strategy = "uuid")
	@Column(name = "USER_USER_UUID", nullable = false, length = 100)
	private String userUserUuid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BASE_USER_UUID")
	private UserEntity baseUser;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_UUID")
	private UserEntity user;
	
	@Column(name = "RELTYPE" , length = 10)
	private String relType;

	public String getRelType() {
		return relType;
	}


	public void setRelType(String relType) {
		this.relType = relType;
	}


	public String getUserUserUuid() {
		return userUserUuid;
	}


	public void setUserUserUuid(String userUserUuid) {
		this.userUserUuid = userUserUuid;
	}


	public UserEntity getBaseUser() {
		return baseUser;
	}


	public void setBaseUser(UserEntity baseUser) {
		this.baseUser = baseUser;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}
	

	
}