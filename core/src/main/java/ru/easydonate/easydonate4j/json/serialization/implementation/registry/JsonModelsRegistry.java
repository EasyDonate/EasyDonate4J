package ru.easydonate.easydonate4j.json.serialization.implementation.registry;

import org.jetbrains.annotations.NotNull;

public interface JsonModelsRegistry {

    @NotNull JsonModelsGroup getGroup();

    void register();

}
