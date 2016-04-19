package com.mb.ext.core.service.spec;

public class SaveResultDTO extends ResultDTO {
	
	
	
	
	public SaveResultDTO(String statusCode, String AccessInfoId,String statusMessage){
		super(statusCode, statusMessage);
		this.AccessInfoId = AccessInfoId;
	}
	
	
	public SaveResultDTO(String statusCode){
		super(statusCode);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4807499236592413167L;
	
	private String AccessInfoId;

	public String getAccessinfoId() {
		return AccessInfoId;
	}


	public void setAccesinfoId(String accessinfoId) {
		this.AccessInfoId = accessinfoId;
	}

	
	
	

}
