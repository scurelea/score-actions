package io.cloudslang.content.openstack.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.cloudslang.content.openstack.utils.Identifiable;

import java.lang.reflect.Type;

public class EnumSerializer<T extends Enum<T> & Identifiable> implements JsonSerializer<T> {

    private Class<T> tClass;

    public EnumSerializer(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getId());
    }
}
