package ru.easydonate.easydonate4j.json.serialization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class GsonTypeAdapterResolver implements TypeAdapterFactory {

    private final JsonSerializationService jsonSerializationService;
    private final Map<Class<?>, GsonTypeAdapter<?>> typeAdapterCache;

    public GsonTypeAdapterResolver(@NotNull JsonSerializationService jsonSerializationService) {
        this.jsonSerializationService = jsonSerializationService;
        this.typeAdapterCache = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public synchronized <T> @Nullable TypeAdapter<T> create(@NotNull Gson gson, @NotNull TypeToken<T> typeToken) {
        Class<?> type = typeToken.getRawType();
        Class<?> foundClass = jsonSerializationService.findRegisteredImplementation(type);
        if(foundClass == type)
            return null;

        if(foundClass.isInterface())
            throw new IllegalArgumentException(String.format("Cannot find a registered implementation for the %s!", type.getName()));

        GsonTypeAdapter<?> adapter = typeAdapterCache.get(foundClass);
        if(adapter == null) {
            adapter = new GsonTypeAdapter<>(gson, foundClass);
            typeAdapterCache.put(foundClass, adapter);
        }

        return (TypeAdapter<T>) adapter;
    }

}
