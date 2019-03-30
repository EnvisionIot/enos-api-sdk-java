/**
 * Project: eeop
 * <p>
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envisioniot.enos.enosapi.sdk.util;

import com.envisioniot.enos.enosapi.api.request.connectservice.CheckDevicesRequest;
import com.envisioniot.enos.enosapi.common.exception.EnOSApiException;
import com.envisioniot.enos.enosapi.common.exception.EnOSClientException;
import com.envisioniot.enos.enosapi.common.response.EnOSResponse;
import com.envisioniot.enos.enosapi.common.util.Constants;
import com.envisioniot.enos.enosapi.common.util.EnOSErrorCode;
import com.envisioniot.enos.enosapi.common.util.StringUtils;
import com.envisioniot.enos.enosapi.sdk.client.EnOSClient;
import com.envisioniot.enos.enosapi.sdk.client.EnOSDefaultClient;
import com.envisioniot.enos.enosapi.sdk.enums.SignMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * Digest
 */
public class Sign {
    private static Logger logger = LoggerFactory.getLogger(Sign.class);

    private Sign() {

    }

    //Conver Bytes To Hex string
    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int twoHalfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            }
            while (twoHalfs++ < 1);
        }
        return buf.toString();
    }

    //Assembly String
    public static String makeString(String accessKey, String secret, Map<String, String> paramMap, String bodyContent) {
        //Sort Para Map
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        //Assembly string
        StringBuilder stringBuilder = new StringBuilder();
        if (accessKey != null) {
            stringBuilder.append(accessKey);
        }
        for (String key : keyArray) {
            stringBuilder.append(key).append(paramMap.get(key));
        }
        if (!StringUtils.isEmpty(bodyContent)) {
            stringBuilder.append(bodyContent);
        }
        stringBuilder.append(secret);

        return stringBuilder.toString();
    }

    public static byte[] encryptMD5(byte[] data) throws IOException {
        byte[] bytes = null;

        try {
            MessageDigest md5 = MessageDigest.getInstance(SignMethods.MD5.getAlgorithm());
            md5.update(data);
            bytes = md5.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }

        return bytes;
    }

    public static byte[] encryptSHA(byte[] data) throws IOException {
        byte[] bytes = null;

        try {
            MessageDigest sha = MessageDigest.getInstance(SignMethods.SHA1.getAlgorithm());
            sha.update(data);
            bytes = sha.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }

        return bytes;
    }

    private static byte[] encryptSHA256(byte[] data) throws IOException {
        byte[] bytes = null;

        try {
            MessageDigest sha2 = MessageDigest.getInstance(SignMethods.SHA_256.getAlgorithm());
            sha2.update(data);
            bytes = sha2.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }

        return bytes;
    }

    public static byte[] encryptHMAC(byte[] data, String key) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey sk = new SecretKeySpec(key.getBytes(Constants.CHARSET_UTF8), SignMethods.HMAC_MD5.getAlgorithm());
            Mac mac = Mac.getInstance(sk.getAlgorithm());
            mac.init(sk);
            bytes = mac.doFinal(data);
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
        return bytes;
    }

    /**
     * 支持多种签名算法：SHA1、SHA-256、MD5、HmacMD5
     * @param accessKey
     * @param secret
     * @param paramMap
     * @param bodyContent
     * @param type
     * @return
     */
    public static String sign(String accessKey, String secret, Map<String, String> paramMap, String bodyContent, String type) {
        String sign = null;
        try {
            String codes = makeString(accessKey, secret, paramMap, bodyContent);
            byte[] bytes = codes.getBytes(Constants.CHARSET_UTF8);
            byte[] encrypt = null;
            SignMethods m = SignMethods.SIGN_METHODS_MAP.get(type);
            switch (m) {
                case SHA1:
                    encrypt = encryptSHA(bytes);
                    break;
                case SHA_256:
                    encrypt = encryptSHA256(bytes);
                    break;
                case MD5:
                    encrypt = encryptMD5(bytes);
                    break;
                case HMAC_MD5:
                    encrypt = encryptHMAC(bytes, secret);
                    break;
                default:
                    encrypt = encryptSHA256(bytes);
                    break;
            }
            String hexStr = convertToHex(encrypt);
            sign = hexStr.toUpperCase();
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException", e);
            return new String("");
        } catch (IOException e) {
            logger.error("IOException", e);
            return new String("");
        }

        return sign;
    }

    /**
     * Default signature algorithm : SHA-256
     * @param accessKey
     * @param secret
     * @param paramMap
     * @param bodyContent
     * @return
     */
    public static String sign(String accessKey, String secret, Map<String, String> paramMap, String bodyContent) {
        return sign(accessKey, secret, paramMap, bodyContent, SignMethods.SHA_256.getAlgorithm());
    }
}
