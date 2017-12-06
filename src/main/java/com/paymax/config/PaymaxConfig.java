package com.paymax.config;

/**
 * Created by xiaowei.wang on 2016/4/26.
 */
public class PaymaxConfig {
    //Paymax服务器地址
    public static final String API_BASE_URL = "https://www.paymax.cc/merchant-api/";
    //请求method
    public static final String PAY_QUERY = "v1/pay/query";
    public static final String PAY = "v1/pay";
    public static final String PAY_DOWNLOAD = "v1/pay/download";
    public static final String PAY_RETURN_DOWNLOAD = "v1/pay/return/download";
    public static final String CREATE_CHARGE = "v1/charges";
    //请求下载对账单
    public static final String STATEMENT_DOWNLOAD = "v1/statement/download";

    public static final String CHARGE_REAL_TIME = "v1/real_time/deduct";

    //编码集
    public static final String CHARSET = "UTF-8";
    //签名后数据的key
    public static final String SIGN = "sign";
    //SDK版本
    public static final String SDK_VERSION = "1.0.0";
}
