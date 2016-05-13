package io.cloudslang.content.openstack.utils;

import com.hp.oo.sdk.content.plugin.GlobalSessionObject;
import io.cloudslang.content.httpclient.HttpClientInputs;
import io.cloudslang.content.httpclient.ScoreHttpClient;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import org.apache.commons.lang3.StringUtils;

public class HttpClientUtils {
    public static final String APPLICATION_JSON = "application/json";

    private ScoreHttpClient scoreClient = new ScoreHttpClient();

    public HttpClientInputs initHttpClientInputs(HttpRequestWrapper wrapper) {

        HttpClientInputs httpClientInputs = new HttpClientInputs();

        httpClientInputs.setUrl(wrapper.getProtocol() + wrapper.getHost() + ":" + wrapper.getPort() + wrapper.getRequestUri());
        httpClientInputs.setMethod(wrapper.getRequestMethod());
        httpClientInputs.setContentType(APPLICATION_JSON);

        httpClientInputs.setProxyHost(wrapper.getProxyHost());
        httpClientInputs.setProxyPort(wrapper.getProxyPort());
        httpClientInputs.setProxyUsername(wrapper.getProxyUsername());
        httpClientInputs.setProxyPassword(wrapper.getProxyPassword());
        httpClientInputs.setBody(wrapper.getRequestBody());

        if (StringUtils.isNotBlank(wrapper.getTrustAllRoots())) {
            httpClientInputs.setTrustAllRoots(wrapper.getTrustAllRoots());
        }
        if (StringUtils.isNotBlank(wrapper.getX509HostnameVerifier())) {
            httpClientInputs.setX509HostnameVerifier(wrapper.getX509HostnameVerifier());
        }
        if (StringUtils.isNotBlank(wrapper.getTrustKeystore())) {
            httpClientInputs.setTrustKeystore(wrapper.getTrustKeystore());
        }
        if (StringUtils.isNotBlank(wrapper.getTrustPassword())) {
            httpClientInputs.setTrustPassword(wrapper.getTrustPassword());
        }

        httpClientInputs.setConnectionPoolSessionObject(new GlobalSessionObject());

        return httpClientInputs;
    }
}
