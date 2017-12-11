package com.paymax.example;

import com.alibaba.fastjson.JSON;
import com.paymax.exception.PaymaxException;
import com.paymax.model.Channel;
import com.paymax.model.Charge;
import com.paymax.model.req.ChargeReq;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xiaowei.wang on 2016/4/27.
 */
public class ChargeExample {

    public static void main(String[] args) throws PaymaxException {
        ChargeExample ce = new ChargeExample();
        ce.charge();
        ce.chargeReq();
        ce.retrieve();
    }

    /**
     * 创建充值订单
     */
    public void charge() throws PaymaxException {
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 1);
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        chargeMap.put("order_no", UUID.randomUUID());
        chargeMap.put("channel", "alipay_app");
        chargeMap.put("client_ip", "127.0.0.1");
        chargeMap.put("app", "app_7hqF2S6GYXET457i");
        chargeMap.put("currency", "CNY");
        chargeMap.put("description", "我是中文");
        //请根据渠道要求确定是否需要传递extra字段
        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("user_id", "中文测试");
        extra.put("return_url", "http://132.123.221.22/333/kad");
        chargeMap.put("extra", extra);

        System.out.println("-------> charge map:" + chargeMap);
        Charge charge = Charge.create(chargeMap);
        printResult(charge);
    }

    /**
     * 创建充值订单
     */
    public void chargeReq() throws PaymaxException {
        ChargeReq chargeReq = new ChargeReq();
        chargeReq.setAmount(new BigDecimal(1.0));
        chargeReq.setSubject("Hello World");
        chargeReq.setBody("charge req");
        chargeReq.setOrderNo(UUID.randomUUID().toString());
        chargeReq.setChannel(Channel.alipay_app);
        chargeReq.setClientIp("127.0.0.1");
        chargeReq.setApp("app_7hqF2S6GYXET457i");
        chargeReq.setCurrency("CNY");
        chargeReq.setDescription("我是中文");
        //请根据渠道要求确定是否需要传递extra字段
        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("user_id", "中文测试");
        extra.put("return_url", "http://132.123.221.22/333/kad");
        chargeReq.setExtra(extra);

        System.out.println("-------> charge request:" + chargeReq);
        Charge charge = Charge.create(chargeReq);
        printResult(charge);
    }

    /**
     * 输出请求结果
     */
    private void printResult(Charge charge) {
        if (charge.getReqSuccessFlag()) {//http请求成功
            System.out.println(JSON.toJSONString(charge));
        } else {//http请求失败
            System.out.println(JSON.toJSONString(charge));
            String failureCode = charge.getFailureCode();
            String failureMsg = charge.getFailureMsg();
            System.out.println("failureCode:" + failureCode);
            System.out.println("failureMsg:" + failureMsg);
        }
    }

    /**
     * 查询充值订单
     */
    public void retrieve() throws PaymaxException {
        Charge charge = Charge.retrieve("ch_6f97ac4f57bf182cfe140f34");
        System.out.println("-------> retrieve charge:");
        printResult(charge);
    }
}
