package ru.easydonate.easydonate4j.v3.json.serialization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.v3.json.serialization.deserializer.jackson.LocalDateTimeDeserializer;
import ru.easydonate.easydonate4j.v3.json.serialization.deserializer.jackson.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public final class JacksonSerializationModule extends SimpleModule {

    public JacksonSerializationModule(@NotNull JsonSerializationService jsonSerializationService) {
        super("EasyDonate4j");

        super.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        super.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        super.setAbstractTypes(new JacksonAbstractTypeResolver(jsonSerializationService));
    }

}
