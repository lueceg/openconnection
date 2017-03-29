package com.gua.open.connection.service;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.open.connection.result.CommunicateResult;

/**
 * 类HttpCommunicateService.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月28日 下午11:45:52
 */
public interface HttpCommunicateService {

    public CommunicateResult communicate(RequestParams requestParams);

}
