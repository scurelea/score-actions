package io.cloudslang.content.openstack.actions;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by cadm on 5/19/2016.
 */
public class CreateNetworkTest {

    CreateNetwork createNetwork = new CreateNetwork();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";

    @Test
    public void createNetworkValid() {

        String token = "528ef256f59a4c0e93669207b502f748";
        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String port = "9696";
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
                "    \"network\": {\n" +
                "        \"admin_state_up\": true\n" +
                "    }\n" +
                "}";

        Map<String, String> results = createNetwork.execute(token, host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, requestBody);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("201", results.get(STATUS_CODE));
        int x = 5;
        x++;
    }
}
