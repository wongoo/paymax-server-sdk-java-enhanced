package com.paymax.model.event;

import com.alibaba.fastjson.JSONObject;
import com.paymax.exception.PaymaxException;
import com.paymax.model.Charge;
import com.paymax.model.Refund;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author wangoo
 * @since 2017-11-28 10:45
 */
public class PaymaxHookEventTest {

    @Test
    public void testParseCharge() throws IOException, PaymaxException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test_web_hook_event_charge.json");
        String eventContent = IOUtils.toString(inputStream, "UTF-8");
        PaymaxHookEvent paymaxHookEvent = PaymaxHookEvent.parseEvent(eventContent);
        Assert.assertEquals(PaymaxEventType.CHARGE, paymaxHookEvent.getType());

        Object data = paymaxHookEvent.parseData();
        Assert.assertTrue(data instanceof Charge);
        Charge charge = (Charge) data;
        Assert.assertEquals("4004512001201611068876533536", charge.getTransactionNo());
        Map<String, Object> credential = charge.getCredential();

        Assert.assertNotNull(credential);
        JSONObject wechatWap = (JSONObject) credential.get("wechat_wap");
        Assert.assertNotNull(wechatWap);
        Assert.assertTrue(wechatWap instanceof JSONObject);
        JSONObject wechatWapObject = (JSONObject) wechatWap;
        Object jsApiParams = wechatWapObject.get("jsApiParams");
        System.out.println(jsApiParams);
    }

    @Test
    public void testParseRefund() throws IOException, PaymaxException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test_web_hook_event_refund.json");
        String eventContent = IOUtils.toString(inputStream, "UTF-8");
        PaymaxHookEvent paymaxHookEvent = PaymaxHookEvent.parseEvent(eventContent);
        Assert.assertEquals(PaymaxEventType.REFUND, paymaxHookEvent.getType());

        Object data = paymaxHookEvent.parseData();
        Assert.assertTrue(data instanceof Refund);
        Refund refund = (Refund) data;
        Assert.assertEquals("2016110721001004480236849549", refund.getTransactionNo());
        Map<String, Object> extra = refund.getExtra();

        Assert.assertNotNull(extra);
        String refundUrl = (String) extra.get("refundUrl");
        Assert.assertNotNull(refundUrl);
        System.out.println(refundUrl);
    }
}
