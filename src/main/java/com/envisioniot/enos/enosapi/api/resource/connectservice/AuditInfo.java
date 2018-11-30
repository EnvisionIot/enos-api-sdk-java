package com.envisioniot.enos.enosapi.api.resource.connectservice;

import java.io.Serializable;

/**
 * Created by zuoyong.tang on 2018/8/24.
 */
public class AuditInfo implements Serializable {
    private static final long serialVersionUID = -8719466791448414768L;

    private String createBy;

    private long createTime;

    private String updateBy;

    private long updateTime;

    private String ns;

    private boolean deleted = false;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AuditInfo() {
    }
}
