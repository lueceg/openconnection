package com.gua.open.connection.parameter;

import java.util.List;

import org.apache.http.NameValuePair;

/**
 * 类RequestParams.java的实现描述：请求参数
 * 
 * @author weicheng.lwc 2017年3月28日 下午10:40:14
 */
public class RequestParams {

    /**
     * 请求参数键值对
     */
    private List<NameValuePair> nameValuePairs;

    /**
     * 请求的额外参数
     */
    private String              extraParams;

    public List<NameValuePair> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(List<NameValuePair> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public String getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String extraParams) {
        this.extraParams = extraParams;
    }

}
