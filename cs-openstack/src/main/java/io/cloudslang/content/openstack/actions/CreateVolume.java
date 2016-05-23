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

/**
 * Created by stcu on 20.05.2016.
 */
public class CreateVolume {
    private final HttpRequestService httpRequestService = new HttpRequestService();

    /**
     * Authenticates against a keystone identity service and returns an authentication token and a list of
     * endpoints available to the specified user. This flow should handle authentication.
     * @param host                      The OpenStack machine host.
     * @param port                      The port used for OpenStack authentication - Default: '5000'.
     * @param protocol                  The https or http protocol.
     * @param username                  The user name used for URL authentication. For NTLM authentication, the
     *                                  required format is 'domain\\user'.
     * @param password                  The password used for URL authentication.
     * @param proxyHost                 The proxy server used to access the web site.
     * @param proxyPort                 The proxy server port.
     * @param proxyUsername             The proxy server user name.
     * @param proxyPassword             The proxy server password associated with the <proxyUsername> input value.
     * @param trustAllRoots             Specifies whether to enable weak security over SSL. A SSL certificate is
     *                                  trusted even if no trusted certification authority issued it.
     * @param x509HostnameVerifier      Specifies the way the server hostname must match a domain name in the subject's
     *                                  Common Name (CN) or subjectAltName field of the X.509 certificate. The hostname
     *                                  verification system prevents communication with other hosts other than the ones
     *                                  you intended. This is done by checking that the hostname is in the subject
     *                                  alternative name extension of the certificate. This system is designed to ensure
     *                                  that, if an attacker(Man In The Middle) redirects traffic to his machine, the
     *                                  client will not accept the connection. If you set this input to "allow_all",
     *                                  this verification is ignored and you become vulnerable to security attacks.
     *                                  For the value "browser_compatible" the hostname verifier works the same way as
     *                                  Curl and Firefox. The hostname must match either the first CN, or any of the
     *                                  subject-alts. A wildcard can occur in the CN, and in any of the subject-alts.
     *                                  The only difference between "browser_compatible" and "strict" is that a wildcard
     *                                  (such as "*.foo.com") with "browser_compatible" matches all subdomains,
     *                                  including "a.b.foo.com". From the security perspective, to provide protection
     *                                  against possible Man-In-The-Middle attacks, we strongly recommend to use
     *                                  "strict" option.
     * @param trustKeystore             The location of the TrustStore file - a URL or the local path to it. This
     *                                  input is empty if no HTTPS server authentication is used. The default value
     *                                  will be provided if trustAllRoots is false.
     * @param trustPassword             The password associated with the TrustStore file.  If trustAllRoots is
     *                                  false and trustKeystore is empty, trustPassword default will be supplied.
     * @param keystore                  The location of the KeyStore file - a URL or the local path to it. This
     *                                  input is empty if no HTTPS client authentication is used. The default
     *                                  value will be provided if trustAllRoots is false.
     * @param keystorePassword          The password associated with the KeyStore file. If trustAllRoots is
     *                                  false and keystore is empty, keystorePassword default will be supplied.
     * @param connectTimeout            The time to wait for a connection to be established, in  milliseconds.
     *                                  This input needs a value greater than or equal to zero.
     * @param socketTimeout             The time to wait for data to be retrieved, in milliseconds. This input needs
     *                                  a value greater than or equal to zero.
     * @param requestBody
     * @return
     */
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
                                       @Param(InputNames.REQUEST_BODY) String requestBody,
                                       @Param(value = InputNames.TENANT_ID, required = true) String tenantId,
                                       @Param(value = InputNames.TOKEN_ID, required = true) String tokenId) {
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
            requestWrapper.setRequestUri("/v2/" + StringUtils.toString(tenantId, "") + "/volumes");

            resultMap = httpRequestService.createVolume(requestWrapper, tokenId);
        } catch (Exception ex) {
            resultMap.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
            resultMap.put(OutputNames.RETURN_RESULT, ex.getMessage());
            resultMap.put(OutputNames.EXCEPTION, ex.getStackTrace().toString());
        }
        return resultMap;
    }
}