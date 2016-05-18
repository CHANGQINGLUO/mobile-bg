package com.mb.ext.core.constant;

import java.math.BigDecimal;

public class Constants {
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public final static String KNOWLEDGE_TYPE_ENV = "1";
	public final static String KNOWLEDGE_TYPE_HEALTH = "2";
	public final static String KNOWLEDGE_TYPE_DECORATION = "3";
	public final static String KNOWLEDGE_TYPE_DETECT = "4";
	
	public final static String ORDER_STATUS_CREATED="C";
	public final static String ORDER_STATUS_PAYED="P";
	public final static String ORDER_STATUS_INPROGRESS="I";
	public final static String ORDER_STATUS_REPORT="R";
	public final static String ORDER_STATUS_COMPLETED="D";
	
	public final static String WEATHER_URL = "https://api.heweather.com/x3/weather?cityid=CN101270101&key=e00d6c8fc8054883acadffb05332b9a9";
	
	public final static BigDecimal CUSTOMER_RATE = new BigDecimal("0.1");
	public final static BigDecimal ADVISOR_RATE = new BigDecimal("0.3");
	public final static BigDecimal INTERNAL_RATE = new BigDecimal("0.05");
	
}
