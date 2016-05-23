package io.cloudslang.content.openstack.entities.inputs;

import com.hp.oo.sdk.content.plugin.GlobalSessionObject;
import io.cloudslang.content.httpclient.HttpClientInputs;
import io.cloudslang.content.openstack.utils.StringUtils;

/**
 * Created by stcu on 23.05.2016.
 */
public class CommonInputs {
    public static final String APPLICATION_JSON = "application/json";
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

    public CommonInputs(CommonInputsBuilder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.protocol = builder.protocol;
        this.username = builder.username;
        this.password = builder.password;
        this.proxyHost = builder.proxyHost;
        this.proxyPort = builder.proxyPort;
        this.proxyUsername = builder.proxyUsername;
        this.proxyPassword = builder.proxyPassword;
        this.trustAllRoots = builder.trustAllRoots;
        this.x509HostnameVerifier = builder.x509HostnameVerifier;
        this.trustKeystore = builder.trustKeystore;
        this.trustPassword = builder.trustPassword;
        this.keystore = builder.keystore;
        this.keystorePassword = builder.keystorePassword;
        this.connectTimeout = builder.connectTimeout;
        this.socketTimeout = builder.socketTimeout;
        this.requestBody = builder.requestBody;
        this.requestMethod = builder.requestMethod;
        this.requestUri = builder.requestUri;
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

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
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

    public static class CommonInputsBuilder {
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

        public CommonInputs build() {
            return new CommonInputs(this);
        }

        public CommonInputsBuilder withHost(String host) throws Exception {
            this.host = StringUtils.toRequiredString(host, "");
            return this;
        }

        public CommonInputsBuilder withPort(String port) throws Exception {
            this.port = StringUtils.toString(port, "");
            return this;
        }

        public CommonInputsBuilder withProtocol(String protocol) throws Exception {
            this.protocol = StringUtils.toString(protocol, "");
            return this;
        }

        public CommonInputsBuilder withUsername(String username) throws Exception {
            this.username = StringUtils.toString(username, "");
            return this;
        }

        public CommonInputsBuilder withPassword(String password) throws Exception {
            this.password = StringUtils.toString(password, "");
            return this;
        }

        public CommonInputsBuilder withProxyHost(String proxyHost) throws Exception {
            this.proxyHost = StringUtils.toString(proxyHost, "");
            return this;
        }

        public CommonInputsBuilder withProxyPort(String proxyPort) throws Exception {
            this.proxyPort = StringUtils.toString(proxyPort, "");
            return this;
        }

        public CommonInputsBuilder withProxyUsername(String proxyUsername) throws Exception {
            this.proxyUsername = StringUtils.toString(proxyUsername, "");
            return this;
        }

        public CommonInputsBuilder withProxyPassword(String proxyPassword) throws Exception {
            this.proxyPassword = StringUtils.toString(proxyPassword, "");
            return this;
        }

        public CommonInputsBuilder withTrustAllRoots(String trustAllRoots) throws Exception {
            this.trustAllRoots = StringUtils.toString(trustAllRoots, "");
            return this;
        }

        public CommonInputsBuilder withX509HostnameVerifier(String x509HostnameVerifier) throws Exception {
            this.x509HostnameVerifier = StringUtils.toString(x509HostnameVerifier, "");
            return this;
        }

        public CommonInputsBuilder withTrustKeystore(String trustKeystore) throws Exception {
            this.trustKeystore = StringUtils.toString(trustKeystore, "");
            return this;
        }

        public CommonInputsBuilder withTrustPassword(String trustPassword) throws Exception {
            this.trustPassword = StringUtils.toString(trustPassword, "");
            return this;
        }

        public CommonInputsBuilder withKeystore(String keystore) throws Exception {
            this.keystore = StringUtils.toString(keystore, "");
            return this;
        }

        public CommonInputsBuilder withKeystorePassword(String keystorePassword) throws Exception {
            this.keystorePassword = StringUtils.toString(keystorePassword, "");
            return this;
        }

        public CommonInputsBuilder withConnectTimeout(String connectTimeout) throws Exception {
            this.connectTimeout = StringUtils.toString(connectTimeout, "");
            return this;
        }

        public CommonInputsBuilder withSocketTimeout(String socketTimeout) throws Exception {
            this.socketTimeout = StringUtils.toString(socketTimeout, "");
            return this;
        }

        public CommonInputsBuilder withRequestBody(String requestBody) throws Exception {
            this.requestBody = StringUtils.toString(requestBody, "");
            return this;
        }

        public CommonInputsBuilder withRequestMethod(String requestMethod) throws Exception {
            this.requestMethod = StringUtils.toString(requestMethod, "");
            return this;
        }

        public CommonInputsBuilder withRequestUri(String requestUri) throws Exception {
            this.requestUri = StringUtils.toString(requestUri, "");
            return this;
        }
    }

    public HttpClientInputs toClientInputs() {
        HttpClientInputs httpClientInputs = new HttpClientInputs();

        httpClientInputs.setUrl(getProtocol() + getHost() + ":" + getPort() + getRequestUri());
        httpClientInputs.setMethod(getRequestMethod());
        httpClientInputs.setContentType(APPLICATION_JSON);

        httpClientInputs.setProxyHost(getProxyHost());
        httpClientInputs.setProxyPort(getProxyPort());
        httpClientInputs.setProxyUsername(getProxyUsername());
        httpClientInputs.setProxyPassword(getProxyPassword());
        httpClientInputs.setBody(getRequestBody());

        if (org.apache.commons.lang3.StringUtils.isNotBlank(getTrustAllRoots())) {
            httpClientInputs.setTrustAllRoots(getTrustAllRoots());
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(getX509HostnameVerifier())) {
            httpClientInputs.setX509HostnameVerifier(getX509HostnameVerifier());
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(getTrustKeystore())) {
            httpClientInputs.setTrustKeystore(getTrustKeystore());
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(getTrustPassword())) {
            httpClientInputs.setTrustPassword(getTrustPassword());
        }

        httpClientInputs.setConnectionPoolSessionObject(new GlobalSessionObject());

        return httpClientInputs;
    }
}
