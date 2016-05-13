package io.cloudslang.content.openstack.services;

import io.cloudslang.content.openstack.actions.GetAuthToken;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class HttpRequestServiceTest {
    GetAuthToken authToken = new GetAuthToken();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";
    private final String AUTH_TOKEN = "authToken";
    private final String TENANT_ID = "tenantId";

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

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("200", results.get(STATUS_CODE));
        assertFalse(results.get(AUTH_TOKEN).isEmpty());
        assertFalse(results.get(TENANT_ID).isEmpty());
    }

    @Test
    public void getAuthTokenFailed() {
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

        Map<String, String> results = authToken.execute(host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, null);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", results.get(RETURN_CODE));
        assertEquals("400", results.get(STATUS_CODE));
        assertNull(results.get(AUTH_TOKEN));
        assertNull(results.get(TENANT_ID));
    }
}
