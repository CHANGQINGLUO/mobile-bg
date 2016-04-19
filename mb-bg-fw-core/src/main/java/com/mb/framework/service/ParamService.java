/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 11 Jun, 2014 1:25:57 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.framework.service;

import org.springframework.transaction.annotation.Transactional;

import com.mb.framework.entity.ParamEntity;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface ParamService{

	/**
	 * This method is used to insert the ParamEntity
	 * 
	 * @param ParamEntity
	 * @return
	 */
	public void addParam(ParamEntity user) throws BusinessException;
	
	/**
	 * This method is used to update the ParamEntity
	 * 
	 * @param ParamEntity
	 * @return ParamEntity
	 */
	public ParamEntity updateParam(ParamEntity param) throws BusinessException;
	
	/**
	 * This method is used to delete the ParamEntity
	 * 
	 * @param ParamEntity
	 * @return
	 */
	public void deleteParam(ParamEntity param) throws BusinessException;
	
	/**
	 * This method is used to get the ParamEntity based on paramCode and paramType
	 * 
	 * @param String
	 * @param String
	 * @return ParamEntity
	 */
	public ParamEntity getByParamCodeAndType(String paramCode,String paramType) throws BusinessException;
	
}
