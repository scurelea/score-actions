package io.cloudslang.content.openstack.services;

import io.cloudslang.content.httpclient.ScoreHttpClient;
import io.cloudslang.content.openstack.constants.OutputNames;
import io.cloudslang.content.openstack.entities.HttpRequestWrapper;
import io.cloudslang.content.openstack.entities.HttpResponseWrapper;

import java.util.Map;

public class HttpRequestService {

    public HttpResponseWrapper performRestCall(HttpRequestWrapper requestWrapper) {
        ScoreHttpClient scoreClient = new ScoreHttpClient();

        Map<String, String> mapResult = scoreClient.execute(requestWrapper.parseToInputs());

        HttpResponseWrapper responseWrapper = new HttpResponseWrapper();
        responseWrapper.setResponseBody(mapResult.get(OutputNames.RESPONSE_BODY));
        responseWrapper.setResult(mapResult.get(OutputNames.RETURN_RESULT));

        return responseWrapper;
    }
}
