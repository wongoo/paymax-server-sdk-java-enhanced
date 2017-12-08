package com.paymax.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.paymax.config.PaymaxConfig;
import com.paymax.exception.PaymaxException;
import com.paymax.model.req.RefundReq;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by xiaowei.wang on 2016/4/26. 后续如果有新增字段，开发者只需要在此类中加上即可
 */
public class Refund extends Paymax {
    //	退款订单id，系统内唯一，以“re_”开头，后跟24位随机数
    private String id;
    //	商户订单号，在商户系统内唯一，8-20位数字或字母，不允许特殊字符
    @JSONField(name = "order_no")
    private String orderNo;
    //	退款订单对应的支付订单id
    private String charge;
    //	退款订单总金额，大于0的数字，单位是该币种的货币单位
    private BigDecimal amount;
    //特定渠道需要的的额外附加参数
    private Map<String, Object> extra;
    //退款备注，限制300个字符内
    private String description;
    //	支付渠道退款订单号
    @JSONField(name = "transaction_no")
    private String transactionNo;
    //用户自定义元数据
    private Map<String, Object> metadata;
    //订单创建时间，13位时间戳
    @JSONField(name = "time_created")
    private Long timeCreated;
    //	订单退款完成时间，13位时间戳
    @JSONField(name = "time_succeed")
    private Long timeSucceed;
    //订单的错误码
    @JSONField(name = "failure_code")
    private String failureCode;
    //订单的错误消息的描述
    @JSONField(name = "failure_msg")
    private String failureMsg;
    //	订单状态，只有三种（PROCESSING-处理中，SUCCEED-成功，FAILED-失败）
    private String status;
    //本次请求是否成功 true:成功,false:失败
    private Boolean reqSuccessFlag;

    public Boolean getReqSuccessFlag() {
        return reqSuccessFlag;
    }

    public void setReqSuccessFlag(Boolean reqSuccessFlag) {
        this.reqSuccessFlag = reqSuccessFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getTimeSucceed() {
        return timeSucceed;
    }

    public void setTimeSucceed(Long timeSucceed) {
        this.timeSucceed = timeSucceed;
    }

    /**
     * 创建退款订单
     */
    public static Refund create(String chargeId, Map<String, Object> params)
            throws PaymaxException {
        return request(PaymaxConfig.API_BASE_URL + PaymaxConfig.CREATE_CHARGE + "/" + chargeId
                + "/refunds", JSONObject.toJSONString(params), Refund.class);
    }

    /**
     * 创建退款订单
     */
    public static Refund create(String chargeId, RefundReq req) throws PaymaxException {
        return request(PaymaxConfig.API_BASE_URL + PaymaxConfig.CREATE_CHARGE + "/" + chargeId
                + "/refunds", JSONObject.toJSONString(req), Refund.class);
    }

    /**
     * 查询退款订单
     */
    public static Refund retrieve(String chargeId, String refundId) throws PaymaxException {
        return request(PaymaxConfig.API_BASE_URL + PaymaxConfig.CREATE_CHARGE + "/" + chargeId
                + "/refunds/" + refundId, null, Refund.class);
    }
}
