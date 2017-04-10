package com.gua.open.connection.communication;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gua.open.connection.constants.UserInfoConstants;
import com.gua.open.connection.exception.HttpExceptionEnum;
import com.gua.open.connection.result.CommunicateResult;

/**
 * 类HttpDataSource.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年3月28日 下午3:48:37
 */
@Service
public class HttpDataSource implements DataSource, InitializingBean {

    private final static Logger logger     = LoggerFactory.getLogger(HttpDataSource.class);

    private final static String HTTP       = "http://";

    private final static String COLON_MARK = ":";
    
    private final static String DEFAULT_CHARSET = "GBK";

    /**
     * HTTP核心配置信息
     */
    @Autowired
    private HttpConfiguration   httpConfiguration;

    private RequestConfig       requestConfig;

    private HttpClient          httpClient;

    @Override
    public CommunicateResult communicate(String expression) {

        String url = buildRequestUrl(expression);
        if (logger.isInfoEnabled()) {
            logger.info(url);
        }
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CommunicateResult communicateResult = new CommunicateResult();
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (null != response && null != response.getStatusLine()
                && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    String data = EntityUtils.toString(entity, DEFAULT_CHARSET);
                    communicateResult.setData(data);
                }
            }
        } catch (IOException e) {
            if (e instanceof ConnectTimeoutException) {
                communicateResult.setExceptionDescription(HttpExceptionEnum.CONNECTION_TIME_OUT.getDescription());
                logger.error(url, e);
            } else if (e instanceof InterruptedIOException) {
                communicateResult.setExceptionDescription(HttpExceptionEnum.DEAL_FAILED.getDescription());
                logger.error(url, e);
            } else {
                communicateResult.setExceptionDescription(HttpExceptionEnum.OTHER.getDescription());
                logger.error(url, e);
            }
        } finally {
            if (null != response && response instanceof Closeable) {
                try {
                    ((Closeable) response).close();
                } catch (IOException e) {
                    logger.error(url, HttpExceptionEnum.OTHER.getDescription());
                }
            }
        }

        return communicateResult;
    }

    private String buildRequestUrl(String expression) {
        StringBuilder urlbuilder = new StringBuilder(HTTP);
        urlbuilder.append(httpConfiguration.getHost());
        if (null != httpConfiguration.getPort()) {
            urlbuilder.append(COLON_MARK).append(httpConfiguration.getPort());
        }
        if (StringUtils.isNotBlank(httpConfiguration.getUrlPath())) {
            urlbuilder.append(httpConfiguration.getUrlPath());
        }
        if (StringUtils.isNotBlank(expression)) {
            urlbuilder.append(expression);
        }
        return urlbuilder.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.requestConfig = RequestConfig.custom().setConnectionRequestTimeout(httpConfiguration.getConnectionRequestTimeout()).setConnectTimeout(httpConfiguration.getConnectTimeout()).setSocketTimeout(httpConfiguration.getSocketTimeout()).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(httpConfiguration.getMaxConnections());
        HttpHost httpHost = new HttpHost(httpConfiguration.getHost(), httpConfiguration.getPort());
        cm.setMaxPerRoute(new HttpRoute(httpHost), httpConfiguration.getMaxConnections());
        
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(cm);
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(1, false));
        httpClientBuilder.setUserAgent(UserInfoConstants.USER_AGENT);
        this.httpClient = httpClientBuilder.build();
    }

}
