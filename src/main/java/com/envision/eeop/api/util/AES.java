package com.envision.eeop.api.util;

/**
 * Created by jihong.li on 2016/7/11.
 */

import com.envision.eeop.api.Constants;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static String ALGO = "AES"; 
    private static String ALGO_MODE_PATTERN = "AES/CBC/PKCS5Padding";
    private static String DEF_KEY = "sfsafasdfsafasff";
    private static String DEF_IV = "phjlknslfdhksldf";

    public static void setDefKey(String key) {
        DEF_KEY = key;
    }

    public static void setDefIv(String iv) {
        DEF_IV = iv;
    }

    private AES(){}

    public static String encrypt(String sSrc) throws Exception{
        return encrypt(sSrc, DEF_KEY);
    }

    public static String encrypt(String sSrc, String sKey) throws Exception{
        return encrypt(sSrc, sKey, DEF_IV);
    }

    public static String encrypt(String sSrc, String sKey, String sIv) throws Exception{
        if (sKey == null) {
            return null;
        }
        if (sKey.length() != 16) {
            return null;
        }
        byte[] raw = sKey.getBytes(Constants.CHARSET_UTF8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGO);
        Cipher cipher = Cipher.getInstance(ALGO_MODE_PATTERN);
        IvParameterSpec iv = new IvParameterSpec(sIv.getBytes(Constants.CHARSET_UTF8));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(Constants.CHARSET_UTF8));
        return Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String sSrc) throws Exception{
        return decrypt(sSrc, DEF_KEY);
    }

    public static String decrypt(String sSrc, String sKey) throws Exception{
        return decrypt(sSrc, sKey, DEF_IV);
    }

    public static String decrypt(String sSrc, String sKey, String sIv) throws Exception{
        if (sKey == null) {
            return null;
        }

        if (sKey.length() != 16) {
            return null;
        }
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGO);
        Cipher cipher = Cipher.getInstance(ALGO_MODE_PATTERN);
        IvParameterSpec iv = new IvParameterSpec(sIv.getBytes(Constants.CHARSET_UTF8));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = Base64.decodeBase64(sSrc);
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, Constants.CHARSET_UTF8);
    }
}
