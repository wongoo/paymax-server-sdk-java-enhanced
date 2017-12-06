package com.paymax.model;

/**
 * 实时交易订单状态
 * Created by wxw on 2017/3/15.
 */
public enum OrderStatus {
    /**
     * 交易成功
     */
    SUCCEED,

    /**
     * 处理中
     */
    PROCESSING,

    /**
     * 处理中转结算
     */
    PROCESSING_SETTLEMENT,

    /**
     * 处理中转退款
     */
    PROCESSING_REFUND,

    /**
     * 处理中转失败
     */
    PROCESSING_FAILED,

    /**
     * 交易失败
     */
    FAILED;
}
