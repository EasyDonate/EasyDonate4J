package ru.easydonate.sdk.v3.json.serialization.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import org.jetbrains.annotations.NotNull;

public final class GsonDeserializationExclusionStrategy implements ExclusionStrategy {

    private static final GsonDeserializationExclusionStrategy SINGLETON = new GsonDeserializationExclusionStrategy();

    public static @NotNull GsonDeserializationExclusionStrategy getSingleton() {
        return SINGLETON;
    }

    @Override
    public boolean shouldSkipField(@NotNull FieldAttributes fieldAttributes) {
        Expose annotation = fieldAttributes.getAnnotation(Expose.class);
        return annotation != null && annotation.deserialize();
    }

    @Override
    public boolean shouldSkipClass(@NotNull Class<?> clazz) {
        return false;
    }

}
