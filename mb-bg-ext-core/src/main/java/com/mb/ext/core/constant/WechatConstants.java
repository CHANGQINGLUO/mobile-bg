package com.mb.ext.core.constant;


public class WechatConstants {
	
	
	public final static String APPID_VALUE = "wxe3a6747106622484";
	public final static String APP_SECRET_VALUE = "c229f21cf7c0b3c6234abfb480128a87";
	public final static String MERCHANT_ID = "1332514601";
	//TODO 商户号API安全的API密钥中
	public final static String KEY = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9";
	
	public final static String  SUCCESS_RESPONSE = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	
	
	//公用字段
	public final static String APPID = "appid"; //微信开放平台审核通过的应用APPID, String(32)
	public final static String MCH_ID = "mch_id"; //微信支付分配的商户号,  String(32)
	public final static String DEVICE_INFO = "device_info"; //终端设备号(门店号或收银设备ID)，默认请传"WEB", String(32)
	public final static String NONCE_STR = "nonce_str"; //随机字符串，不长于32位。推荐随机数生成算法, String(32)
	public final static String SIGN = "sign"; //签名,  String(32)
	public final static String TRADE_TYPE = "trade_type"; //支付类型, String(16)
	
	//统一下单接口Request
	public final static String PREPAY_REQ_BODY = "body"; //商品或支付单简要描述, String(128)
	public final static String PREPAY_REQ_DETAIL = "detail"; //商品名称明细列表, String(8192)
	public final static String PREPAY_REQ_ATTACH = "attach"; //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据, String(127)
	public final static String PREPAY_REQ_OUT_TRADE_NO = "out_trade_no"; //商户系统内部的订单号,32个字符内、可包含字母,String(32)
	public final static String PREPAY_REQ_FEE_TYPE = "fee_type"; //符合ISO 4217标准的三位字母代码，默认人民币：CNY, String(16)
	public final static String PREPAY_REQ_TOTAL_FEE = "total_fee"; //订单总金额，单位为分, Int
	public final static String PREPAY_REQ_SPBILL_CREATE_IP = "spbill_create_ip"; //用户端实际ip, String(16)
	public final static String PREPAY_REQ_TIME_START = "time_start"; //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010, String(14)
	public final static String PREPAY_REQ_TIME_EXPIRE = "time_expire"; //订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则 注意：最短失效时间间隔必须大于5分钟, String(16)
	public final static String PREPAY_REQ_GOODS_TAG = "goods_tag"; //商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠, String(32)
	public final static String PREPAY_REQ_NOTIFY_URL = "notify_url"; //接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。, String(256)
	public final static String PREPAY_REQ_LIMIT_PAY = "limit_pay"; //no_credit--指定不能使用信用卡支付, String(32)	
	//统一下单接口Response
	public final static String PREPAY_RES_RETURN_CODE = "return_code"; //SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断, String(16)
	public final static String PREPAY_RES_RETURN_MSG = "return_msg"; //返回信息，如非空，为错误原因签名失败参数格式校验错误, String(128)
	public final static String PREPAY_RES_RESULT_CODE = "result_code"; //String(32)
	public final static String PREPAY_RES_ERR_CODE = "err_code"; //String(32)
	public final static String PREPAY_RES_ERR_CODE_DES = "err_code_des"; //String(128)
	public final static String PREPAY_RES_PREPAY_ID = "prepay_id";

	//通知URL
	public final static String NOTIFY_URL = "http://120.76.96.199:8080/mb-bg-ext-web/rest/wechatPayResponse";
//	public final static String NOTIFY_URL = "http://120.76.96.199:8080/mb-bg-ext-web/rest/wechatPayResponse";
	public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
}
