package com.envision.eeop.api.response;

import com.envision.eeop.api.EnvisionResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserLoginResponse extends EnvisionResponse
{
    private static final long serialVersionUID = -6836336446303410755L;
    private String userId;
    private String userName;
    private String accessToken;
    private Long accessTokenExpire;
    private String refreshToken;
    private Long refreshTokenExpire;
    private Map<String, String> attributeMap = new HashMap<>();

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenExpire()
    {
        return accessTokenExpire;
    }

    public void setAccessTokenExpire(Long accessTokenExpire)
    {
        this.accessTokenExpire = accessTokenExpire;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    public Long getRefreshTokenExpire()
    {
        return refreshTokenExpire;
    }

    public void setRefreshTokenExpire(Long refreshTokenExpire)
    {
        this.refreshTokenExpire = refreshTokenExpire;
    }

    public Map<String, String> getAttributeMap()
    {
        return attributeMap;
    }

    public void setAttributeMap(Map<String, String> attributeMap)
    {
        this.attributeMap = attributeMap;
    }

    @Override
    public String toString()
    {
        return "UserLoginResponse [userId=" + userId + ", userName=" + userName + ", accessToken=" + accessToken
                + ", accessTokenExpire=" + accessTokenExpire + ", refreshToken=" + refreshToken
                + ", refreshTokenExpire=" + refreshTokenExpire + ", attributeMap=" + attributeMap + ", status=" + status
                + ", msg=" + msg + ", submsg=" + submsg + "]";
    }
}
