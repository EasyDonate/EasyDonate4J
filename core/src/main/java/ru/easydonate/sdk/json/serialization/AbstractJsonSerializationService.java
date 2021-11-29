package ru.easydonate.sdk.json.serialization;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractJsonSerializationService implements JsonSerializationService {

    protected final Map<Class<?>, Class<?>> implementationAliases;

    public AbstractJsonSerializationService() {
        this.implementationAliases = new LinkedHashMap<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public @NotNull <T> Class<T> findRegisteredImplementation(@NotNull Class<T> type) {
        try {
            return (Class<T>) implementationAliases.getOrDefault(type, type);
        } catch (ClassCastException ignored) {
            return type;
        }
    }

    @Override
    public <T> void registerImplementationAlias(@NotNull Class<T> interfaceType, @NotNull Class<? extends T> implementationType) {
        implementationAliases.put(interfaceType, implementationType);
    }

    @SuppressWarnings("unchecked")
    public <T> void registerImplementationAlias(@NotNull Class<? extends T> implementationType) {
        Implementing implementing = implementationType.getAnnotation(Implementing.class);
        if(implementing == null)
            throw new IllegalArgumentException(String.format("'%s' must be annotated with @Implementing!", implementationType));

        Class<?> interfaceType = implementing.value();
        if(interfaceType == null)
            throw new IllegalArgumentException(String.format("'%s' is annotated with @Implementing, but implemented class is not specified!", implementationType));

        try {
            registerImplementationAlias((Class<T>) interfaceType, implementationType);
        } catch (ClassCastException ex) {
            throw new IllegalArgumentException(String.format("The '%s' doesn't implement the '%s', class cast failed!", implementationType, interfaceType));
        }
    }

}
