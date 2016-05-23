package io.cloudslang.content.openstack.entities.identity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Trust {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("trustee_user_id")
    @Expose
    private String trusteeUserId;
    @SerializedName("trustor_user_id")
    @Expose
    private String trustorUserId;
    @SerializedName("impersonation")
    @Expose
    private Boolean impersonation;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The trusteeUserId
     */
    public String getTrusteeUserId() {
        return trusteeUserId;
    }

    /**
     * 
     * @param trusteeUserId
     *     The trustee_user_id
     */
    public void setTrusteeUserId(String trusteeUserId) {
        this.trusteeUserId = trusteeUserId;
    }

    /**
     * 
     * @return
     *     The trustorUserId
     */
    public String getTrustorUserId() {
        return trustorUserId;
    }

    /**
     * 
     * @param trustorUserId
     *     The trustor_user_id
     */
    public void setTrustorUserId(String trustorUserId) {
        this.trustorUserId = trustorUserId;
    }

    /**
     * 
     * @return
     *     The impersonation
     */
    public Boolean getImpersonation() {
        return impersonation;
    }

    /**
     * 
     * @param impersonation
     *     The impersonation
     */
    public void setImpersonation(Boolean impersonation) {
        this.impersonation = impersonation;
    }

}
