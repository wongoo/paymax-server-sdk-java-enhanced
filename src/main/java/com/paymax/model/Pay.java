package com.paymax.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wxw on 2016/12/27.
 */
public class Pay extends PaymaxBase {
    /**
     * 批次号
     */
    @JSONField(name = "batch_no")
    private String batchNo;
    /**
     * 交易总笔数
     */
    @JSONField(name = "count")
    private int count;
    /**
     * 交易总金额
     */
    @JSONField(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 代付日期
     */
    @JSONField(name = "date")
    private String date;

    /**
     * 交易信息列表
     */
    private List<Trade> details;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Trade> getDetails() {
        return details;
    }

    public void setDetails(List<Trade> details) {
        this.details = details;
    }
}
