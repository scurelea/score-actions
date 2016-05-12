package io.cloudslang.content.openstack.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JsonParser {

    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gson = gsonBuilder.create();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(Object source) {
        return gson.toJson(source);
    }

}
