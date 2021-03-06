package ru.easydonate.easydonate4j.json.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public interface JsonSerializationService {

    @NotNull JsonSerializationServiceType getType();

    @NotNull <T> Class<? extends T> findRegisteredImplementation(@NotNull Class<T> type);

    <T> void registerImplementationAlias(@NotNull Class<T> interfaceType, @NotNull Class<? extends T> implementationType);

    <T> void registerImplementationAlias(@NotNull Class<? extends T> implementationType);

    <T> void registerImplementationAliasesGroup(@NotNull JsonModelsGroup jsonModelsGroup);

    @Nullable String serialize(@Nullable Object object) throws JsonSerializationException;

    @Nullable <T> T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException;

    /**
     * Print this object to pretty JSON string.
     * @param object The object to serialize to pretty JSON string.
     * @return The pretty JSON string.
     * @throws JsonSerializationException if any exceptions has been throwed during the json serialization.
     */
    @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException;

}
