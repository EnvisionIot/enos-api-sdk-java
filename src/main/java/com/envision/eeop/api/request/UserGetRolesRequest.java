package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserGetRolesResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserGetRolesRequest implements EnvisionRequest<UserGetRolesResponse> {
    private static final String API_METHOD = "/userService/getRoles";
    private String orgCode;
    private String names;

    public UserGetRolesRequest() {
    }

    public UserGetRolesRequest(String orgCode, String names) {
        this.orgCode = orgCode;
        this.names = names;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("orgCode", this.orgCode);
        txtParams.put("names", this.names);
        return txtParams;
    }

    @Override
    public Class<UserGetRolesResponse> getResponseClass() {
        return UserGetRolesResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.orgCode, "orgCode");
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
