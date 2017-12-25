package com.paymax.model.event;

import com.paymax.model.Charge;
import com.paymax.model.Refund;

/**
 * @author wangoo
 * @since 2017-11-28 10:31
 */
public enum PaymaxEventType {

    CHARGE(Charge.class), REFUND(Refund.class);

    private Class objectType;

    public Class getObjectType() {
        return objectType;
    }

    PaymaxEventType(Class objectType) {
        this.objectType = objectType;
    }
}
