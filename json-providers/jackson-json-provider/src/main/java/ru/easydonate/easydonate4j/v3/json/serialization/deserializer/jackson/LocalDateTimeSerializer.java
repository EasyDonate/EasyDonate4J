package ru.easydonate.easydonate4j.v3.json.serialization.deserializer.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.Constants;

import java.io.IOException;
import java.time.LocalDateTime;

public final class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(
            @Nullable LocalDateTime value,
            @NotNull JsonGenerator generator,
            @NotNull SerializerProvider serializers
    ) throws IOException {
        generator.writeString(value != null ? value.format(Constants.DATE_FORMATTER) : null);
    }

}
