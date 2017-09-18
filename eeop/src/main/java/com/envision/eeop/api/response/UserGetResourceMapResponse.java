package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AuthResourceInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/7/13.
 */
public class UserGetResourceMapResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6060423141394524603L;

    private Map<String, List<AuthResourceInfo>> userResourceMap = new HashMap<>();

    public Map<String, List<AuthResourceInfo>> getUserResourceMap() {
        return userResourceMap;
    }

    public void setUserResourceMap(Map<String, List<AuthResourceInfo>> userResourceMap) {
        this.userResourceMap = userResourceMap;
    }

}
