/**
 * Project: eeop
 * 
 * Copyright http://www.envisioncn.com/ All rights reserved.
 *
 * @author xiaomin.zhou
 */
package com.envision.eeop.api.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**
 * Json Parser
 */
public class JsonParser
{
    private static final Gson gson = new Gson();

    //Dummy Constructor
    private JsonParser()
    {

    }

    //Json To Object By Gson
    public static <T> T fromJson(String json, Class<T> classOfT)
    {
        return gson.fromJson(json, classOfT);
    }

    //Json To Object By Gson
    public static <T> T fromJson(String json, Type typeOfT)
    {
        return gson.fromJson(json, typeOfT);
    }

    //Object To Json By Gson
    public static String toJson(Object object)
    {
        return gson.toJson(object);
    }

}
