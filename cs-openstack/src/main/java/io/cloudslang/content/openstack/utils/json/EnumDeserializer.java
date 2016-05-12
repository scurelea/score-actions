package io.cloudslang.content.openstack.utils.json;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.cloudslang.content.openstack.constants.ExceptionMessages;
import io.cloudslang.content.openstack.utils.Identifiable;

import java.lang.reflect.Type;

/**
 * This class is used for converting an int value from a JSON to the generic type {@code T}.
 */
public class EnumDeserializer<T extends Enum<T> & Identifiable> implements JsonDeserializer<T> {
    private Class<T> tClass;

    /**
     * Default constructor for this deserializer.
     *
     * @param tClass The class of the enum type
     */
    public EnumDeserializer(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        int id = jsonElement.getAsInt();
        id--;
        T[] enumConstants = tClass.getEnumConstants();
        if (id >= 0 && id < enumConstants.length) {
            return enumConstants[id];
        }

        throw new IllegalArgumentException(String.format(ExceptionMessages.ENUM_VALUE_IS_INVALID, id, tClass.getSimpleName()));
    }
}
