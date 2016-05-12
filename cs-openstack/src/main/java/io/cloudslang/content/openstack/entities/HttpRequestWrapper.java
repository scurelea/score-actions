package io.cloudslang.content.openstack.entities;

import com.hp.oo.sdk.content.plugin.GlobalSessionObject;
import io.cloudslang.content.httpclient.HttpClientInputs;
import org.apache.commons.lang3.StringUtils;

public class HttpRequestWrapper {
    private final String APPLICATION_JSON = "application/json";
    private String host;
    private String port;
    private String protocol;
    private String username;
    private String password;
    private String proxyHost;
    private String proxyPort;
    private String proxyUsername;
    private String proxyPassword;
    private String trustAllRoots;
    private String x509HostnameVerifier;
    private String trustKeystore;
    private String trustPassword;
    private String keystore;
    private String keystorePassword;
    private String connectTimeout;
    private String socketTimeout;
    private String requestBody;
    private String requestMethod;
    private String requestUri;

    public HttpRequestWrapper() {
    }

    public HttpRequestWrapper(String host, String port, String protocol, String username, String password, String proxyHost, String proxyPort, String proxyUsername, String proxyPassword, String trustAllRoots, String x509HostnameVerifier, String trustKeystore, String trustPassword, String keystore, String keystorePassword, String connectTimeout, String socketTimeout, String requestBody, String requestMethod, String requestUri) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
        this.username = username;
        this.password = password;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyUsername = proxyUsername;
        this.proxyPassword = proxyPassword;
        this.trustAllRoots = trustAllRoots;
        this.x509HostnameVerifier = x509HostnameVerifier;
        this.trustKeystore = trustKeystore;
        this.trustPassword = trustPassword;
        this.keystore = keystore;
        this.keystorePassword = keystorePassword;
        this.connectTimeout = connectTimeout;
        this.socketTimeout = socketTimeout;
        this.requestBody = requestBody;
        this.requestMethod = requestMethod;
        this.requestUri = requestUri;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getTrustAllRoots() {
        return trustAllRoots;
    }

    public void setTrustAllRoots(String trustAllRoots) {
        this.trustAllRoots = trustAllRoots;
    }

    public String getX509HostnameVerifier() {
        return x509HostnameVerifier;
    }

    public void setX509HostnameVerifier(String x509HostnameVerifier) {
        this.x509HostnameVerifier = x509HostnameVerifier;
    }

    public String getTrustKeystore() {
        return trustKeystore;
    }

    public void setTrustKeystore(String trustKeystore) {
        this.trustKeystore = trustKeystore;
    }

    public String getTrustPassword() {
        return trustPassword;
    }

    public void setTrustPassword(String trustPassword) {
        this.trustPassword = trustPassword;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public HttpClientInputs parseToInputs() {
        HttpClientInputs httpClientInputs = new HttpClientInputs();

        httpClientInputs.setUrl(getProtocol() + getHost() + ":" + getPort() + getRequestUri());
        httpClientInputs.setMethod(getRequestMethod());
        httpClientInputs.setContentType(APPLICATION_JSON);
        httpClientInputs.setProxyHost(getProxyHost());
        httpClientInputs.setProxyPort(getProxyPort());
        httpClientInputs.setProxyUsername(getProxyUsername());
        httpClientInputs.setProxyPassword(getProxyPassword());
        httpClientInputs.setBody(getRequestBody());

        if (StringUtils.isNotBlank(getTrustAllRoots())) {
            httpClientInputs.setTrustAllRoots(getTrustAllRoots());
        }
        if (StringUtils.isNotBlank(getX509HostnameVerifier())) {
            httpClientInputs.setX509HostnameVerifier(getX509HostnameVerifier());
        }
        if (StringUtils.isNotBlank(getTrustKeystore())) {
            httpClientInputs.setTrustKeystore(getTrustKeystore());
        }
        if (StringUtils.isNotBlank(getTrustPassword())) {
            httpClientInputs.setTrustPassword(getTrustPassword());
        }

        httpClientInputs.setConnectionPoolSessionObject(new GlobalSessionObject());

        return httpClientInputs;
    }
}
