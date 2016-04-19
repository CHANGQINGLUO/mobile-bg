/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 * @author SPA
 * @mb-bg-fw-core
 *
 */
package com.mb.framework.dao.impl;

import org.springframework.stereotype.Repository;

import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.dao.ParamDAO;
import com.mb.framework.entity.ParamEntity;

@Repository("paramDAO")
public class ParamDAOImpl extends AbstractDAO<ParamEntity> implements ParamDAO {

	/**
	 * constructor
	 */
	public ParamDAOImpl() {
		super();
		this.setEntityClass(ParamEntity.class);
	}

	/**
	 * This method is used to insert the ParamEntity in SYS_PARAM table.
	 * @param ParamEntity
	 */
	@Override
	public void addParam(ParamEntity param) {
		save(param);
	}

	/**
	 * This method is used to update the ParamEntity in SYS_PARAM table.
	 * @param ParamEntity
	 */
	@Override
	public ParamEntity updateParam(ParamEntity param) {
		return update(param);
	}

	/**
	 * This method is used to delete the ParamEntity from SYS_PARAM table.
	 * @param ParamEntity
	 */
	@Override
	public void deleteParam(ParamEntity param) {
		delete(param);
	}

	/**
	 * This method is used to get ParamEntity from SYS_PARAM table.
	 * @param paramCode
	 * @param paramType
	 * @return ParamEntity
	 */
	@Override
	public ParamEntity getByParamCodeAndType(String paramCode, String paramType) {
		
		return em
				.createQuery(
						"select pe from ParamEntity pe where pe.paramCode = :paramCode and pe.paramType = :paramType and pe.isDeleted=:isDeleted",
						ParamEntity.class).setParameter("paramCode", paramCode)
				.setParameter("paramType", paramType)
				.setParameter("isDeleted", false).getSingleResult();

	}

}
