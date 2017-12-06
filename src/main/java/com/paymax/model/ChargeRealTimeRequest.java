package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * 实时交易请求对象
 * Created by wxw on 2017/3/15.
 */
public class ChargeRealTimeRequest extends PaymaxBase {
    /**
     * 商户订单号，商户系统内唯一
     */
    @JSONField(name = "order_no")
    private String orderNo;

    /**
     * 银行账号
     */
    @JSONField(name = "bank_account_no")
    private String bankAccountNo;

    /**
     * 开户户名
     */
    @JSONField(name = "bank_account_name")
    private String bankAccountName;

    /**
     * 证件类型
     * 01-身份证…
     */
    @JSONField(name = "id_card_type")
    private String idCardType;

    /**
     * 证件号码
     */
    @JSONField(name = "id_card_no")
    private String idCardNo;

    /**
     * 通知手机号
     */
    @JSONField(name = "mobile_no")
    private String mobileNo;

    /**
     * 通知手机号
     */
    @JSONField(name = "card_expiry")
    private String cardExpiry;

    /**
     * 通知手机号
     */
    @JSONField(name = "card_cvv2")
    private String cardCvv2;

    /**
     * 交易金额
     * 精确到小数点后两位，单位：元，
     */
    @JSONField(name = "amount")
    private BigDecimal amount;

    /**
     * 账户类型
     * 0-对公；1-对私借记卡；2-对私贷记卡；3-对私存折
     */
    @JSONField(name = "account_type")
    private String accountType;

    /**
     * 备注信息
     */
    @JSONField(name = "comment")
    private String comment;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCardCvv2() {
        return cardCvv2;
    }

    public void setCardCvv2(String cardCvv2) {
        this.cardCvv2 = cardCvv2;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
