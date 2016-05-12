package io.cloudslang.content.openstack.services;

import io.cloudslang.content.openstack.actions.GetAuthToken;
import org.junit.Test;

import java.util.Map;

/**
 * Created by stcu on 12.05.2016.
 */
public class HttpRequestServiceTest {
    GetAuthToken authToken = new GetAuthToken();

    @Test
    public void getAuthTokenValid() {
        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String port = "5000";
        String protocol = "";
        String username = "";
        String password = "";
        String proxyHost = "";
        String proxyPort = "";
        String proxyUsername = "";
        String proxyPassword = "";
        String trustAllRoots = "true";
        String x509HostnameVerifier = "";
        String trustKeystore = "";
        String trustPassword = "";
        String keystore = "";
        String keystorePassword = "";
        String connectTimeout = "";
        String socketTimeout = "";
        String requestBody = "{\n" +
                "    \"auth\": {\n" +
                "        \"tenantName\": \"admin\",\n" +
                "        \"passwordCredentials\": {\n" +
                "            \"username\": \"admin\",\n" +
                "            \"password\": \"B33f34t3r\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Map<String, String> results = authToken.execute(host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, requestBody);
    }
}
