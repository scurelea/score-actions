package io.cloudslang.content.openstack.entities.identity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Access {

    @SerializedName("token")
    @Expose
    private Token token;
    @SerializedName("serviceCatalog")
    @Expose
    private List<ServiceCatalog> serviceCatalog = new ArrayList<ServiceCatalog>();
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("trust")
    @Expose
    private Trust trust;

    /**
     * 
     * @return
     *     The token
     */
    public Token getToken() {
        return token;
    }

    /**
     * 
     * @param token
     *     The token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * 
     * @return
     *     The serviceCatalog
     */
    public List<ServiceCatalog> getServiceCatalog() {
        return serviceCatalog;
    }

    /**
     * 
     * @param serviceCatalog
     *     The serviceCatalog
     */
    public void setServiceCatalog(List<ServiceCatalog> serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * 
     * @return
     *     The trust
     */
    public Trust getTrust() {
        return trust;
    }

    /**
     * 
     * @param trust
     *     The trust
     */
    public void setTrust(Trust trust) {
        this.trust = trust;
    }

}
