package com.envisioniot.enos.enosapi.sdk.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * sdk端支持的签名算法枚举，但在服务端并非开放所有的签名算法解析，默认支持SHA-256
 * @author dongdong.wang
 * @date 2019/03/08
 */
public enum SignMethods {
    /**
     * 支持的签名算法名称
     */
    SHA1("SHA"),
    SHA_256("SHA-256"),
    MD5("MD5"),
    HMAC_MD5("HmacMD5");
    ;
    private String algorithm ;

    public final static Map<String, SignMethods> SIGN_METHODS_MAP;

    SignMethods(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    static {
        Map<String, SignMethods> originMap = new HashMap<>();
        for (SignMethods signMethod : SignMethods.values()) {
            originMap.put(signMethod.algorithm, signMethod);
        }
        SIGN_METHODS_MAP = Collections.unmodifiableMap(originMap);
    }
}
