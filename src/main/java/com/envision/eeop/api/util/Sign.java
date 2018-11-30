/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.envision.eeop.api.Constants;

/**
 * Digest
 *
 */
public class Sign
{
    private static Logger logger = LoggerFactory.getLogger(Sign.class);

    private Sign()
    {

    }

    //Conver Bytes To Hex string
    private static String convertToHex(byte[] data)
    {
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < data.length; i++)
        {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int twoHalfs = 0;
            do
            {
                if((0 <= halfbyte) && (halfbyte <= 9)) buf.append((char) ('0' + halfbyte));
                else buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            }
            while(twoHalfs++ < 1);
        }
        return buf.toString();
    }

    //Assembly String
    public static String makeString(String appKey, String secret, Map<String, String> paramMap)
    {
        //Sort Para Map
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        //Assembly string
        StringBuilder stringBuilder = new StringBuilder();
        if (appKey != null)
        {
            stringBuilder.append(appKey);
        }
        for(String key : keyArray)
        {
            stringBuilder.append(key).append(paramMap.get(key));
        }
        stringBuilder.append(secret);

        return stringBuilder.toString();
    }

    public static byte[] encryptMD5(byte[] data) throws IOException
    {
        byte[] bytes = null;

        try
        {
            MessageDigest md5 = MessageDigest.getInstance(Constants.KEY_MD5);
            md5.update(data);
            bytes = md5.digest();
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IOException(e);
        }

        return bytes;
    }

    public static byte[] encryptSHA(byte[] data) throws IOException
    {
        byte[] bytes = null;

        try
        {
            MessageDigest sha = MessageDigest.getInstance(Constants.KEY_SHA);
            sha.update(data);
            bytes = sha.digest();
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IOException(e);
        }

        return bytes;
    }

    public static byte[] encryptHMAC(byte[] data, String key) throws IOException
    {
        byte[] bytes = null;
        try
        {
            SecretKey sk = new SecretKeySpec(key.getBytes(Constants.CHARSET_UTF8), Constants.KEY_HMAC);
            Mac mac = Mac.getInstance(sk.getAlgorithm());
            mac.init(sk);
            bytes = mac.doFinal(data);
        }
        catch(GeneralSecurityException e)
        {
            throw new IOException(e);
        }
        return bytes;
    }

    public static String sign(String appKey, String secret, Map<String, String> paramMap, String type)
    {
        String sign = null;

        try
        {
            String codes = makeString(appKey, secret, paramMap);
            byte[] bytes = codes.getBytes(Constants.CHARSET_UTF8);
            byte[] encrypt;
            if(type.equals(Constants.KEY_MD5))
            {
                encrypt = encryptMD5(bytes);
            }
            else if(type.equals(Constants.KEY_HMAC))
            {
                encrypt = encryptHMAC(bytes, secret);
            }
            else
            {
                encrypt = encryptSHA(bytes);
            }

            String hexStr = convertToHex(encrypt);
            sign = hexStr.toUpperCase();
        }
        catch(UnsupportedEncodingException e)
        {
            logger.error("UnsupportedEncodingException", e);
            return new String("");
        }
        catch(IOException e)
        {
            logger.error("IOException", e);
            return new String("");
        }

        return sign;
    }

    //Default signature algorithm : SHA
    public static String sign(String appKey, String secret, Map<String, String> paramMap)
    {
        return sign(appKey, secret, paramMap, Constants.KEY_SHA);
    }

    //Default signature algorithm : SHA
    public static String sign(String secret, Map<String, String> paramMap)
    {
        return sign(null, secret, paramMap, Constants.KEY_SHA);
    }
}
