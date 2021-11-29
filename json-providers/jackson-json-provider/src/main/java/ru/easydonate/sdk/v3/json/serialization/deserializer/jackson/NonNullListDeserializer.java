package ru.easydonate.sdk.v3.json.serialization.deserializer.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NonNullListDeserializer extends JsonDeserializer<List<?>> {

    @Override
    public @NotNull List<?> deserialize(
            @NotNull JsonParser parser,
            @NotNull DeserializationContext context
    ) throws IOException {
        List<?> asList = parser.readValueAs(ArrayList.class);
        return asList != null ? asList : Collections.emptyList();
    }

}
