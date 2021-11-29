package ru.easydonate.sdk.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.http.Headers;
import ru.easydonate.sdk.http.QueryParams;
import ru.easydonate.sdk.v3.response.ApiResponse;

@FunctionalInterface
public interface PluginRequestExecutor {

    <T> @NotNull T executeRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @Nullable Headers headers,
            @Nullable QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException;

}
