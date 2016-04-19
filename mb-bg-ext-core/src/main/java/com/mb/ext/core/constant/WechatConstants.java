package com.mb.ext.core.constant;


public class WechatConstants {
	
	
	public final static String APPID_VALUE = "wxe3a6747106622484";
	public final static String APP_SECRET_VALUE = "c229f21cf7c0b3c6234abfb480128a87";
	public final static String MERCHANT_ID = "1332514601";
	//TODO �̻���API��ȫ��API��Կ��
	public final static String KEY = "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9";
	
	public final static String  SUCCESS_RESPONSE = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	
	
	//�����ֶ�
	public final static String APPID = "appid"; //΢�ſ���ƽ̨���ͨ����Ӧ��APPID, String(32)
	public final static String MCH_ID = "mch_id"; //΢��֧��������̻���,  String(32)
	public final static String DEVICE_INFO = "device_info"; //�ն��豸��(�ŵ�Ż������豸ID)��Ĭ���봫"WEB", String(32)
	public final static String NONCE_STR = "nonce_str"; //����ַ�����������32λ���Ƽ�����������㷨, String(32)
	public final static String SIGN = "sign"; //ǩ��,  String(32)
	public final static String TRADE_TYPE = "trade_type"; //֧������, String(16)
	
	//ͳһ�µ��ӿ�Request
	public final static String PREPAY_REQ_BODY = "body"; //��Ʒ��֧������Ҫ����, String(128)
	public final static String PREPAY_REQ_DETAIL = "detail"; //��Ʒ������ϸ�б�, String(8192)
	public final static String PREPAY_REQ_ATTACH = "attach"; //�������ݣ��ڲ�ѯAPI��֧��֪ͨ��ԭ�����أ����ֶ���Ҫ�����̻�Я���������Զ�������, String(127)
	public final static String PREPAY_REQ_OUT_TRADE_NO = "out_trade_no"; //�̻�ϵͳ�ڲ��Ķ�����,32���ַ��ڡ��ɰ�����ĸ,String(32)
	public final static String PREPAY_REQ_FEE_TYPE = "fee_type"; //����ISO 4217��׼����λ��ĸ���룬Ĭ������ң�CNY, String(16)
	public final static String PREPAY_REQ_TOTAL_FEE = "total_fee"; //�����ܽ���λΪ��, Int
	public final static String PREPAY_REQ_SPBILL_CREATE_IP = "spbill_create_ip"; //�û���ʵ��ip, String(16)
	public final static String PREPAY_REQ_TIME_START = "time_start"; //��������ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010, String(14)
	public final static String PREPAY_REQ_TIME_EXPIRE = "time_expire"; //����ʧЧʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��27��9��10��10���ʾΪ20091227091010���������ʱ����� ע�⣺���ʧЧʱ�����������5����, String(16)
	public final static String PREPAY_REQ_GOODS_TAG = "goods_tag"; //��Ʒ��ǣ�����ȯ�������Żݹ��ܵĲ�����˵���������ȯ�������Ż�, String(32)
	public final static String PREPAY_REQ_NOTIFY_URL = "notify_url"; //����΢��֧���첽֪ͨ�ص���ַ��֪ͨurl����Ϊֱ�ӿɷ��ʵ�url������Я��������, String(256)
	public final static String PREPAY_REQ_LIMIT_PAY = "limit_pay"; //no_credit--ָ������ʹ�����ÿ�֧��, String(32)	
	//ͳһ�µ��ӿ�Response
	public final static String PREPAY_RES_RETURN_CODE = "return_code"; //SUCCESS/FAIL ���ֶ���ͨ�ű�ʶ���ǽ��ױ�ʶ�������Ƿ�ɹ���Ҫ�鿴result_code���ж�, String(16)
	public final static String PREPAY_RES_RETURN_MSG = "return_msg"; //������Ϣ����ǿգ�Ϊ����ԭ��ǩ��ʧ�ܲ�����ʽУ�����, String(128)
	public final static String PREPAY_RES_RESULT_CODE = "result_code"; //String(32)
	public final static String PREPAY_RES_ERR_CODE = "err_code"; //String(32)
	public final static String PREPAY_RES_ERR_CODE_DES = "err_code_des"; //String(128)
	public final static String PREPAY_RES_PREPAY_ID = "prepay_id";

	//֪ͨURL
	public final static String NOTIFY_URL = "http://120.76.96.199:8080/mb-bg-ext-web/rest/wechatPayResponse";
//	public final static String NOTIFY_URL = "http://120.76.96.199:8080/mb-bg-ext-web/rest/wechatPayResponse";
	public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
}
