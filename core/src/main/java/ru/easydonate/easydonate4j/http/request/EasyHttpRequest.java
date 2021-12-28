package ru.easydonate.easydonate4j.http.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

import java.util.concurrent.CompletableFuture;

public interface EasyHttpRequest {

    static @NotNull EasyHttpRequest.Builder builder(@NotNull HttpClient client, @NotNull HttpClient.Method method) {
        return SimpleEasyHttpRequest.builder(client, method);
    }

    @NotNull EasyHttpResponse execute() throws HttpRequestException;

    @NotNull CompletableFuture<EasyHttpResponse> executeAsync() throws HttpRequestException;

    @NotNull HttpClient.Method getMethod();

    @Nullable String getApiEndpoint();

    @Nullable String getApiPath();

    @Nullable String getUrl();

    @Nullable QueryParams getQueryParams();

    @Nullable Headers getHeaders();

    @Nullable String getBody();

    boolean hasBody();

    @NotNull String resolveUrl() throws HttpRequestException;

    interface Builder {

        @NotNull EasyHttpRequest build();

        @NotNull Builder setApiEndpoint(@NotNull String apiEndpoint);

        @NotNull Builder setApiPath(@NotNull String apiPath, @Nullable Object... args);

        @NotNull Builder setUrl(@NotNull String url, @Nullable Object... args);

        @NotNull Builder setQueryParams(@Nullable QueryParams queryParams);

        @NotNull Builder setHeaders(@Nullable Headers headers);

        @NotNull Builder setBody(@Nullable String postBody);

    }

}
