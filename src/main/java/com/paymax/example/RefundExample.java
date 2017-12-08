package com.paymax.example;

import com.alibaba.fastjson.JSONObject;
import com.paymax.exception.PaymaxException;
import com.paymax.model.Refund;
import com.paymax.model.req.RefundReq;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowei.wang on 2016/4/27.
 */
public class RefundExample {

    public static void main(String[] args) throws PaymaxException {
        RefundExample ce = new RefundExample();
        ce.requestRefund();
        ce.retrieve();
    }

    /**
     * 创建退款订单
     */
    public void refund() throws PaymaxException {
        Map<String, Object> refundMap = new HashMap<String, Object>();
        refundMap.put("amount", "1.0");
        refundMap.put("description", "description");
        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("extra_key2", "extra_value2");
        extra.put("extra_key1", "extra_value1");
        refundMap.put("extra", extra);
        System.out.println("refund req:" + JSONObject.toJSONString(refundMap));
        Refund refund = Refund.create("ch_fee33a8fcbdb6a976d16cd10", refundMap);
        printResult(refund);
    }

    /**
     * 创建退款订单
     */
    public void requestRefund() throws PaymaxException {
        RefundReq req = new RefundReq();
        req.setAmount(new BigDecimal(1.0));
        req.setDescription("description");
        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("extra_key2", "extra_value2");
        extra.put("extra_key1", "extra_value1");
        req.setExtra(extra);
        System.out.println("refund req:" + JSONObject.toJSONString(req));
        Refund refund = Refund.create("ch_fee33a8fcbdb6a976d16cd10", req);
        printResult(refund);
    }

    /**
     * 输出请求结果
     */
    private void printResult(Refund refund) {
        if (refund.getReqSuccessFlag()) {//http请求成功
            System.out.println(refund);
        } else {//http请求失败
            String failureCode = refund.getFailureCode();
            String failureMsg = refund.getFailureMsg();
            System.out.println("failureCode:" + failureCode + ",failureMsg:" + failureMsg);
        }
    }

    /**
     * 退款查询订单
     */
    public void retrieve() throws PaymaxException {
        Refund refund =
                Refund.retrieve("ch_fee33a8fcbdb6a976d16cd10", "re_d6586ff6e077b95985344538");
        printResult(refund);
    }

}
