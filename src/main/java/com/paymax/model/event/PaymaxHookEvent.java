package com.paymax.model.event;

import com.alibaba.fastjson.JSONObject;
import com.paymax.config.SignConfig;
import com.paymax.exception.InvalidResponseException;
import com.paymax.exception.PaymaxException;
import com.paymax.sign.RSA;

/**
 * @author wangoo
 * @since 2017-11-28 09:32
 */
public class PaymaxHookEvent {
    private String data;
    private String notifyNo;
    private Long timeCreated;
    private PaymaxEventType type;

    /*------------------------------*/
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNotifyNo() {
        return notifyNo;
    }

    public void setNotifyNo(String notifyNo) {
        this.notifyNo = notifyNo;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public PaymaxEventType getType() {
        return type;
    }

    public void setType(PaymaxEventType type) {
        this.type = type;
    }
    /*------------------------------*/

    public Object parseData() throws PaymaxException {
        return parseData(type, data);
    }

    public static Object parseData(PaymaxEventType type, String data) throws PaymaxException {
        if (type == null) {
            throw new PaymaxException("event type is null");
        }
        if (data == null) {
            throw new PaymaxException("event data is null");
        }
        return JSONObject.parseObject(data, type.getObjectType());
    }

    public static PaymaxHookEvent parseEvent(String eventContent) {
        return JSONObject.parseObject(eventContent, PaymaxHookEvent.class);
    }

    public static PaymaxHookEvent parseEvent(String eventContent, String sign)
            throws PaymaxException {
        boolean flag = RSA.verify(eventContent, sign, SignConfig.getPaymaxPublicKey());
        if (!flag) {
            throw new InvalidResponseException("Event Data And Sign Verify Failure");
        }
        return JSONObject.parseObject(eventContent, PaymaxHookEvent.class);
    }
}
