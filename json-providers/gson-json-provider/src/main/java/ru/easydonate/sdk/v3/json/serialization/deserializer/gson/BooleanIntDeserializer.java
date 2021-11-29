package ru.easydonate.sdk.v3.json.serialization.deserializer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;

public final class BooleanIntDeserializer implements JsonDeserializer<Boolean> {

    private static final BooleanIntDeserializer SINGLETON = new BooleanIntDeserializer();

    public static @NotNull BooleanIntDeserializer getSingleton() {
        return SINGLETON;
    }

    @Override
    public @Nullable Boolean deserialize(
            @Nullable JsonElement json,
            @NotNull Type type,
            @NotNull JsonDeserializationContext context
    ) throws JsonParseException {
        if(json == null || !json.isJsonPrimitive())
            return null;

        // try to parse this json element as int
        try {
            int valueAsInt = json.getAsInt();
            switch (valueAsInt) {
                case 0:
                    return Boolean.FALSE;
                case 1:
                    return Boolean.TRUE;
                default:
                    break;
            }
        } catch (ClassCastException | NumberFormatException ignored) {
        }

        // overwise try to parse that as a boolean value
        return json.getAsBoolean();
    }

}
