package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.QueryParams;

@FunctionalInterface
public interface PluginRequestExecutor {

    <T> @NotNull T executeRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @Nullable QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException;

    default <T> @NotNull T executeRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType
    ) throws HttpRequestException, HttpResponseException {
        return executeRequest(responseType, null);
    }

}
