package com.paymax.model;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by xiaowei.wang on 2016/4/26.
 */
public class PaymaxBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public PaymaxBase() {
    }

    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
