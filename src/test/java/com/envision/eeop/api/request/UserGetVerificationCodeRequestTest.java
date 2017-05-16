package com.envision.eeop.api.request;

import com.alibaba.fastjson.JSON;
import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.response.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhiqi.yang on 2017/5/16.
 */
public class UserGetVerificationCodeRequestTest {
    Logger logger = LoggerFactory.getLogger(UnregisterEdgeTest.class);

    private static EnvisionClient client = new EnvisionDefaultClient(
            "http://localhost:8080", "ac683bf3-d96a-466c-ab7e-22edcf5c3549", "8A4512531A06075ECA7485229389C98F");

    private String token;
    private String refreshToken;
    private String name = "test";
    private String password = "test";

    @Test
    public void testLogin(){
        UserLoginRequest loginRequest = new UserLoginRequest();
        try {
            loginRequest.setPassword(password);
            loginRequest.setName(name);
            UserLoginResponse loginResponse = client.execute(loginRequest);
            System.out.println(JSON.toJSONString(loginResponse));
            this.token = loginResponse.getAccessToken();
            this.refreshToken = loginResponse.getRefreshToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVerificationCodeRegister(){
        try {
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setType(UserGetVerificationCodeRequest.TYPE_REGISTER);
            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister(){
        String msgType = UserRequestCommon.MSG_TYPE_EMAIL;
        String verificationCode = "77536";
        String orgCode = "17f152f2026d6000";
        String name = "zikyTest001";
        String email = "zhiqi.yang@envisioncn.com";
        String password = "!@#Qwe1";
        try {
            UserRegisterRequest registerRequest = new UserRegisterRequest(msgType, verificationCode, orgCode, name, email, password);
            UserRegisterResponse response = client.execute(registerRequest);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRoles(){
        try {
            UserGetRolesRequest rolesRequest = new UserGetRolesRequest();
            rolesRequest.setOrgCode("17e974108bc3e000");
            UserGetRolesResponse rolesResponse = client.execute(rolesRequest);
            System.out.println(JSON.toJSONString(rolesResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserInfo(){
        String userId = "test";
        try {
            UserGetUserInfoRequest request = new UserGetUserInfoRequest();
            request.setUserId(userId);
            UserGetUserInfoResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVerificationCodeModifyUserInfo(){
        try {
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setType(UserGetVerificationCodeRequest.TYPE_MODIFYUSERINFO);
            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSetUserContact(){
        try{
            UserSetUserContactRequest request = new UserSetUserContactRequest();
            request.setUserId("634d045b-6ca9-45ab-9c8e-f0c35481c969");
            request.setMobile("15021075406");
            request.setAreaCode("86");
            request.setVerificationCode("76936");
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setMsgType(UserRequestCommon.MSG_TYPE_EMAIL);
            UserSetUserContactResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVerificationCodeModifyPassword(){
        try {
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setType(UserGetVerificationCodeRequest.TYPE_MODIFYPASSWORD);
            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetUserPassword(){
        try {
            UserSetUserPasswordRequest request = new UserSetUserPasswordRequest();
            request.setMsgType(UserRequestCommon.MSG_TYPE_EMAIL);
            request.setUserId("634d045b-6ca9-45ab-9c8e-f0c35481c969");
            request.setVerificationCode("28056");
            request.setPassword("$#@E3e");
            UserSetUserPasswordResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginByRefreshToken(){
        try {
            this.name = "zikyTest001";
            this.password = "test";
            testLogin();

            UserLoginByRefreshTokenRequest request = new UserLoginByRefreshTokenRequest();
            request.setUserId("634d045b-6ca9-45ab-9c8e-f0c35481c969");
            request.setRefreshToke(this.refreshToken);

            UserLoginByRefreshTokenResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogout(){
        String refreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0OTc1Mjg2MDUsInVzZXJfaWQiOiI2MzRkMDQ1Yi02Y2E5LTQ1YWItOWM4ZS1mMGMzNTQ4MWM5NjkiLCJjbGllbnRfaWQiOiJhYzY4M2JmMy1kOTZhLTQ2NmMtYWI3ZS0yMmVkY2Y1YzM1NDkifQ.g-cprHXohqGg0Ag5DzfGFuZv4VC3bqS8lqPUGkB-jyI";
        UserLogoutRequest request = new UserLogoutRequest();
        request.setUserId("634d045b-6ca9-45ab-9c8e-f0c35481c969");
        request.setRefreshToken(refreshToken);
        try {
            UserLogoutResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
