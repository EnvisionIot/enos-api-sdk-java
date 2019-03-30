package com.envisioniot.enos.enosapi.api.resource.connectservice;

/**
 * Created by zuoyong.tang on 2018/8/24.
 */
public class DeviceStatistics {
    private static final long serialVersionUID = 1L;

    public long deviceTotal = 0L;
    public long onlineCount = 0L;
    public long offlineCount = 0L;
    public long inactiveCount = 0L;
    public long disableCount = 0L;

    public DeviceStatistics() {
    }

    public long getDeviceTotal() {
        return deviceTotal;
    }

    public void setDeviceTotal(long deviceTotal) {
        this.deviceTotal = deviceTotal;
    }

    public long getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(long onlineCount) {
        this.onlineCount = onlineCount;
    }

    public long getOfflineCount() {
        return offlineCount;
    }

    public void setOfflineCount(long offlineCount) {
        this.offlineCount = offlineCount;
    }

    public long getInactiveCount() {
        return inactiveCount;
    }

    public void setInactiveCount(long inactiveCount) {
        this.inactiveCount = inactiveCount;
    }

    public long getDisableCount() {
        return disableCount;
    }

    public void setDisableCount(long disableCount) {
        this.disableCount = disableCount;
    }

    @Override
    public String toString() {
        return "DeviceStatistics [deviceTotal=" + this.deviceTotal + ",onlineCount=" + this.onlineCount + ",offlineCount=" + this.offlineCount + ",inactiveCount=" + this.inactiveCount + ",disableCount=" + this.disableCount + "]";
    }
}
