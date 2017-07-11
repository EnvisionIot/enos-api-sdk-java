package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqi.yang on 2017/7/11.
 */
public class UserGetByAppResponse extends EnvisionResponse {
    private static final long serialVersionUID = 6837088212858525401L;
    public List<UserInfo> userInfoList = new ArrayList<>();

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public class UserInfo implements Serializable{
        private static final long serialVersionUID = 2632839279001586104L;
        private String userId;
        private String userName;
        private String orgCode;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }
    }
}
