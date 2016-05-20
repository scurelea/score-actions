package io.cloudslang.content.openstack.actions;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by cadm on 5/20/2016.
 */
public class DeleteNetworkTest {

    DeleteNetwork deleteNetwork = new DeleteNetwork();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";

    @Test
    public void deleteNetworkValid() {

        String token = "554cc2d1103e4ac28241d7fbc090aa6d";
        String networkId = "3306aa05-bb92-4787-8de9-225b28a06649";
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
        String requestBody = "";

        Map<String, String> results = deleteNetwork.execute(token, networkId, host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, requestBody);

        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("204", results.get(STATUS_CODE));
    }
}
