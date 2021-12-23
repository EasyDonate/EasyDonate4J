package ru.easydonate.easydonate4j.json.serialization.implementation.registry;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.util.Validate;

@Getter
public abstract class AbstractJsonModelsRegistry implements JsonModelsRegistry {

    protected final JsonModelsGroup group;

    public AbstractJsonModelsRegistry(@NotNull JsonModelsGroup group) {
        this.group = group;
    }

    protected final void registerImplementationAlias(@NotNull Class<?> implementationType) {
        ModuleRegistrator.jsonSerializationService().registerImplementationAlias(implementationType);
    }

    protected final void registerImplementationAliases(@NotNull Class<?>... implementationTypes) {
        Validate.notEmpty(implementationTypes, "implementationTypes");

        JsonSerializationService jsonSerializationService = ModuleRegistrator.jsonSerializationService();
        for(Class<?> implementationType : implementationTypes) {
            jsonSerializationService.registerImplementationAlias(implementationType);
        }
    }

}
