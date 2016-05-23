package io.cloudslang.content.openstack.entities.identity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.cloudslang.content.openstack.entities.PasswordCredentials;

@Generated("org.jsonschema2pojo")
public class Auth {

    @SerializedName("tenantName")
    @Expose
    private String tenantName;
    @SerializedName("passwordCredentials")
    @Expose
    private PasswordCredentials passwordCredentials;

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

}
