package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 实时交易响应对象
 * Created by wxw on 2017/3/15.
 */
public class ChargeRealTimeResponse extends PaymaxBase implements PaymaxFailureMessage {
    /**
     * 渠道订单号
     */
    @JSONField(name = "id")
    private String id;

    /**
     * 商户订单号
     */
    @JSONField(name = "order_no")
    private String orderNO;

    /**
     * 交易金额 保留两位小数
     */
    @JSONField(name = "amount")
    private Double amount;

    /**
     * 交易状态
     */
    @JSONField(name = "status")
    private OrderStatus status;

    /**
     * 商户保留域1
     */
    private String extra1;

    /**
     * 商户保留域2
     */
    private String extra2;

    /**
     * 商户保留域3
     */
    private String extra3;

    /**
     * 订单的错误码
     */
    @JSONField(name="failure_code")
    private String failureCode;
    /**
     *  订单的错误消息的描述
     */
    @JSONField(name="failure_msg")
    private String failureMsg;

    /**
     * 本次请求是否成功 true:成功,false:失败
     */
    @JSONField(name = "req_success_flag")
    private Boolean reqSuccessFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public Boolean getReqSuccessFlag() {
        return reqSuccessFlag;
    }

    public void setReqSuccessFlag(Boolean reqSuccessFlag) {
        this.reqSuccessFlag = reqSuccessFlag;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }
}
