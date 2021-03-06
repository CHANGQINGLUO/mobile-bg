/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Jul 17, 2013 11:55:55 PM
 * @author SPA

 *
 */
/**
 * 
 */
package com.mb.framework.util;

import com.mb.framework.entity.AbstractBaseEntity;
import com.mb.framework.exception.SystemException;
import com.mb.framework.service.spec.AbstractBaseDTO;
import com.mb.framework.util.property.PropertyUtilExt;

/**
 * @author SPA
 *
 */
public class EntityDtoMappingUtil
{
	
	/**
	 * This method is used for mapping entity to DTO
	 * @param dto
	 * @param entity
	 * @throws SystemException
	 */
	public static void mapEntityToDTO(AbstractBaseDTO dto, AbstractBaseEntity entity) throws SystemException 
	{
		try 
		{
			PropertyUtilExt.copyProperties(dto, entity);
		} 
		catch (Throwable e) 
		{
			throw new SystemException("error.entity.to.dto");
		} 
	}
	
	/**
	 * This method is used for mapping DTO to entity
	 * @param dto
	 * @param entity
	 * @throws SystemException
	 */
	public static void mapDTOToEntity(AbstractBaseDTO dto,AbstractBaseEntity entity) throws SystemException{
		try
		{
			PropertyUtilExt.copyProperties(entity, dto);
		}
		catch (Throwable e)
		{
			throw new SystemException("error.dto.to.entity");
		}
	}
	

}
