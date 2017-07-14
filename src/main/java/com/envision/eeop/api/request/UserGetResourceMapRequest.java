package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserGetResourceMapResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;
import com.envision.eeop.api.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/7/13.
 */
public class UserGetResourceMapRequest implements EnvisionRequest<UserGetResourceMapResponse> {
    private static final String API_METHOD = "/userService/getResourceMap";
    private String appId;
    private List<String> userList = new ArrayList<>();

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("appId", this.getAppId());
        txtParams.put("userList", StringUtils.listToString(this.getUserList(), ','));
        return txtParams;
    }

    @Override
    public Class<UserGetResourceMapResponse> getResponseClass() {
        return UserGetResourceMapResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.appId, "appId");
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }
}
