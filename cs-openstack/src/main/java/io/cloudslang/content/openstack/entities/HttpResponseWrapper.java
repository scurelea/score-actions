package io.cloudslang.content.openstack.entities;

public class HttpResponseWrapper<T> {
    private T responseBodyObject;
    private String responseBody;
    private String result;
    private String token;
    private String tenantId;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
