package com.paymax.exception;

/**
 * @author wangoo
 * @date 2017-11-23
 */
public class PaymaxFatalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PaymaxFatalException() {
        super();
    }

    public PaymaxFatalException(String msg) {
        super(msg);
    }

    public PaymaxFatalException(String msg, Throwable th) {
        super(msg, th);
    }

    public PaymaxFatalException(Throwable th) {
        super(th);
    }
}
