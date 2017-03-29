package com.gua.open.connection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gua.open.connection.communication.DataSource;
import com.gua.open.connection.expression.ExpressionGenerator;
import com.gua.open.connection.parameter.RequestParams;
import com.gua.open.connection.result.CommunicateResult;

/**
 * 类HttpCommunicateServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月28日 下午11:49:08
 */
@Service("httpCommunicateService")
public class HttpCommunicateServiceImpl implements HttpCommunicateService {

    private final static Logger logger = LoggerFactory.getLogger(HttpCommunicateServiceImpl.class);
    
    @Autowired
    private ExpressionGenerator httpExpressionGenerator;

    @Autowired
    private DataSource          httpDataSource;

    @Override
    public CommunicateResult communicate(RequestParams requestParams) {
        CommunicateResult result = null;
        if (null == requestParams) {
            return result;
        }
        try {
            String expression = httpExpressionGenerator.genetate(requestParams);
            result = httpDataSource.communicate(expression);
        } catch (Exception e) {
            logger.error("Oops! communicate failed! " + e.getMessage(), e);
        }
        
        return result;
    }

}
