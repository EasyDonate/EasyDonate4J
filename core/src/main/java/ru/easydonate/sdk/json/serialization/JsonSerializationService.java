package ru.easydonate.sdk.json.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.exception.JsonSerializationException;

public interface JsonSerializationService {

    @NotNull JsonSerializationServiceType getType();

    @NotNull <T> Class<? extends T> findRegisteredImplementation(@NotNull Class<T> type);

    <T> void registerImplementationAlias(@NotNull Class<T> interfaceType, @NotNull Class<? extends T> implementationType);

    @Nullable String serialize(@Nullable Object object) throws JsonSerializationException;

    @Nullable <T> T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException;

    /**
     * Print this object to pretty JSON string.
     * @return The pretty JSON string.
     * @throws JsonSerializationException if any exceptions has been throwed during the json serialization.
     */
    @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException;

}
