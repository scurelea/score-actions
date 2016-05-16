package io.cloudslang.content.openstack.services;

import io.cloudslang.content.openstack.actions.ListNetworks;
import org.junit.Test;

import java.util.Map;

/**
 * Created by cadm on 5/13/2016.
 */
public class ListNetworksTest {

    ListNetworks listNtws = new ListNetworks();


    @Test
    public void getNetworksList() {

        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String token = "f254fa31d6e04d548acf74c49ea721a5";
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

        Map<String, String> results = listNtws.execute(host, token, port, protocol, username, password, proxyHost, proxyPort,
                proxyUsername, proxyPassword, trustAllRoots, x509HostnameVerifier, trustKeystore, trustPassword,
                keystore, keystorePassword, connectTimeout, socketTimeout, requestBody);
    }
}
