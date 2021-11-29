package ru.easydonate.sdk.v3.json.serialization.deserializer.gson;

import com.google.gson.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.Constants;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public final class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static final LocalDateTimeAdapter SINGLETON = new LocalDateTimeAdapter();

    public static @NotNull LocalDateTimeAdapter getSingleton() {
        return SINGLETON;
    }

    @Override
    public @NotNull JsonElement serialize(
            @Nullable LocalDateTime value,
            @NotNull Type type,
            @NotNull JsonSerializationContext context
    ) {
        return value != null ? context.serialize(value.format(Constants.DATE_FORMATTER)) : JsonNull.INSTANCE;
    }

    @Override
    public @Nullable LocalDateTime deserialize(
            @Nullable JsonElement json,
            @NotNull Type type,
            @NotNull JsonDeserializationContext context
    ) throws JsonParseException {
        if(json == null || json.isJsonNull())
            return null;

        String valueAsString = json.getAsString();
        if(valueAsString == null || valueAsString.isEmpty())
            return null;

        TemporalAccessor accessor = Constants.DATE_FORMATTER.parse(valueAsString);
        return LocalDateTime.from(accessor);
    }

}
