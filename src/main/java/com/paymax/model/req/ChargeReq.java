package com.paymax.model.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.paymax.model.Channel;

import java.util.Map;

/**
 * @author wangoo
 * @since 2017-11-24 09:06
 */
public class ChargeReq {

    //商户订单号，在商户系统内唯一，8-20位数字或字母，不允许特殊字符
    @JSONField(name = "order_no")
    private String orderNo;

    private double amount;

    private String subject;

    private String body;

    private Channel channel;

    private String app;

    @JSONField(name = "client_ip")
    private String clientIp;

    private String description;

    //	订单失效时间，13位时间戳
    @JSONField(name = "time_expire")
    private Long timeExpire;

    private String currency;

    //请根据渠道要求确定是否需要传递extra字段
    private Map<String, Object> extra;

    private Map<String, Object> metadata;

    /*-------------setter/getter------------------------------*/

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Long timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
