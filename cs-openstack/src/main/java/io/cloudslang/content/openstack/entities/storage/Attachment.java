
package io.cloudslang.content.openstack.entities.storage;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Attachment {

    @SerializedName("attachment_id")
    @Expose
    private String attachmentId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("volume_id")
    @Expose
    private String volumeId;
    @SerializedName("server_id")
    @Expose
    private String serverId;
    @SerializedName("host_name")
    @Expose
    private String hostName;
    @SerializedName("device")
    @Expose
    private String device;

    /**
     * 
     * @return
     *     The attachmentId
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * 
     * @param attachmentId
     *     The attachment_id
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

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
     *     The volumeId
     */
    public String getVolumeId() {
        return volumeId;
    }

    /**
     * 
     * @param volumeId
     *     The volume_id
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    /**
     * 
     * @return
     *     The serverId
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * 
     * @param serverId
     *     The server_id
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    /**
     * 
     * @return
     *     The hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 
     * @param hostName
     *     The host_name
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * 
     * @return
     *     The device
     */
    public String getDevice() {
        return device;
    }

    /**
     * 
     * @param device
     *     The device
     */
    public void setDevice(String device) {
        this.device = device;
    }

}
