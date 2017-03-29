package com.gua.open.connection.exception;

/**
 * 类HttpConnectionTimeoutException.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月28日 下午3:38:07
 */
@SuppressWarnings("serial")
public class HttpConnectionTimeoutException extends RuntimeException {

    public HttpConnectionTimeoutException(){
        super();
    }

    public HttpConnectionTimeoutException(String message, Throwable cause){
        super(message, cause);
    }

    public HttpConnectionTimeoutException(String message){
        super(message);
    }

    public HttpConnectionTimeoutException(Throwable cause){
        super(cause);
    }

}
