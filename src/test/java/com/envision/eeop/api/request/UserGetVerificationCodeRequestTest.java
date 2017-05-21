package com.envision.eeop.api.request;

import com.alibaba.fastjson.JSON;
import com.envision.eeop.api.EnvisionClient;
import com.envision.eeop.api.EnvisionDefaultClient;
import com.envision.eeop.api.domain.UserSetUserSiteVo;
import com.envision.eeop.api.exception.EnvisionApiException;
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
            "http://127.0.0.1:8080", "ac683bf3-d96a-466c-ab7e-22edcf5c3549", "8A4512531A06075ECA7485229389C98F");

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
            testLogin();
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setAreaCode("86");
            request.setMobile("15021075406");
            request.setType(UserGetVerificationCodeRequest.TYPE_REGISTER);
            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegisterStep1(){
        testLogin();
//        String msgType = UserRequestCommon.MSG_TYPE_EMAIL;
        String step = UserRegisterRequest.STP1;
        String sendBy = UserRequestCommon.MSG_TYPE_MOBILE;
        String verificationCode = "54156";
        String orgCode = "57baab5ed3eb4806104b045d";
        String name = "zikyTest003";
        String email = "zhiqi.yang@envisioncn.com";
        String password = "!@#Qwe1";
        String areaCode = "86";
        String mobile = "15021075406";
        try {
            UserRegisterRequest registerRequest = new UserRegisterRequest();
            registerRequest.setEmail(email);
            registerRequest.setSendBy(sendBy);
            registerRequest.setStep(step);
            registerRequest.setOrgCode(orgCode);
            registerRequest.setMobile(mobile);
            UserRegisterResponse response = client.execute(registerRequest,this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRegisterStep2(){
        testLogin();
//        String msgType = UserRequestCommon.MSG_TYPE_EMAIL;
        String step = UserRegisterRequest.STP2;
        String sendBy = UserRequestCommon.MSG_TYPE_MOBILE;
        String verificationCode = "38435";
        String orgCode = "57baab5ed3eb4806104b045d";
        String name = "zikyTest004";
        String email = "zhiqi.yang@envisioncn.com";
        String password = "!@#Qwe1";
        String areaCode = "86";
        String mobile = "15021075406";
        try {
            UserRegisterRequest registerRequest = new UserRegisterRequest();
            registerRequest.setEmail(email);
            registerRequest.setSendBy(sendBy);
            registerRequest.setStep(step);
            registerRequest.setOrgCode(orgCode);
            registerRequest.setMobile(mobile);
            registerRequest.setVerificationCode(verificationCode);
            registerRequest.setName(name);
            registerRequest.setPassword(password);

            UserRegisterResponse response = client.execute(registerRequest,this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRoles(){
        try {
            this.name = "user_20170428";
            this.password ="test";

            testLogin();
            UserGetRolesRequest rolesRequest = new UserGetRolesRequest();
            rolesRequest.setOrgCode("17cf50d7b243e000");
            UserGetRolesResponse rolesResponse = client.execute(rolesRequest, this.token);
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
            this.name = "zikyTest003";
            this.password = "!@#Qwe1";
            testLogin();
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setUserId("2d388940-611c-453d-bb41-0164ea344b77");
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setVerificationCode("40130");
            request.setType(UserGetVerificationCodeRequest.TYPE_MODIFY_CONTACT_STP2);

            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSetUserContact(){
        try{
            this.name = "zikyTest003";
            this.password = "!@#Qwe1";
            testLogin();
            UserSetUserContactRequest request = new UserSetUserContactRequest();
            request.setUserId("2d388940-611c-453d-bb41-0164ea344b77");
            request.setMobile("15021075406");
            request.setAreaCode("86");
            request.setVerificationCode("54156");
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setMsgType(UserRequestCommon.MSG_TYPE_MOBILE);
            UserSetUserContactResponse response = client.execute(request,this.token);
            System.out.println(JSON.toJSONString(response));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVerificationCodeModifyPassword(){
        try {
            testLogin();
            UserGetVerificationCodeRequest request = new UserGetVerificationCodeRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setType(UserGetVerificationCodeRequest.TYPE_MODIFYPASSWORD_EMAIL);
            UserGetVerificationCodeResponse codeResponse = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(codeResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetUserPasswordStep1(){
        try {
//            this.name = "zikyTest003";
//            this.password = "test";
            testLogin();

            UserSetUserPasswordRequest request = new UserSetUserPasswordRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setStep(UserSetUserPasswordRequest.STP1);
            UserSetUserPasswordResponse response = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSetUserPasswordStep2(){
        try {
//            this.name = "zikyTest003";
//            this.password = "test";
            testLogin();

            UserSetUserPasswordRequest request = new UserSetUserPasswordRequest();
            request.setEmail("zhiqi.yang@envisioncn.com");
            request.setStep(UserSetUserPasswordRequest.STP2);
            request.setVerificationCode("78901");
            request.setPassword("$#@E3e");
            UserSetUserPasswordResponse response = client.execute(request, this.token);
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
            request.setRefreshToken(this.refreshToken);

            UserLoginByRefreshTokenResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogout(){
        String refreshToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0OTc2OTIyMDksInVzZXJfaWQiOiJiMWY2YTNhZS00OTNlLTQ3NmItYjI0MC1iMWExOGEyYWZjYzAiLCJjbGllbnRfaWQiOiJhYzY4M2JmMy1kOTZhLTQ2NmMtYWI3ZS0yMmVkY2Y1YzM1NDkifQ.3ldPfvJl32FbMS0bko6bPxC4eMiugZ345dNggIlGBfo";
        UserLogoutRequest request = new UserLogoutRequest();
        request.setUserId("b1f6a3ae-493e-476b-b240-b1a18a2afcc0");
        request.setRefreshToken(refreshToken);
        try {
            UserLogoutResponse response = client.execute(request);
            System.out.println(JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetSite(){
        UserSetUserSiteRequest request = new UserSetUserSiteRequest();
        UserSetUserSiteVo vo = new UserSetUserSiteVo();
        vo.setUserId("testt");
        vo.setType("type");
        vo.setOrgCode("test");
        vo.setRoleIds("test");
        vo.setSiteIds("test");
//        request.setUserSiteVo(vo);

        try {
            UserSetUserSiteResponse rs = client.execute(request);
            System.out.println(JSON.toJSONString(rs));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddContactSetp1(){
        this.name = "zikyTest003";
        this.password = "test";
        testLogin();
        String email = "zhiqi.yang@envisioncn.com";
        UserAddContactRequest request = new UserAddContactRequest();
        request.setEmail(email);
        request.setStep(UserAddContactRequest.STP1);
        try {
            UserAddContactResponse rs = client.execute(request,this.token);
            System.out.println(JSON.toJSONString(rs));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAddContactStep2(){
        this.name = "zikyTest003";
        this.password = "test";
        testLogin();
        String email = "zhiqi.yang@envisioncn.com";
        UserAddContactRequest request = new UserAddContactRequest();
        request.setEmail(email);
        request.setVerificationCode("93820");
        request.setStep(UserAddContactRequest.STP2);
        try {
            UserAddContactResponse rs = client.execute(request,this.token);
            System.out.println(JSON.toJSONString(rs));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateContactStep1(){
        this.name = "zikyTest003";
        this.password = "test";
        testLogin();
        String email = "zhiqi.yang@envisioncn.com";
        UserUpdateContactRequest request = new UserUpdateContactRequest();
        request.setEmail(email);
        request.setStep(UserUpdateContactRequest.STP1);
        try {
            UserUpdateContactResponse response = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateContactStep2(){
        this.name = "zikyTest003";
        this.password = "test";
        testLogin();
        String email = "zhiqi.yang@envisioncn.com";
        UserUpdateContactRequest request = new UserUpdateContactRequest();
        request.setEmail(email);
        request.setStep(UserUpdateContactRequest.STP2);
        request.setVerificationCode("41381");
        try {
            UserUpdateContactResponse response = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateContactStep3(){
        this.name = "zikyTest003";
        this.password = "test";
        testLogin();
        String email = "zhiqi.yang@envisioncn.com";
        UserUpdateContactRequest request = new UserUpdateContactRequest();
        request.setEmail(email);
        request.setStep(UserUpdateContactRequest.STP3);
        request.setVerificationCode("42547");
        try {
            UserUpdateContactResponse response = client.execute(request, this.token);
            System.out.println(JSON.toJSONString(response));
        } catch (EnvisionApiException e) {
            e.printStackTrace();
        }
    }




}
