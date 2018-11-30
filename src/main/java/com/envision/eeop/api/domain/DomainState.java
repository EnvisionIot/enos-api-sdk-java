package com.envision.eeop.api.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by changyi.yuan on 2016/6/17.
 */
public class DomainState implements Serializable {
    private static final long serialVersionUID = -1734715030834873948L;

    @SerializedName("mdmId")
    private String mdmId;

    @SerializedName("state")
    private String state;

    @SerializedName("begin_time")
    private String beginTime;

    @SerializedName("end_time")
    private String endTime;
    
    public DomainState() {
    }

    public String getMdmId() {
        return mdmId;
    }

    public void setMdmId(String mdmId) {
        this.mdmId = mdmId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return "DomainState [mdmId = " + mdmId + ", state = " + state
                + ", beginTime = " + beginTime + ", endTime = " + endTime + "]";
    }
}
