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
@Table(name = "USER_GROUP")
@NamedQuery(name = "UserGroupEntity.findAll", query = "SELECT u FROM UserGroupEntity u")
public class UserGroupEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "USER_GROUP_UUID")
	@GenericGenerator(name = "USER_GROUP_UUID", strategy = "uuid")
	@Column(name = "USER_GROUP_UUID", nullable = false, length = 100)
	private String userGroupUuid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_UUID")
	private UserEntity user;

	public String getUserGroupUuid() {
		return userGroupUuid;
	}

	public void setUserGroupUuid(String userGroupUuid) {
		this.userGroupUuid = userGroupUuid;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_UUID")
	private GroupEntity group;
	

	
}