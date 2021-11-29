package ru.easydonate.easydonate4j.v3.json.serialization;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;

@AllArgsConstructor
public final class JacksonAbstractTypeResolver extends SimpleAbstractTypeResolver {

    private final JsonSerializationService jsonSerializationService;

    @Override
    public JavaType findTypeMapping(@NotNull DeserializationConfig config, @NotNull JavaType type) {
        Class<?> typeRawClass = type.getRawClass();
        Class<?> foundClass = jsonSerializationService.findRegisteredImplementation(typeRawClass);
        return config.getTypeFactory().constructSpecializedType(type, foundClass);
    }

}
