package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by wxw on 2016/12/29.
 */
public class PayUpload extends Paymax {
    /**
     * 批次号
     * 商户上传的批次号
     */
    @JSONField(name = "batch_no")
    private String batchNo;

    /**
     * 文件id
     * 每一此批量代付在“代收付”系统中都会有一个唯一文件id
     */
    @JSONField(name = "file_id")
    private String fileId;
    /**
     * 错误码
     */
    @JSONField(name="failure_code")
    private String failureCode;
    /**
     * 错误信息
     */
    @JSONField(name="failure_msg")
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

}
