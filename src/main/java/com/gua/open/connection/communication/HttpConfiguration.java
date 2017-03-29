package com.gua.open.connection.communication;

/**
 * 类HttpConfiguration.java的实现描述：Http请求使用方需要关心的配置信息
 * 
 * @author weicheng.lwc 2017年3月28日 下午7:29:00
 */
public class HttpConfiguration {

    private String  host;

    private Integer port;

    /**
     * URL路径，scheme://hostname:port/path中的/path部分
     */
    private String  urlPath;

    /**
     * 连接池内最大连接数
     */
    private Integer maxConnections;

    /**
     * 从连接池获取连接的时限
     */
    private Integer connectionRequestTimeout;

    /**
     * 建立连接的时限
     */
    private Integer connectTimeout;

    /**
     * 读取数据的时限
     */
    private Integer socketTimeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

}
