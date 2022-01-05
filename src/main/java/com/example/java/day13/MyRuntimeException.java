package com.example.java.day13;

/**
 * @Author: zhaojie
 * @Date: 2021/12/27 15:55
 * @Version: 1.0
 * @Description:
 */
public class MyRuntimeException extends RuntimeException{

    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRuntimeException(Throwable cause) {
        super(cause);
    }

    public MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
