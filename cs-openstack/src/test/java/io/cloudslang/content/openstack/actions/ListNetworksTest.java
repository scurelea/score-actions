package io.cloudslang.content.openstack.services;

import io.cloudslang.content.openstack.actions.ListNetworks;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by cadm on 5/13/2016.
 */
public class ListNetworksTest {

    ListNetworks listNetworks = new ListNetworks();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";
    private final String AUTH_TOKEN = "authToken";
    private final String TENANT_ID = "tenantId";


    @Test
    public void getNetworksListValid() {

        String token = "2d15749446b042689ccbf6145ef9cd96";
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

        Map<String, String> results = listNetworks.execute(token, host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("0", results.get(RETURN_CODE));
        assertEquals("200", results.get(STATUS_CODE));
    }

    @Test
    public void getNetworksListInvalidToken() {

        String token = "abc";
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

        Map<String, String> results = listNetworks.execute(token, host, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", results.get(RETURN_CODE));
        assertEquals("401", results.get(STATUS_CODE));
    }
}
