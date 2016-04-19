/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 * BodyDTO.java
 *
 */
package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

/**
 * @author SPA
 * 
 */
public class BodyDTO extends AbstractBaseDTO
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7903714034275674368L;

	private CaseHeaderDTO caseHeader;

	private UserDTO userDetails;

	/**
	 * @return the caseHeader
	 */
	public CaseHeaderDTO getCaseHeader()
	{
		return caseHeader;
	}

	/**
	 * @param caseHeader
	 *            the caseHeader to set
	 */
	public void setCaseHeader(CaseHeaderDTO caseHeader)
	{
		this.caseHeader = caseHeader;
	}

	/**
	 * @return the rmDetails
	 */
	public UserDTO getUserDetails()
	{
		return userDetails;
	}

	/**
	 * @param rmDetails
	 *            the rmDetails to set
	 */
	public void setUserDetails(UserDTO userDetails)
	{
		this.userDetails = userDetails;
	}

	

	

}
