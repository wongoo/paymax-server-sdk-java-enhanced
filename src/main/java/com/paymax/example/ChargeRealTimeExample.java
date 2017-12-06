package com.paymax.example;

import com.alibaba.fastjson.JSONObject;
import com.paymax.config.PaymaxConfig;
import com.paymax.exception.PaymaxException;
import com.paymax.model.ChargeRealTimeQueryResponse;
import com.paymax.model.ChargeRealTimeRequest;
import com.paymax.model.ChargeRealTimeResponse;
import com.paymax.model.Paymax;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 实时交易接口调用示例,仅供参考。 Created by wxw on 2017/3/15.
 */
public class ChargeRealTimeExample {

    private static String queryDate;

    public static void main(String[] args) throws PaymaxException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -120);
        queryDate = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        doChargeRealTime();
        doChargeRealTimeQuery();
        doDownloadChargeBillFile();
        doDownloadChargeReturnFile();
    }

    /**
     * 下载回盘文件
     */
    private static void doDownloadChargeReturnFile() throws PaymaxException {
        Map<String, Object> statementMap = new HashMap<String, Object>();
        statementMap.put("appointDay", queryDate);
        statementMap.put("channelCategory", "LAKALA");
        statementMap.put("statementType", "CHARGE_RETURN");
        String responseData =
                Paymax.request(PaymaxConfig.API_BASE_URL + PaymaxConfig.STATEMENT_DOWNLOAD,
                        JSONObject.toJSONString(statementMap), String.class);
        System.out.println("===============================");
        System.out.println(responseData);
        System.out.println("===============================");
    }

    /**
     * 下载对账单
     */
    private static void doDownloadChargeBillFile() throws PaymaxException {
        Map<String, Object> statementMap = new HashMap<String, Object>();
        statementMap.put("appointDay", queryDate);
        statementMap.put("channelCategory", "LAKALA");
        statementMap.put("statementType", "CHARGE_BILL");
        String responseData =
                Paymax.request(PaymaxConfig.API_BASE_URL + PaymaxConfig.STATEMENT_DOWNLOAD,
                        JSONObject.toJSONString(statementMap), String.class);
        System.out.println("===============================");
        System.out.println(responseData);
        System.out.println("===============================");

    }

    /**
     * 查询实时交易结果
     */
    private static void doChargeRealTimeQuery() throws PaymaxException {
        String orderNo = "b095c686e11c46d987d860bb2d408205";
        ChargeRealTimeQueryResponse responseData = Paymax.request(
                PaymaxConfig.API_BASE_URL + PaymaxConfig.CHARGE_REAL_TIME + "/" + orderNo, null,
                ChargeRealTimeQueryResponse.class);
        System.out.println("===============================");
        System.out.println(JSONObject.toJSONString(responseData));
        System.out.println("===============================");
    }

    /**
     * 发起实时交易请求
     */
    private static void doChargeRealTime() throws PaymaxException {
        ChargeRealTimeRequest requestData = packageChargeRealTimeRequestData();
        ChargeRealTimeResponse responseData =
                Paymax.request(PaymaxConfig.API_BASE_URL + PaymaxConfig.CHARGE_REAL_TIME,
                        JSONObject.toJSONString(requestData), ChargeRealTimeResponse.class);
        System.out.println("===============================");
        System.out.println(JSONObject.toJSONString(responseData));
        System.out.println("===============================");
    }

    private static ChargeRealTimeRequest packageChargeRealTimeRequestData() {
        ChargeRealTimeRequest requestData = new ChargeRealTimeRequest();
        requestData.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        requestData.setBankAccountNo("6222020200072275201");
        requestData.setBankAccountName("xiaowei.wang");
        requestData.setIdCardType("01");
        requestData.setIdCardNo("142729197802186915");
        requestData.setMobileNo("13800138000");
        requestData.setCardExpiry("1911");
        requestData.setCardCvv2("345");
        requestData.setAmount(new BigDecimal("0.01"));
        requestData.setAccountType("2");
        requestData.setComment("charge real time test");
        requestData.setExtra1("extra1");
        requestData.setExtra2("extra2");
        requestData.setExtra3("extra3");
        return requestData;
    }
}
