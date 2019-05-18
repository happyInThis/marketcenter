package com.zhao.marketcenter.common.util;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;


public class JsonUtil {
    public static Gson gson;
    private static Gson ksGson;

    static {
        GsonBuilder gb = new GsonBuilder();
        gb.disableHtmlEscaping();
        gb.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //FIXME 避免反射map时，整数变成double
        gb.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            @Override
            public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                if (src == src.longValue()) {
                    return new JsonPrimitive(src.longValue());
                }
                return new JsonPrimitive(src);
            }
        });
        gson = gb.create();

        GsonBuilder ksGb = new GsonBuilder();
        ksGb.disableHtmlEscaping();
        ksGb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //FIXME 避免反射map时，整数变成double
        ksGb.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            @Override
            public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                if (src == src.longValue()) {
                    return new JsonPrimitive(src.longValue());
                }
                return new JsonPrimitive(src);
            }
        });
        ksGson = ksGb.create();
    }

    public static <T> T parseJson(String jsonStr, Class<T> tClass) {
        return gson.fromJson(jsonStr, tClass);
    }

    public static <T> T parseJson(JsonReader jsonReader, Class<T> tClass) {
        return gson.fromJson(jsonReader, tClass);
    }

    public static <T> T parseJson(String jsonStr, Type typeOfT) {
        return gson.fromJson(jsonStr, typeOfT);
    }

    /**
     * 使用Gson生成json字符串
     *
     * @param src
     * @return
     */
    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    /**
     * 针对快手生成json字符串
     *
     * @param src
     * @return
     */
    public static String toKsJson(Object src) {
        return ksGson.toJson(src);
    }

}