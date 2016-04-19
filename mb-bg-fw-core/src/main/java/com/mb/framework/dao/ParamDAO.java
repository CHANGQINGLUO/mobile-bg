/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao;

import com.mb.framework.entity.ParamEntity;

public interface ParamDAO {
	
	/**
	 * This method is used to insert the ParamEntity in SYS_PARAM table.
	 * @param ParamEntity
	 */
	public void addParam(ParamEntity paramEntity);

	/**
	 * This method is used to update the ParamEntity in SYS_PARAM table.
	 * @param ParamEntity
	 * @return ParamEntity
	 */
	public ParamEntity updateParam(ParamEntity paramEntity);

	/**
	 * This method is used to delete the ParamEntity from SYS_PARAM table.
	 * @param ParamEntity
	 */
	public void deleteParam(ParamEntity paramEntity);

	/**
	 * This method is used to get ParamEntity by paramCode and paramType  from SYS_PARAM table.
	 * @param paramCode
	 * @param paramType
	 * @return ParamEntity
	 */
	public ParamEntity getByParamCodeAndType(String paramCode, String paramType);

}
