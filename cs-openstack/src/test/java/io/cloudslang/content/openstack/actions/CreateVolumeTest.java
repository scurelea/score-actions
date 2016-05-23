package io.cloudslang.content.openstack.actions;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by stcu on 20.05.2016.
 */
public class CreateVolumeTest {
    GetAuthToken authToken = new GetAuthToken();
    CreateVolume volume = new CreateVolume();
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

        port = "8776";
        String requestBody = "{\n" +
                "    \"volume\": {\n" +
                "        \"size\": 1,\n" +
                "        \"availability_zone\": null,\n" +
                "        \"source_volid\": null,\n" +
                "        \"description\": null,\n" +
                "        \"multiattach \": false,\n" +
                "        \"snapshot_id\": null,\n" +
                "        \"name\": null,\n" +
                "        \"imageRef\": null,\n" +
                "        \"volume_type\": null,\n" +
                "        \"metadata\": {},\n" +
                "        \"source_replica\": null,\n" +
                "        \"consistencygroup_id\": null\n" +
                "    }\n" +
                "}\n";

        Map<String, String> volumeRes = volume.execute(host, port, null, null, null, null, null,
                null, null, trustAllRoots, null, null, null, null, null, null, null, requestBody,
                results.get(TENANT_ID), results.get(AUTH_TOKEN));
    }
}
