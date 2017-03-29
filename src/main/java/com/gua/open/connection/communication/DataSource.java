package com.gua.open.connection.communication;

import com.gua.open.connection.result.CommunicateResult;

/**
 * 类DataSource.java的实现描述：
 * 
 * @author weicheng.lwc 2017年3月28日 下午3:46:07
 */
public interface DataSource {

    /**
     * 请求获取数据
     * 
     * @param expression
     * @return
     */
    public CommunicateResult communicate(String expression);

}
