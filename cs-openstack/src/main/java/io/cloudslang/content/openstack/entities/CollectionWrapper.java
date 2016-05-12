package io.cloudslang.content.openstack.entities;

import java.util.List;

public class CollectionWrapper<T> {
    private Integer total;
    private List<T> members;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getMembers() {
        return members;
    }

    public void setMembers(List<T> members) {
        this.members = members;
    }
}
