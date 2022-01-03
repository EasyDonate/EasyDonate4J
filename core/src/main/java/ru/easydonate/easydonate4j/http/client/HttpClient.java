package ru.easydonate.easydonate4j.http.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface HttpClient {

    @NotNull Optional<String> getApiEndpoint();

    @NotNull String getUserAgent();

    @NotNull Timeouts getTimeouts();

    @NotNull EasyHttpRequest.Builder createRequest(@NotNull Method method);

    @NotNull EasyHttpResponse execute(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException;

    @NotNull CompletableFuture<EasyHttpResponse> executeAsync(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException;

    interface Builder {

        @NotNull HttpClient create();

        @NotNull Builder setApiEndpoint(@NotNull String apiEndpoint);

        @NotNull Builder setConnectTimeout(long connectTimeout);

        @NotNull Builder setResponseTimeout(long responseTimeout);

        @NotNull Builder setReadTimeout(long readTimeout);

        @NotNull Builder setWriteTimeout(long writeTimeout);

        @NotNull Builder setUserAgent(@NotNull String userAgent);

    }

    interface Timeouts {

        long getConnectTimeout();

        long getResponseTimeout();

        long getReadTimeout();

        long getWriteTimeout();

    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    enum Method {

        GET("GET", false),
        POST("POST", true);

        private final String name;
        private final boolean hasBody;

    }

}
