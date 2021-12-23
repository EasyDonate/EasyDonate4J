package ru.easydonate.easydonate4j.json.serialization;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsRegistry;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractJsonSerializationService implements JsonSerializationService {

    protected final Map<Class<?>, Class<?>> implementationAliases;
    protected final Map<JsonModelsGroup, JsonModelsRegistry> registeredModelsGroups;

    public AbstractJsonSerializationService() {
        this.implementationAliases = new LinkedHashMap<>();
        this.registeredModelsGroups = new LinkedHashMap<>();
    }

    protected final void registerModelsGroup(@NotNull JsonModelsGroup group, @NotNull JsonModelsRegistry registry) {
        if(registeredModelsGroups.containsKey(group))
            return;

        registeredModelsGroups.put(group, registry);
        registry.register();
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
    @Override
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
