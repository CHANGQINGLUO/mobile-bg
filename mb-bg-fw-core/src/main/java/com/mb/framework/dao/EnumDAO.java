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

import java.util.List;

import com.mb.framework.entity.EnumEntity;

public interface EnumDAO
{

	/**
	 * This method is used to insert the EnumEntity in SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 */
	public void addEnum(EnumEntity enumEntity);

	/**
	 * This method is used to update the EnumEntity in SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 * @return EnumEntity
	 */
	public EnumEntity updateEnum(EnumEntity enumEntity);

	/**
	 * This method is used to delete the EnumEntity from SYS_ENUM table.
	 * 
	 * @param EnumEntity
	 */
	public void deleteEnum(EnumEntity enumEntity);

	/**
	 * This method is used to get EnumEntity by messageKey from SYS_ENUM table.
	 * 
	 * @param messageKey
	 * @return EnumEntity
	 */
	public EnumEntity getByMessagekey(String messageKey);

	/**
	 * 
	 * This method is used for get enum entity list by category
	 * 
	 * @param category
	 * @return
	 */
	public List<EnumEntity> getByCategory(String category);

}
