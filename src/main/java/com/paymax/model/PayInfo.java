package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.paymax.config.PaymaxConfig;
import com.paymax.exception.PaymaxException;

import java.math.BigDecimal;

/**
 * Created by wxw on 2016/12/29.
 */
public class PayInfo extends Paymax implements PaymaxFailureMessage {
    /**
     * 批次号 商户上传批次号
     */
    @JSONField(name = "batch_no")
    private String batchNo;

    /**
     * 文件id 每一此批量代付在“代收付”系统中都会有一个唯一文件id
     */
    @JSONField(name = "file_id")
    private String fileId;

    /**
     * 日期 格式：yyyyMMdd
     */
    private String date;

    /**
     * 文件处理状态 商户已提交 APPLYING 渠道已受理 ACCEPTED 渠道受理失败 ACCEPT_FAILED 银行已受理 PROCESSING 交易成功 SUCCEED 部分成功
     * PARTIAL_SUCCEED 代付失败 FAILED
     */
    private FileStatus status;

    /**
     * 文件名 商户上传时的文件名称
     */
    @JSONField(name = "file_name")
    private String fileName;

    /**
     * 提交时间 格式为：yyyy-MM-dd HH:mm:ss
     */
    @JSONField(name = "commit_date")
    private String commitDate;

    /**
     * 交易类型 CHARGE代收、PAY代付
     */
    @JSONField(name = "trade_type")
    private TradeType tradeType;

    /**
     * 总笔数
     */
    private Integer count;

    /**
     * 总金额
     */
    @JSONField(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 成功笔数
     */
    @JSONField(name = "succeed_count")
    private Integer succeedCount;

    /**
     * 成功金额
     */
    @JSONField(name = "succeed_amount")
    private BigDecimal succeedAmount;

    /**
     * 回盘时间 格式为：yyyy-MM-dd HH:mm:ss
     */
    @JSONField(name = "return_date")
    private String returnDate;

    /**
     * 失败原因
     */
    @JSONField(name = "fail_reason")
    private String failReason;

    /**
     * 错误码
     */
    @JSONField(name = "failure_code")
    private String failureCode;
    /**
     * 错误信息
     */
    @JSONField(name = "failure_msg")
    private String failureMsg;
    /**
     * 本次请求是否成功 true:成功,false:失败
     */
    @JSONField(name = "req_success_flag")
    private Boolean reqSuccessFlag;

    public Boolean getReqSuccessFlag() {
        return reqSuccessFlag;
    }

    public void setReqSuccessFlag(Boolean reqSuccessFlag) {
        this.reqSuccessFlag = reqSuccessFlag;
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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FileStatus getStatus() {
        return status;
    }

    public void setStatus(FileStatus status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getSucceedCount() {
        return succeedCount;
    }

    public void setSucceedCount(Integer succeedCount) {
        this.succeedCount = succeedCount;
    }

    public BigDecimal getSucceedAmount() {
        return succeedAmount;
    }

    public void setSucceedAmount(BigDecimal succeedAmount) {
        this.succeedAmount = succeedAmount;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public static PayInfo retrive(String batchNo) throws PaymaxException {
        return request(PaymaxConfig.API_BASE_URL + PaymaxConfig.PAY_QUERY + "?batch_no=" + batchNo,
                null, PayInfo.class);
    }
}
