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
 * CaseHeaderDTO.java
 *
 */
package com.mb.ext.core.service.spec;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mb.framework.service.spec.AbstractBaseDTO;

/**
 * @author SPA
 * 
 */
public class CaseHeaderDTO extends AbstractBaseDTO
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7378332118526233422L;

	private String referenceNumber;

	private String keyApplicantIndex;

	private String isChineseLang;
	
	private String isStandAlone;
	
	

	
	public String getIsStandAlone() {
		return isStandAlone;
	}

	public void setIsStandAlone(String isStandAlone) {
		this.isStandAlone = isStandAlone;
	}

	@JsonIgnore
	private List<String> allowedVersions;
	
	

	/**
	 * @return the referenceNumber
	 */
	public String getReferenceNumber()
	{
		return referenceNumber;
	}

	/**
	 * @param referenceNumber
	 *            the referenceNumber to set
	 */
	public void setReferenceNumber(String referenceNumber)
	{
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the keyApplicantIndex
	 */
	public String getKeyApplicantIndex()
	{
		return keyApplicantIndex;
	}

	/**
	 * @param keyApplicantIndex
	 *            the keyApplicantIndex to set
	 */
	public void setKeyApplicantIndex(String keyApplicantIndex)
	{
		this.keyApplicantIndex = keyApplicantIndex;
	}

	/**
	 * @return the isChineseLang
	 */
	public String getIsChineseLang()
	{
		return isChineseLang;
	}

	/**
	 * @param isChineseLang
	 *            the isChineseLang to set
	 */
	public void setIsChineseLang(String isChineseLang)
	{
		this.isChineseLang = isChineseLang;
	}

	/**
	 * @return the allowedVersions
	 */

	@JsonIgnore
	public List<String> getAllowedVersions()
	{
		return allowedVersions;
	}

	/**
	 * @param allowedVersions
	 *            the allowedVersions to set
	 */
	@JsonIgnore
	public void setAllowedVersions(List<String> allowedVersions)
	{
		this.allowedVersions = allowedVersions;
	}

	


}
