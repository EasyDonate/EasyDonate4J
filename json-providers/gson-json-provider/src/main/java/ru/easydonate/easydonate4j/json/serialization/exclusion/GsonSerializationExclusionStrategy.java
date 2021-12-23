package ru.easydonate.easydonate4j.json.serialization.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import org.jetbrains.annotations.NotNull;

public final class GsonSerializationExclusionStrategy implements ExclusionStrategy {

    private static final GsonSerializationExclusionStrategy SINGLETON = new GsonSerializationExclusionStrategy();

    public static @NotNull GsonSerializationExclusionStrategy getSingleton() {
        return SINGLETON;
    }

    @Override
    public boolean shouldSkipField(@NotNull FieldAttributes fieldAttributes) {
        Expose annotation = fieldAttributes.getAnnotation(Expose.class);
        return annotation != null && annotation.serialize();
    }

    @Override
    public boolean shouldSkipClass(@NotNull Class<?> clazz) {
        return false;
    }

}
