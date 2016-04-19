package com.mb.ext.core.entity;

import java.util.Date;
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
@Table(name = "USER")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Id
	@GeneratedValue(generator = "USER_UUID")
	@GenericGenerator(name = "USER_UUID", strategy = "uuid")
	@Column(name = "USER_UUID", nullable = false, length = 100)
	private String userUuid;

	@Column(name = "CONTACT_HM", length = 20)
	private String contactHm;

	@Column(name = "CONTACT_OFF", length = 20)
	private String contactOff;
	
	@Column(name = "ADDRESS", length = 100)
	private String address;
	
	@Column(name = "COMPANY", length = 100)
	private String company;

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	@Column(name = "CLIENTCODE", length = 8)
	private String clientCode;
	public List<UserUserEntity> getCustomerEntityList() {
		return customerEntityList;
	}

	public void setCustomerEntityList(List<UserUserEntity> customerEntityList) {
		this.customerEntityList = customerEntityList;
	}

	public List<UserUserEntity> getAdvisorEntityList() {
		return advisorEntityList;
	}

	public void setAdvisorEntityList(List<UserUserEntity> advisorEntityList) {
		this.advisorEntityList = advisorEntityList;
	}

	@Column(name = "EMAIL" , length = 100)
	private String email;

	@Column(name = "NAME" , nullable = false, length = 100)
	private String name;

	@Column(name = "LOGINID" , length = 45)
	private String loginId;
	
	@Column(name = "PASSWORD" , length = 45)
	private String password;
	
	@Column(name = "LASTLOGINTIME")
	private Date lastLoginTime;
	
	@Column(name = "FAILEDLOGINCOUNT")
	private int failedLoginCount;

	@Column(name = "LOCKEDTIME")
	private Date lockedTime;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserGroupEntity> userGroupEntity;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "baseUser")
	private List<UserUserEntity> customerEntityList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserUserEntity> advisorEntityList;
	
	public List<IncomeEntity> getIncomeEntityList() {
		return incomeEntityList;
	}

	public void setIncomeEntityList(List<IncomeEntity> incomeEntityList) {
		this.incomeEntityList = incomeEntityList;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<OrderEntity> orderEntityList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<IncomeEntity> incomeEntityList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "from_user")
	private List<TransferEntity> fromUserEntityList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "to_user")
	private List<TransferEntity> toUserEntityList;
	
	public String getLoginId() {
		return loginId;
	}

	public List<TransferEntity> getFromUserEntityList() {
		return fromUserEntityList;
	}

	public void setFromUserEntityList(List<TransferEntity> fromUserEntityList) {
		this.fromUserEntityList = fromUserEntityList;
	}

	public List<TransferEntity> getToUserEntityList() {
		return toUserEntityList;
	}

	public void setToUserEntityList(List<TransferEntity> toUserEntityList) {
		this.toUserEntityList = toUserEntityList;
	}

	public List<OrderEntity> getOrderEntityList() {
		return orderEntityList;
	}

	public void setOrderEntityList(List<OrderEntity> orderEntityList) {
		this.orderEntityList = orderEntityList;
	}

	public List<UserGroupEntity> getUserGroupEntity() {
		return userGroupEntity;
	}

	public void setUserGroupEntity(List<UserGroupEntity> userGroupEntity) {
		this.userGroupEntity = userGroupEntity;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(int failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public Date getLockedTime() {
		return lockedTime;
	}

	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	/**
	 * @return the userUuid
	 */
	public String getUserUuid()
	{
		return userUuid;
	}

	/**
	 * @param userUuid
	 *            the userUuid to set
	 */
	public void setUserUuid(String userUuid)
	{
		this.userUuid = userUuid;
	}

	/**
	 * @return the contactHm
	 */
	public String getContactHm()
	{
		return contactHm;
	}

	/**
	 * @param contactHm
	 *            the contactHm to set
	 */
	public void setContactHm(String contactHm)
	{
		this.contactHm = contactHm;
	}

	/**
	 * @return the contactOff
	 */
	public String getContactOff()
	{
		return contactOff;
	}

	/**
	 * @param contactOff
	 *            the contactOff to set
	 */
	public void setContactOff(String contactOff)
	{
		this.contactOff = contactOff;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
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