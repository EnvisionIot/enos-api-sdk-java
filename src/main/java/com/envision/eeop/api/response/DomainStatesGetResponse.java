package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.DomainState;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by changyi.yuan on 2016/6/19.
 */
public class DomainStatesGetResponse extends EnvisionResponse {
    private static final long serialVersionUID = -1276721913060316393L;

    @SerializedName("metrics")
    private List<DomainState> domainStateList;

    public List<DomainState> getDomainStateList() {
        return domainStateList;
    }

    public void setDomainStateList(List<DomainState> domainStateList) {
        this.domainStateList = domainStateList;
    }
}
