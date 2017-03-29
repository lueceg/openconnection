package com.gua.open.connection.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gua.open.connection.parameter.RequestParams;
import com.gua.open.connection.result.CommunicateResult;

/**
 * 类HttpCommunicateServiceTest.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月29日 上午12:28:16
 */
public class HttpCommunicateServiceTest {

    private static ApplicationContext applicationContext;
    
    static {
        applicationContext = new ClassPathXmlApplicationContext("service-beans.xml");
    }
    
    @Test
    public void testCommunicate() {
        HttpCommunicateService httpCommunicateService = applicationContext.getBean("httpCommunicateService", HttpCommunicateService.class);
        RequestParams requestParams = buildRequestParams();   
        CommunicateResult result = httpCommunicateService.communicate(requestParams);
        String data = null;
        if (null != result) {
           data = result.getData();
        }
        if (StringUtils.isBlank(data)) {
            System.out.println("data is blank!!!!");
        } else {
            System.err.println("data is : " + data);
        }
    }
    
    private RequestParams buildRequestParams() {
        RequestParams requestParams = new RequestParams();
        return requestParams;
    }
    
}
