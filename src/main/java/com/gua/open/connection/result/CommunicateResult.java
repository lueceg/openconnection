package com.gua.open.connection.result;

/**
 * 类CommunicateResult.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月28日 下午2:43:57
 */
public class CommunicateResult {
    
    /**
     * 返回数据
     */
    private String data;

    /**
     * 异常描述
     */
    private String exceptionDescription;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

}
