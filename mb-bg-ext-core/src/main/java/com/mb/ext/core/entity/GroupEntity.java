package com.mb.ext.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "GROUP")
@NamedQuery(name = "GroupEntity.findAll", query = "SELECT g FROM GroupEntity g")
public class GroupEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GROUP_UUID")
	@GenericGenerator(name = "GROUP_UUID", strategy = "uuid")
	@Column(name = "GROUP_UUID", nullable = false, length = 100)
	private String groupUuid;

	@Column(nullable = false, length = 100)
	private String name;

	public List<UserGroupEntity> getUserGroupEntity() {
		return userGroupEntity;
	}

	public void setUserGroupEntity(List<UserGroupEntity> userGroupEntity) {
		this.userGroupEntity = userGroupEntity;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "group")
	private List<UserGroupEntity> userGroupEntity;
	/**
	 * @return the groupUuid
	 */
	public String getGroupUuid()
	{
		return groupUuid;
	}

	/**
	 * @param groupUuid
	 *            the groupUuid to set
	 */
	public void setGroupUuid(String groupUuid)
	{
		this.groupUuid = groupUuid;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	

	
}