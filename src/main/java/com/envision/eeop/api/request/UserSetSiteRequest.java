package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserSetUserSiteResponse;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserSetSiteRequest implements EnvisionRequest {
    private static final String API_METHOD = "/userService/setUserSite";
    private String userId;
    private String orgCode;
    private String roleIds;
    private String siteIds;
    private String type;

    public UserSetSiteRequest() {
    }

    public UserSetSiteRequest(String userId, String orgCode, String roleIds, String siteIds) {
        this.userId = userId;
        this.orgCode = orgCode;
        this.roleIds = roleIds;
        this.siteIds = siteIds;
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("userId", this.userId);
        txtParams.put("orgCode", this.orgCode);
        txtParams.put("roleIds", this.roleIds);
        txtParams.put("siteIds", this.siteIds);
        txtParams.put("type", this.type);
        return txtParams;
    }

    @Override
    public Class getResponseClass() {
        return UserSetUserSiteResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.userId, "userId");
        RuleCheckUtils.checkNotEmpty(this.orgCode, "orgCode");
        RuleCheckUtils.checkNotEmpty(this.roleIds, "roleIds");
        RuleCheckUtils.checkNotEmpty(this.siteIds, "siteIds");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(String siteIds) {
        this.siteIds = siteIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
