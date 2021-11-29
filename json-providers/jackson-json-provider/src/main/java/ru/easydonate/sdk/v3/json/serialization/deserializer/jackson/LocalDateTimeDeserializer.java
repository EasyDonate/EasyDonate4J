package ru.easydonate.sdk.v3.json.serialization.deserializer.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.Constants;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public final class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public @Nullable LocalDateTime deserialize(
            @NotNull JsonParser parser,
            @NotNull DeserializationContext context
    ) throws IOException {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null || valueAsString.isEmpty())
            return null;

        TemporalAccessor accessor = Constants.DATE_FORMATTER.parse(valueAsString);
        return LocalDateTime.from(accessor);
    }

}
