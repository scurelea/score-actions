
package io.cloudslang.content.openstack.entities.storage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Volume {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("migration_status")
    @Expose
    private Object migrationStatus;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = new ArrayList<Object>();
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();
    @SerializedName("availability_zone")
    @Expose
    private String availabilityZone;
    @SerializedName("bootable")
    @Expose
    private String bootable;
    @SerializedName("encrypted")
    @Expose
    private Boolean encrypted;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("volume_type")
    @Expose
    private String volumeType;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("replication_status")
    @Expose
    private String replicationStatus;
    @SerializedName("consistencygroup_id")
    @Expose
    private Object consistencygroupId;
    @SerializedName("source_volid")
    @Expose
    private Object sourceVolid;
    @SerializedName("snapshot_id")
    @Expose
    private Object snapshotId;
    @SerializedName("multiattach")
    @Expose
    private Boolean multiattach;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("size")
    @Expose
    private Integer size;

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The migrationStatus
     */
    public Object getMigrationStatus() {
        return migrationStatus;
    }

    /**
     * 
     * @param migrationStatus
     *     The migration_status
     */
    public void setMigrationStatus(Object migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    public List<Object> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    /**
     * 
     * @return
     *     The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * 
     * @param availabilityZone
     *     The availability_zone
     */
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * 
     * @return
     *     The bootable
     */
    public String getBootable() {
        return bootable;
    }

    /**
     * 
     * @param bootable
     *     The bootable
     */
    public void setBootable(String bootable) {
        this.bootable = bootable;
    }

    /**
     * 
     * @return
     *     The encrypted
     */
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * 
     * @param encrypted
     *     The encrypted
     */
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The volumeType
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * 
     * @param volumeType
     *     The volume_type
     */
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * 
     * @return
     *     The name
     */
    public Object getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The replicationStatus
     */
    public String getReplicationStatus() {
        return replicationStatus;
    }

    /**
     * 
     * @param replicationStatus
     *     The replication_status
     */
    public void setReplicationStatus(String replicationStatus) {
        this.replicationStatus = replicationStatus;
    }

    /**
     * 
     * @return
     *     The consistencygroupId
     */
    public Object getConsistencygroupId() {
        return consistencygroupId;
    }

    /**
     * 
     * @param consistencygroupId
     *     The consistencygroup_id
     */
    public void setConsistencygroupId(Object consistencygroupId) {
        this.consistencygroupId = consistencygroupId;
    }

    /**
     * 
     * @return
     *     The sourceVolid
     */
    public Object getSourceVolid() {
        return sourceVolid;
    }

    /**
     * 
     * @param sourceVolid
     *     The source_volid
     */
    public void setSourceVolid(Object sourceVolid) {
        this.sourceVolid = sourceVolid;
    }

    /**
     * 
     * @return
     *     The snapshotId
     */
    public Object getSnapshotId() {
        return snapshotId;
    }

    /**
     * 
     * @param snapshotId
     *     The snapshot_id
     */
    public void setSnapshotId(Object snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * 
     * @return
     *     The multiattach
     */
    public Boolean getMultiattach() {
        return multiattach;
    }

    /**
     * 
     * @param multiattach
     *     The multiattach
     */
    public void setMultiattach(Boolean multiattach) {
        this.multiattach = multiattach;
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
     *     The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

}
