package io.cloudslang.content.openstack.actions;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class GetAuthTokenTest {
    GetAuthToken authToken = new GetAuthToken();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";
    private final String STATUS_CODE = "statusCode";
    private final String AUTH_TOKEN = "authToken";
    private final String TENANT_ID = "tenantId";

    private final String USERNAME = "admin";
    private final String PASSWORD = "B33f34t3r";

    @Test
    public void getAuthTokenValid() {
        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String port = "5000";
        String trustAllRoots = "true";
        Map<String, String> results = authToken.execute(host, port, null, USERNAME, PASSWORD, null, null,
                null, null, trustAllRoots, null, null, null,
                null, null, null, null, null, USERNAME, null);

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
        String trustAllRoots = "true";

        Map<String, String> results = authToken.execute(host, port, null, USERNAME, PASSWORD, null, null,
                null, null, trustAllRoots, null, null, null,
                null, null, null, null, null, "admins", null);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", results.get(RETURN_CODE));
        assertEquals("401", results.get(STATUS_CODE));
        assertNull(results.get(AUTH_TOKEN));
        assertNull(results.get(TENANT_ID));
    }

    @Test
    public void authPortInvalid() {
        String host = "https://stack-9161.hpswlabs.adapps.hp.com";
        String port = "5001";
        String trustAllRoots = "true";

        Map<String, String> results = authToken.execute(host, port, null, USERNAME, PASSWORD, null, null,
                null, null, trustAllRoots, null, null, null,
                null, null, null, null, null, USERNAME, null);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", results.get(RETURN_CODE));
        assertNull(results.get(AUTH_TOKEN));
        assertNull(results.get(TENANT_ID));
    }

    @Test
    public void authHostInvalid() {
        String host = "https://stack-9161.hpswlabs.com";
        String port = "5000";
        String trustAllRoots = "true";

        Map<String, String> results = authToken.execute(host, port, null, USERNAME, PASSWORD, null, null,
                null, null, trustAllRoots, null, null, null,
                null, null, null, null, null, USERNAME, null);

        assertFalse(results.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", results.get(RETURN_CODE));
        assertNull(results.get(AUTH_TOKEN));
        assertNull(results.get(TENANT_ID));
    }


}
