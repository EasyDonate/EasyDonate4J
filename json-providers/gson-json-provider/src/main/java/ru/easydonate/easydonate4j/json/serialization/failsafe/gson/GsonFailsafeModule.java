package ru.easydonate.easydonate4j.json.serialization.failsafe.gson;

import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GsonFailsafeModule {

    protected final Map<Type, Object> typeAdapters;

    protected GsonFailsafeModule() {
        this.typeAdapters = new LinkedHashMap<>();
    }

    protected void registerTypeAdapter(@NotNull Type type, @NotNull Object typeAdapter) {
        typeAdapters.put(type, typeAdapter);
    }

    public void register(@NotNull GsonBuilder... gsonBuilders) {
        for(GsonBuilder gsonBuilder : gsonBuilders)
            typeAdapters.forEach(gsonBuilder::registerTypeAdapter);
    }

}
