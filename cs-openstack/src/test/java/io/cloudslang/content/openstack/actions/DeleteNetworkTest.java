package io.cloudslang.content.openstack.actions;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by cadm on 5/20/2016.
 */
public class DeleteNetworkTest {

    GetAuthToken authToken = new GetAuthToken();
    DeleteNetwork deleteNetwork = new DeleteNetwork();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";
    private final String AUTH_TOKEN = "authToken";

    @Test
    public void deleteNetworkValid() {

        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String idPort = "5000";
        String deletePort = "9696";
        String trustAllRoots = "true";
        String requestBody = "{\n" +
                "    \"auth\": {\n" +
                "        \"tenantName\": \"admin\",\n" +
                "        \"passwordCredentials\": {\n" +
                "            \"username\": \"admin\",\n" +
                "            \"password\": \"B33f34t3r\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        // obtain the token first
        Map<String, String> results = authToken.execute(
                host, idPort,
                null, null, null, null, null, null, null, trustAllRoots, null, null, null,
                null, null, null, null, requestBody);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("200", results.get(STATUS_CODE));
        String token = results.get(AUTH_TOKEN);
        assertFalse(token.isEmpty());

        String networkId = "bd12b6ff-5bb9-4a02-837e-92f0c2368e1c";
        String protocol = "";
        String username = "";
        String password = "";
        String proxyHost = "";
        String proxyPort = "";
        String proxyUsername = "";
        String proxyPassword = "";
        String x509HostnameVerifier = "";
        String trustKeystore = "";
        String trustPassword = "";
        String keystore = "";
        String keystorePassword = "";
        String connectTimeout = "";
        String socketTimeout = "";
        requestBody = "";

        results = deleteNetwork.execute(token, networkId, host, deletePort, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, requestBody);

        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("204", results.get(STATUS_CODE));
    }
}
