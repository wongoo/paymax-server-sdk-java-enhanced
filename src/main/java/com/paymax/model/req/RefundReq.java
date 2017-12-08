package com.paymax.model.req;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author wangoo
 * @since 2017-12-07 14:53
 */
public class RefundReq {

    private BigDecimal amount;

    private String description;

    private Map<String, Object> extra;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
