package ru.easydonate.easydonate4j.json.serialization.deserializer.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SilentListDeserializer extends JsonDeserializer<List<?>> {

    @Override
    public @Nullable List<?> deserialize(
            @NotNull JsonParser parser,
            @NotNull DeserializationContext context
    ) {
        try {
            return parser.readValueAs(ArrayList.class);
        } catch (IOException ex) {
            return null;
        }
    }

}
