package ru.easydonate.easydonate4j.json.serialization.deserializer.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NonNullListDeserializer implements JsonDeserializer<List<?>> {

    @Override
    public @NotNull List<?> deserialize(
            @Nullable JsonElement json,
            @NotNull Type type,
            @NotNull JsonDeserializationContext context
    ) throws JsonParseException {
        if(json == null || !json.isJsonArray())
            return Collections.emptyList();

        List<?> asList = context.deserialize(json, ArrayList.class);
        return asList != null ? asList : Collections.emptyList();
    }

}
