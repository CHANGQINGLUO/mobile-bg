package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

public class ImageDTO extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String referURL;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReferURL() {
		return referURL;
	}
	public void setReferURL(String referURL) {
		this.referURL = referURL;
	}
	
}
