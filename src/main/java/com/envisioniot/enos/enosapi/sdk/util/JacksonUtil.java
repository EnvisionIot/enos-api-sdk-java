package com.envisioniot.enos.enosapi.sdk.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * @author dongdong.wang
 */

public class JacksonUtil {
    private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JacksonUtil() {
    }

    public static String toJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
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
            return OBJECT_MAPPER.readValue(json, valueType);
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
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructType(valueType);
            return OBJECT_MAPPER.readValue(json, javaType);
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
            return (T) OBJECT_MAPPER.readValue(json, typeReference);
        }  catch (Exception e) {
            logger.error("fromJson(String,TypeReference)", e);
        }
        return null;
    }
}

