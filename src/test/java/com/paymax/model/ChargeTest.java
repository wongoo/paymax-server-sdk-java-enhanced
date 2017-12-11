package com.paymax.model;

import com.alibaba.fastjson.JSON;
import com.paymax.PaymaxTest;
import com.paymax.exception.PaymaxException;
import com.paymax.model.req.ChargeReq;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wangoo
 * @since 2017-11-27 11:07
 */
public class ChargeTest extends PaymaxTest {

    @Test
    public void testCharge() throws PaymaxException {
        ChargeReq chargeReq = new ChargeReq();
        chargeReq.setAmount(new BigDecimal(1.0));
        chargeReq.setSubject("Hello World");
        chargeReq.setBody("charge req");
        chargeReq.setOrderNo(UUID.randomUUID().toString());
        chargeReq.setChannel(Channel.wechat_wap);
        chargeReq.setClientIp("127.0.0.1");
        chargeReq.setCurrency("CNY");
        chargeReq.setDescription("我是中文");

        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("open_id", "oYbmXv2Q-bifqiKaIE-wPOYO9L7M");
        chargeReq.setExtra(extra);

        System.out.println("-------> charge request:" + chargeReq);
        Charge charge = Charge.create(chargeReq);
        printResult(charge);
    }

    /**
     * 查询充值订单
     */
    @Test
    public void testRetrieve() throws PaymaxException {
        Charge charge = Charge.retrieve("ch_6f97ac4f57bf182cfe140f34");
        System.out.println("-------> retrieve charge:");
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

}
