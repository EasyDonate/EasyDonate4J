package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;

@FunctionalInterface
public interface PluginRequestExecutor {

    <T> @NotNull T executeRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @Nullable Headers headers,
            @Nullable QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException;

}
