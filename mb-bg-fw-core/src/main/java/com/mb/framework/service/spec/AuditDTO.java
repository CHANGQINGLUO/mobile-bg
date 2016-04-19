/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 6 Jun, 2014 6:09:01 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service.spec;

import java.util.Date;


public class AuditDTO extends AbstractBaseDTO
{
	private static final long serialVersionUID = 7537719716266268018L;
	
	
	private String userUUID;

	private AuditTypeDTO auditType;

	private String sessionId;

	private String custCin;

	private String custName;

	private Object data;
	
	private Date createDate;

	/**
	 * @return the userUUID
	 */
	public String getUserUUID()
	{
		return userUUID;
	}

	/**
	 * @param userUUID the userUUID to set
	 */
	public void setUserUUID(String userUUID)
	{
		this.userUUID = userUUID;
	}

	/**
	 * @return the auditType
	 */
	public AuditTypeDTO getAuditType()
	{
		return auditType;
	}

	/**
	 * @param auditType the auditType to set
	 */
	public void setAuditType(AuditTypeDTO auditType)
	{
		this.auditType = auditType;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId()
	{
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}

	/**
	 * @return the custCin
	 */
	public String getCustCin()
	{
		return custCin;
	}

	/**
	 * @param custCin the custCin to set
	 */
	public void setCustCin(String custCin)
	{
		this.custCin = custCin;
	}

	/**
	 * @return the custName
	 */
	public String getCustName()
	{
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	/**
	 * @return the data
	 */
	public Object getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data)
	{
		this.data = data;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate()
	{
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	

}
