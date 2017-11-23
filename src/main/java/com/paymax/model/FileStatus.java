package com.paymax.model;

/**
 * Created by wxw on 2016/12/29.
 */
public enum FileStatus {

    /**
     * 商户已提交
     */
    APPLYING,

    /**
     * 渠道已受理
     */
    ACCEPTED,

    /**
     * 渠道受理失败
     */
    ACCEPT_FAILED,

    /**
     * 银行已受理
     */
    PROCESSING,

    /**
     * 交易成功
     */
    SUCCEED,

    /**
     * 部分成功
     */
    PARTIAL_SUCCEED,

    /**
     * 代付失败
     */
    FAILED;
}
