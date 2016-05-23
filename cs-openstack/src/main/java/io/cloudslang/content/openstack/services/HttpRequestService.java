package io.cloudslang.content.openstack.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cloudslang.content.httpclient.ScoreHttpClient;
import io.cloudslang.content.openstack.constants.OutputNames;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import io.cloudslang.content.openstack.entities.identity.Access;
import io.cloudslang.content.openstack.utils.HttpClientUtils;
import io.cloudslang.content.openstack.utils.json.JsonParser;

import java.util.Map;

public class HttpRequestService {
    private final String JSON_OBJECT_ACCESS = "access";

    public Map<String, String> getAuthToken(HttpRequestWrapper requestWrapper) {
        Map<String, String> results = performRestCall(requestWrapper);

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

    private Map<String, String> performRestCall(HttpRequestWrapper requestWrapper) {
        ScoreHttpClient scoreClient = new ScoreHttpClient();
        return scoreClient.execute(new HttpClientUtils().initHttpClientInputs(requestWrapper));
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