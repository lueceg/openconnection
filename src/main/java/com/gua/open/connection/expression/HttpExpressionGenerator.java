package com.gua.open.connection.expression;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private final static Logger logger = LoggerFactory.getLogger(HttpExpressionGenerator.class);

    private final static String QUESTION_MARK = "?";
    private final static String AND_MARK      = "&";
    private final static String EQUAL_MARK    = "=";

    @Override
    public String genetate(RequestParams requestParams) {

        if (null == requestParams || (CollectionUtils.isEmpty(requestParams.getNameValuePairs()) && StringUtils.isBlank(requestParams.getExtraParams()))) {
            return null;
        }

        StringBuilder expressionBuilder = new StringBuilder(QUESTION_MARK);
        List<NameValuePair> nameValuePairs = requestParams.getNameValuePairs();
        for (NameValuePair pair : nameValuePairs) {
            String encodeValue = encodeValue(pair.getValue());
            if (StringUtils.isNotBlank(encodeValue)) {
                expressionBuilder.append(AND_MARK).append(pair.getName()).append(EQUAL_MARK).append(encodeValue);

            }
        }
        if (StringUtils.isNotBlank(requestParams.getExtraParams())) {
            expressionBuilder.append(AND_MARK).append(requestParams.getExtraParams());
        }
        
        return expressionBuilder.toString();
    }
    
    private String encodeValue(String value) {
        String encodeValue = null;
        try {
            encodeValue = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("encode failed, is " + value, e);
        }
        return encodeValue;
    }

}
