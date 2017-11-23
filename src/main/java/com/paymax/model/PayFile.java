package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by wxw on 2016/12/28.
 */
public class PayFile extends PaymaxBase  {
    private String fileName;
    private byte[] fileData;
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
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
