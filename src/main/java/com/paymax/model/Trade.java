package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;

/**
 * Created by wxw on 2016/12/27.
 */
public class Trade extends PaymaxBase  {
    /**
     * 商户订单号
     * 商户系统内唯一
     */
    @JSONField(name = "order_no")
    private String merchantOrderNo;

    /**
     * 收款人银行代码
     * 详见附件“代收付相关码表.xls”
     */
    @JSONField(name = "bank_code")
    private String bankCode;

    /**
     * 收款人开户行所在省
     * 详见附件“代收付相关码表.xls”
     */
    @JSONField(name = "bank_account_province")
    private String bankAccountProvince;

    /**
     * 收款人开户支行名称
     */
    @JSONField(name = "bank_branch_name")
    private String bankBranchName;

    /**
     * 收款人开户行联行行号
     * 详见附件“代收付相关码表.xls”
     */
    @JSONField(name = "bank_branch_no")
    private String bankBranchNo;

    /**
     * 收款人开户户名
     * 对公为姓名，对私为企业名称
     */
    @JSONField(name = "bank_account_name")
    private String bankAccountName;

    /**
     * 收款人银行账号
     */
    @JSONField(name = "bank_account_no")
    private String bankAccountNo;

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
     * 收款人证件类型
     * 01-身份证…
     */
    @JSONField(name = "id_card_type")
    private String idCardType;

    /**
     * 收款人证件号码
     */
    @JSONField(name = "id_card_no")
    private String idCardNo;

    /**
     * 通知手机号
     */
    @JSONField(name = "mobile_no")
    private String mobileNo;

    /**
     * 商户保留域1
     */
    @JSONField(name = "extra1")
    private String extra1;

    /**
     * 商户保留域2
     */
    @JSONField(name = "extra2")
    private String extra2;

    /**
     * 商户保留域3
     */
    @JSONField(name = "extra3")
    private String extra3;

    /**
     * 商户保留域4
     */
    @JSONField(name = "extra4")
    private String extra4;

    /**
     * 商户保留域5
     */
    @JSONField(name = "extra5")
    private String extra5;

    /**
     * 备注信息
     */
    @JSONField(name = "comment")
    private String comment;

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAccountProvince() {
        return bankAccountProvince;
    }

    public void setBankAccountProvince(String bankAccountProvince) {
        this.bankAccountProvince = bankAccountProvince;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankBranchNo() {
        return bankBranchNo;
    }

    public void setBankBranchNo(String bankBranchNo) {
        this.bankBranchNo = bankBranchNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
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

    public String getExtra4() {
        return extra4;
    }

    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    public String getExtra5() {
        return extra5;
    }

    public void setExtra5(String extra5) {
        this.extra5 = extra5;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
