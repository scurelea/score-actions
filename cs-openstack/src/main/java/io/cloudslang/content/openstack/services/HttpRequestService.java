package io.cloudslang.content.openstack.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cloudslang.content.httpclient.HttpClientInputs;
import io.cloudslang.content.httpclient.ScoreHttpClient;
import io.cloudslang.content.openstack.constants.OutputNames;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import io.cloudslang.content.openstack.entities.identity.Access;
import io.cloudslang.content.openstack.entities.storage.Volume;
import io.cloudslang.content.openstack.utils.HttpClientUtils;
import io.cloudslang.content.openstack.utils.StringUtils;
import io.cloudslang.content.openstack.utils.json.JsonParser;

import java.util.Map;

public class HttpRequestService {
    private final String JSON_OBJECT_ACCESS = "access";

    public Map<String, String> getAuthToken(HttpRequestWrapper requestWrapper) {
        Map<String, String> results = performRestCall(requestWrapper, null);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_200_SUCCESS_CODE)
                || results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_201_SUCCESS_CODE)) {
            String json = getJsonObject(results.get(OutputNames.RETURN_RESULT), JSON_OBJECT_ACCESS);
            Access access = JsonParser.fromJson(json, Access.class);

            results.put(OutputNames.AUTH_TOKEN, access.getToken().getId());
            results.put(OutputNames.TENANT_ID, access.getToken().getTenant().getId());
        } else {
            results.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
        }

        return results;
    }

    public Map<String, String> createVolume(HttpRequestWrapper requestWrapper, String token) {
        Map<String, String> results = performRestCall(requestWrapper, token);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_202_SUCCESS_CODE)) {
            String json = getJsonObject(results.get(OutputNames.RETURN_RESULT), "volume");
            Volume volume = JsonParser.fromJson(json, Volume.class);
            results.put(OutputNames.VOLUME_ID, volume.getId());
        } else {
            results.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
        }

        return results;
    }

    private Map<String, String> performRestCall(HttpRequestWrapper requestWrapper, String token) {
        ScoreHttpClient scoreClient = new ScoreHttpClient();
        HttpClientInputs inputs = new HttpClientUtils().initHttpClientInputs(requestWrapper);

        if (StringUtils.isNotBlank(token)) {
            inputs.setHeaders("X-Auth-Token:" + token);
        }

        return scoreClient.execute(inputs);
    }

    /**
     * Get an json Object by name from json.
     * @param json json string
     * @param name name of the json object
     * @return the json
     */
    private String getJsonObject(String json, String name) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (json, JsonElement.class);
        JsonObject object = element.getAsJsonObject().getAsJsonObject(name);
        return object.toString();
    }
}