package io.cloudslang.content.openstack.entities.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Auth {

    @SerializedName("tenantName")
    @Expose
    private String tenantName;
    @SerializedName("tenantId")
    @Expose
    private String tenantId;
    @SerializedName("passwordCredentials")
    @Expose
    private PasswordCredentials passwordCredentials;
    @SerializedName("token")
    @Expose
    private Token token;

    /**
     * 
     * @return
     *     The tenantName
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * 
     * @param tenantName
     *     The tenantName
     */
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    /**
     * 
     * @return
     *     The passwordCredentials
     */
    public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

    /**
     * 
     * @param passwordCredentials
     *     The passwordCredentials
     */
    public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
    }

    /**
     *
     * @return
     * The token
     */
    public Token getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     *
     * @param tenantId
     * The tenantId
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
