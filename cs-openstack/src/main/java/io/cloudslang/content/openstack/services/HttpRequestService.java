package io.cloudslang.content.openstack.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cloudslang.content.httpclient.HttpClientInputs;
import io.cloudslang.content.httpclient.ScoreHttpClient;
import io.cloudslang.content.openstack.constants.OutputNames;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import io.cloudslang.content.openstack.utils.HttpClientUtils;
import io.cloudslang.content.openstack.utils.StringUtils;

import java.util.Map;

public class HttpRequestService {
    private final String JSON_OBJECT_ACCESS = "access";
    private final String JSON_OBJECT_TOKEN = "token";
    private final String JSON_OBJECT_TENANT = "tenant";
    private final String JSON_OBJECT_NETWORK = "network";
    private final String JSON_PARAM_ID = "id";

    public Map<String, String> getAuthToken(HttpRequestWrapper requestWrapper) {
        Map<String, String> results = performRestCall(requestWrapper, null);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_200_SUCCESS_CODE)
                || results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_201_SUCCESS_CODE)) {
            JsonElement element = new Gson().fromJson (results.get(OutputNames.RETURN_RESULT), JsonElement.class);
            JsonObject jsonToken = element.getAsJsonObject().getAsJsonObject(JSON_OBJECT_ACCESS)
                    .getAsJsonObject(JSON_OBJECT_TOKEN);

            String tokenId = jsonToken.get(JSON_PARAM_ID).getAsString();
            results.put(OutputNames.AUTH_TOKEN, tokenId);
            String tenantId = jsonToken.getAsJsonObject(JSON_OBJECT_TENANT).get(JSON_PARAM_ID).getAsString();
            results.put(OutputNames.TENANT_ID, tenantId);
        } else {
            results.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
        }

        return results;
    }

    public Map<String, String> getNetworksList(HttpRequestWrapper requestWrapper, String token) {

        Map<String, String> results = performRestCall(requestWrapper, token);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_200_SUCCESS_CODE)
                || results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_201_SUCCESS_CODE)) {
            results.put(OutputNames.RESPONSE_BODY, results.get(OutputNames.RESPONSE_BODY));
        } else {
            results.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
        }

        return results;
    }

    public Map<String, String> createNetwork(HttpRequestWrapper requestWrapper, String token) {

        Map<String, String> results = performRestCall(requestWrapper, token);

        JsonElement element = new Gson().fromJson (results.get(OutputNames.RETURN_RESULT), JsonElement.class);
        JsonObject jsonToken = element.getAsJsonObject().getAsJsonObject(JSON_OBJECT_NETWORK);

        String uuid = jsonToken.get(JSON_PARAM_ID).getAsString();
        results.put(OutputNames.UUID, uuid);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_201_SUCCESS_CODE)) {
            results.put(OutputNames.RESPONSE_BODY, results.get(OutputNames.RESPONSE_BODY));
        } else {
            results.put(OutputNames.RETURN_CODE, OutputNames.RETURN_CODE_FAILURE);
        }

        return results;
    }

    public Map<String, String> deleteNetwork(HttpRequestWrapper requestWrapper, String token) {

        Map<String, String> results = performRestCall(requestWrapper, token);

        if (results.get(OutputNames.STATUS_CODE).equals(OutputNames.HTTP_204_SUCCESS_CODE)) {
            results.put(OutputNames.RESPONSE_BODY, results.get(OutputNames.RESPONSE_BODY));
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
}