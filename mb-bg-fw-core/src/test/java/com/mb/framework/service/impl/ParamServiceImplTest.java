package com.mb.framework.service.impl;

import java.util.GregorianCalendar;

import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.framework.entity.ParamEntity;
import com.mb.framework.service.ParamService;
import com.mb.framework.util.log.LogHelper;

/**
 * 
 * @author SPA
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParamServiceImplTest extends TestSuite {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public ParamService paramService;
	
	/**
	 * 
	 * This method is used for test add ParamEntity
	 */
	@Test
	public void test1AddParam()
	{
		try{
			
			ParamEntity param = new ParamEntity();
			param.setBundleId("101");
			param.setCreateBy("Tester");
			param.setCreateDate(GregorianCalendar.getInstance().getTime());
			param.setParamCode("A101");
			param.setParamType("SysParam");
			param.setParamValue("Sys Param");
			
			paramService.addParam(param);
			Assert.assertNotNull(param.getUuid());
			
		}catch(Exception ex){
			logger.error("Failed to add ParamEntity", ex);
		}
	}
	

	/**
	 * 
	 * This method is used for test update ParamEntity
	 */
	@Test
	public void test2UpdateParam()
	{
		try{
		
			ParamEntity param = paramService.getByParamCodeAndType("A101","SysParam");
			
			param.setParamValue("Paraupdate");
			param.setUpdateBy("TesterUpdate");
			param.setUpdateDate(GregorianCalendar.getInstance().getTime());
						
			ParamEntity paramEntity = paramService.updateParam(param);
			Assert.assertNotNull(paramEntity.getUuid());
		
		}catch(Exception ex){
			logger.error("Failed to update ParamEntity", ex);
		}
	}
	
	/**
	 * 
	 * This method is used for test delete ParamEntity
	 */
	@Test
	public void test3DeleteParam()
	{
		try{
			ParamEntity param = paramService.getByParamCodeAndType("A101","SysParam");
			
			paramService.deleteParam(param);
			Assert.assertTrue(param.isDeleted());
			
		}catch(Exception ex){
			logger.error("Failed to delete ParamEntity", ex);
		}
	}
	
}
