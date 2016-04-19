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
 * EpMapperUtil.java
 *
 */
package com.mb.ext.core.util;

import org.springframework.stereotype.Component;

import com.mb.ext.core.entity.UserEntity;
import com.mb.ext.core.service.spec.UserDTO;



/**
 * @author SPA
 * 
 */
@Component
public class EPMapperUtil
{

	private static final String ASSET_PREFIX = "YRCA";

	private static final String ASSETTYPE_INV_PREFIX = "YRCATI";

	private static final String ASSETTYPE_PROP_PREFIX = "YRCATP";

	private static final String ASSETTYPE_CPF_PREFIX = "YRCATC";

	private static final String RACE_PREFIX = "YRCRC";

	private static final String MARITAL_PREFIX = "YRCMS";

	/**
	 * 
	 * This method is used for creating userEntity from DTO.
	 * 
	 * @param userDTO
	 * @param userName
	 * @return
	 */
	public UserEntity createUserEntity(UserDTO userDTO, String userName)
	{
		UserEntity user = new UserEntity();

		user.setName(userDTO.getName());
		//user.setContactHm(userDTO.getContactNoHp());
		//user.setContactOff(userDTO.getContactNoOffice());
		//user.setEmail(userDTO.getEmailAddress());
		user.setCreateBy(userName);
		user.setUpdateBy(userName);
		user.setPassword(userDTO.getPassword());
		user.setLoginId(userDTO.getLoginId());
		return user;
	}


}
