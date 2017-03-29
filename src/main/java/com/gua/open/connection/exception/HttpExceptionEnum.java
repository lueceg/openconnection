package com.gua.open.connection.exception;

/**
 * 类HttpExceptionEnum.java的实现描述：连接常见异常描述类
 * 
 * @author weicheng.lwc 2017年3月28日 下午2:51:23
 */
public enum HttpExceptionEnum {

                               CONNECTION_TIME_OUT("connection_time_out"), DEAL_FAILED("deal_failed"), OTHER("other");

    private String description;

    private HttpExceptionEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
