package ru.easydonate.easydonate4j.v3.json.serialization.deserializer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class SilentListDeserializer implements JsonDeserializer<List<?>> {

    @Override
    public @Nullable List<?> deserialize(
            @Nullable JsonElement json,
            @NotNull Type typeOfT,
            @NotNull JsonDeserializationContext context
    ) throws JsonParseException {
        try {
            if(json != null && json.isJsonArray())
                return context.deserialize(json, ArrayList.class);
        } catch (JsonParseException ignored) {
        }

        return null;
    }

}
