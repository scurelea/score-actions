package io.cloudslang.content.openstack.actions;

import com.hp.oo.sdk.content.annotations.Action;
import com.hp.oo.sdk.content.annotations.Output;
import com.hp.oo.sdk.content.annotations.Param;
import com.hp.oo.sdk.content.annotations.Response;
import com.hp.oo.sdk.content.plugin.ActionMetadata.MatchType;
import com.hp.oo.sdk.content.plugin.ActionMetadata.ResponseType;
import io.cloudslang.content.openstack.constants.InputNames;
import io.cloudslang.content.openstack.constants.OutputNames;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import io.cloudslang.content.openstack.services.HttpRequestService;
import io.cloudslang.content.openstack.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class GetAuthToken {
    private final HttpRequestService httpRequestService = new HttpRequestService();

    @Action(
            name = "Get Authenticate Token",
            outputs = {
                    @Output(OutputNames.RETURN_RESULT),
                    @Output(OutputNames.RETURN_CODE),
                    @Output(OutputNames.EXCEPTION),
                    @Output(OutputNames.RESPONSE_BODY)
            },
            responses = {
                    @Response(text = OutputNames.SUCCESS,
                            field = OutputNames.RETURN_CODE,
                            value = OutputNames.RETURN_CODE_SUCCESS,
                            matchType = MatchType.COMPARE_EQUAL,
                            responseType = ResponseType.RESOLVED,
                            isDefault = true),
                    @Response(text = OutputNames.FAILURE,
                            field = OutputNames.RETURN_CODE,
                            value = OutputNames.RETURN_CODE_FAILURE,
                            matchType = MatchType.COMPARE_EQUAL,
                            responseType = ResponseType.ERROR,
                            isOnFail = true)
            }
    )
    public Map<String, String> execute(@Param(value = InputNames.HOST, required = true) String host,
                                            @Param(InputNames.PORT) String port,
                                            @Param(InputNames.PROTOCOL) String protocol,
                                            @Param(InputNames.USERNAME) String username,
                                            @Param(value = InputNames.PASSWORD, encrypted = true) String password,
                                            @Param(InputNames.PROXY_HOST) String proxyHost,
                                            @Param(InputNames.PROXY_PORT) String proxyPort,
                                            @Param(InputNames.PROXY_USERNAME) String proxyUsername,
                                            @Param(value = InputNames.PROXY_PASSWORD, encrypted = true) String proxyPassword,
                                            @Param(InputNames.TRUST_ALL_ROOTS) String trustAllRoots,
                                            @Param(InputNames.X509_HOSTNAME_VERIFIER) String x509HostnameVerifier,
                                            @Param(InputNames.TRUST_KEYSTORE) String trustKeystore,
                                            @Param(value = InputNames.TRUST_PASSWORD, encrypted = true) String trustPassword,
                                            @Param(InputNames.KEYSTORE) String keystore,
                                            @Param(value = InputNames.KEYSTORE_PASSWORD, encrypted = true) String keystorePassword,
                                            @Param(InputNames.CONNECT_TIMEOUT) String connectTimeout,
                                            @Param(InputNames.SOCKET_TIMEOUT) String socketTimeout,
                                            @Param(InputNames.REQUEST_BODY) String requestBody) {
        Map<String, String> resultMap = new HashMap<>();
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper();
        try {
            requestWrapper.setHost(StringUtils.toRequiredString(host, ""));
            requestWrapper.setPort(StringUtils.toString(port, ""));
            requestWrapper.setProtocol(StringUtils.toString(protocol, ""));
            requestWrapper.setUsername(StringUtils.toString(username, ""));
            requestWrapper.setPassword(StringUtils.toString(password, ""));
            requestWrapper.setProxyHost(StringUtils.toString(proxyHost, ""));
            requestWrapper.setProxyPort(StringUtils.toString(proxyPort, ""));
            requestWrapper.setProxyUsername(StringUtils.toString(proxyUsername, ""));
            requestWrapper.setProxyPassword(StringUtils.toString(proxyPassword, ""));
            requestWrapper.setTrustAllRoots(StringUtils.toString(trustAllRoots, ""));
            requestWrapper.setX509HostnameVerifier(StringUtils.toString(x509HostnameVerifier, ""));
            requestWrapper.setTrustKeystore(StringUtils.toString(trustKeystore, ""));
            requestWrapper.setTrustPassword(StringUtils.toString(trustPassword, ""));
            requestWrapper.setKeystore(StringUtils.toString(keystore, ""));
            requestWrapper.setKeystorePassword(StringUtils.toString(keystorePassword, ""));
            requestWrapper.setConnectTimeout(StringUtils.toString(connectTimeout, ""));
            requestWrapper.setSocketTimeout(StringUtils.toString(socketTimeout, ""));
            requestWrapper.setRequestBody(StringUtils.toString(requestBody, ""));
            requestWrapper.setRequestMethod("POST");
            requestWrapper.setRequestUri("/v2.0/tokens");

            resultMap = httpRequestService.getAuthToken(requestWrapper);
        } catch (Exception ex) {
            resultMap.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
            resultMap.put(OutputNames.RETURN_RESULT, ex.getMessage());
            resultMap.put(OutputNames.EXCEPTION, ex.getStackTrace().toString());
        }
        return resultMap;
    }
}
