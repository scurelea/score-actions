package io.cloudslang.content.openstack.entities;

public class HttpResponseWrapper<T> {
    private T responseBodyObject;
    private String responseBody;
    private String result;

    public T getResponseBodyObject() {
        return responseBodyObject;
    }

    public void setResponseBodyObject(T responseBodyObject) {
        this.responseBodyObject = responseBodyObject;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
