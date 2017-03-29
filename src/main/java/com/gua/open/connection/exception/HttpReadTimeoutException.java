package com.gua.open.connection.exception;

/**
 * 类HttpReadTimeoutException.java的实现描述：读取
 * 
 * @author weicheng.lwc 2017年3月28日 下午3:42:25
 */
@SuppressWarnings("serial")
public class HttpReadTimeoutException extends RuntimeException {

    public HttpReadTimeoutException(){
        super();
    }

    public HttpReadTimeoutException(String message, Throwable cause){
        super(message, cause);
    }

    public HttpReadTimeoutException(String message){
        super(message);
    }

    public HttpReadTimeoutException(Throwable cause){
        super(cause);
    }

}
