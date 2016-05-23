package io.cloudslang.content.openstack.utils.json;

import io.cloudslang.content.openstack.entities.identity.Auth;
import io.cloudslang.content.openstack.entities.identity.PasswordCredentials;

/**
 * Created by stcu on 23.05.2016.
 */
public class JsonBuilder {
    private final String AUTH_ROOT = "auth";

    public String getAuthBody(String user, String pass) {
        Auth authObj = new Auth();
        PasswordCredentials pcObj = new PasswordCredentials();
        pcObj.setUsername(user);
        pcObj.setPassword(pass);
        authObj.setTenantName(user);
        authObj.setPasswordCredentials(pcObj);
        return JsonParser.toJson(authObj, AUTH_ROOT);
    }
}
