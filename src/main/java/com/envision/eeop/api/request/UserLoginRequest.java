package com.envision.eeop.api.request;

import com.envision.eeop.api.EnvisionRequest;
import com.envision.eeop.api.exception.EnvisionRuleException;
import com.envision.eeop.api.response.UserLoginResponse;
import com.envision.eeop.api.util.AES;
import com.envision.eeop.api.util.EnvisionHashMap;
import com.envision.eeop.api.util.RuleCheckUtils;

import java.util.Map;

/**
 * Created by zhiqi.yang on 2017/5/14.
 */
public class UserLoginRequest implements EnvisionRequest<UserLoginResponse> {
    private static final String API_METHOD = "/userService/login";
    private String name;
    private String password;
    private String passwordEncrypt;

    public UserLoginRequest() {
    }

    public UserLoginRequest(String name, String password) throws Exception {
        this.name = name;
        this.password = password;
        this.passwordEncrypt = AES.encrypt(password);
    }

    @Override
    public String getApiMethodName() {
        return API_METHOD;
    }

    @Override
    public Map<String, String> getTextParams() {
        EnvisionHashMap txtParams = new EnvisionHashMap();
        txtParams.put("name", this.name);
        txtParams.put("password", this.passwordEncrypt);
        return txtParams;
    }

    @Override
    public Class<UserLoginResponse> getResponseClass() {
        return UserLoginResponse.class;
    }

    @Override
    public void check() throws EnvisionRuleException {
        RuleCheckUtils.checkNotEmpty(this.name, "name");
        RuleCheckUtils.checkNotEmpty(this.password, "password");
    }

    @SuppressWarnings("unused")
    private boolean passwordCheckStrong (String password){
        if (password == null || password.trim().length() == 0){
            return false;
        }
        char[] pPsdChars = password.toCharArray();

        int numIndex = 0;
        int sLetterIndex = 0;
        int lLetterIndex = 0;
        int symbolIndex = 0;

        for (char pPsdChar : pPsdChars) {
            int ascll = pPsdChar;
            /*
             * 数字 48-57 A-Z 65 - 90 a-z 97 - 122 !"#$%&'()*+,-./ (ASCII码：33~47)
             * :;<=>?@ (ASCII码：58~64) [\]^_` (ASCII码：91~96) {|}~
             * (ASCII码：123~126)
             */
            if (ascll >= 48 && ascll <= 57) {
                numIndex++;
            } else if (ascll >= 65 && ascll <= 90) {
                lLetterIndex++;
            } else if (ascll >= 97 && ascll <= 122) {
                sLetterIndex++;
            } else if ((ascll >= 33 && ascll <= 47)
                    || (ascll >= 58 && ascll <= 64)
                    || (ascll >= 91 && ascll <= 96)
                    || (ascll >= 123 && ascll <= 126)) {
                symbolIndex++;
            }
        }
        if (numIndex < 1 || sLetterIndex < 1 || lLetterIndex < 1 || symbolIndex < 1){
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
        this.passwordEncrypt = AES.encrypt(password);
    }
}
