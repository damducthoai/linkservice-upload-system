package com.butchjgo.linkservice.uploadsystem.exception;

public class BadParams extends RuntimeException {
    public BadParams() {
        super();
    }

    public BadParams(String message) {
        super(message);
    }

    public BadParams(String message, Throwable cause) {
        super(message, cause);
    }

    public BadParams(Throwable cause) {
        super(cause);
    }

    protected BadParams(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
