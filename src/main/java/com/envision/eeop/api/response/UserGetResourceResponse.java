package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AuthResourceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/7/11.
 */
public class UserGetResourceResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6772480046709707967L;
    private List<AuthResourceInfo> resources = new ArrayList<>();

    public List<AuthResourceInfo> getResources() {
        return resources;
    }

    public void setResources(List<AuthResourceInfo> resources) {
        this.resources = resources;
    }

}
