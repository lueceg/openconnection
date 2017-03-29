package com.gua.open.connection.expression;

import java.util.List;

import org.apache.http.NameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gua.open.connection.parameter.RequestParams;

/**
 * 类HttpExpressionGenerator.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月28日 下午11:18:31
 */
@Service
public class HttpExpressionGenerator implements ExpressionGenerator {

    private final static String QUESTION_MARK = "?";
    private final static String AND_MARK      = "&";
    private final static String EQUAL_MARK    = "=";

    @Override
    public String genetate(RequestParams requestParams) {

        if (null == requestParams || CollectionUtils.isEmpty(requestParams.getNameValuePairs())) {
            return null;
        }

        StringBuilder expressionBuilder = new StringBuilder(QUESTION_MARK);
        List<NameValuePair> nameValuePairs = requestParams.getNameValuePairs();
        for (NameValuePair pair : nameValuePairs) {
            expressionBuilder.append(AND_MARK).append(pair.getName()).append(EQUAL_MARK).append(pair.getValue());
        }
        
        return expressionBuilder.toString();
    }

}
