package com.paymax.exception;

import com.paymax.model.PaymaxFailureMessage;

/**
 * Created by xiaowei.wang on 2016/4/26.
 */
public class PaymaxException extends Exception {

    public static final String SERVER_ERROR_CODE = "SERVER_ERROR";

    private String code = SERVER_ERROR_CODE;

    public String getCode() {
        return code;
    }

    public PaymaxException() {
        super();
    }

    public PaymaxException(Throwable th) {
        super(th);
    }

    public PaymaxException(String msg) {
        super(msg);
    }

    public PaymaxException(String msg, Throwable th) {
        super(msg, th);
    }

    public PaymaxException(String code, String msg) {
        this(msg);
        this.code = code;
    }

    public PaymaxException(String code, String msg, Throwable th) {
        this(msg, th);
        this.code = code;
    }

    public static void throwExceptionWhenFailure(PaymaxFailureMessage failureMessage)
            throws PaymaxException {
        if (failureMessage != null) {
            String failureCode = failureMessage.getFailureCode();
            if (failureCode != null && failureCode.trim().length() > 0) {
                throw new PaymaxException(failureCode, failureMessage.getFailureMsg());
            }
        }
    }
}
