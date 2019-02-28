package com.envisioniot.enos.enosapi.sdk.util;


import com.envisioniot.enos.enosapi.common.response.EnOSPage;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * created by dongdong.wang
 */

public class JacksonUtil {
    private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JacksonUtil() {
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("toJson(Object)", e);
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T fromJson(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            logger.error("fromJson(String,Class)", e);
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T fromJson(String json, Type valueType) {
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructType(valueType);
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            logger.error("fromJson(String,Class)", e);
        }
        return null;
    }

    /**
     * 将json 反序列化为对象
     *
     * @param json
     * @param typeReference
     * @return
     */
    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        }  catch (Exception e) {
            logger.error("fromJson(String,TypeReference)", e);
        }
        return null;
    }
}

