package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;
import com.envision.eeop.api.domain.AuthUserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/7/11.
 */
public class UserGetByAppResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6837088212858525401L;
    public List<AuthUserInfo> userInfoList = new ArrayList<>();

    public List<AuthUserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<AuthUserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

}
