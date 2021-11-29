package ru.easydonate.easydonate4j.http.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.response.HttpResponse;

import java.util.concurrent.CompletableFuture;

public interface HttpClient {

    @NotNull String getUserAgent();

    @NotNull Timeouts getTimeouts();

    @NotNull HttpResponse requestGet(@NotNull String url) throws HttpRequestException;

    @NotNull HttpResponse requestGet(@NotNull String url, @NotNull QueryParams queryParams) throws HttpRequestException;

    @NotNull HttpResponse requestGet(@NotNull String url, @NotNull Headers headers) throws HttpRequestException;

    @NotNull HttpResponse requestGet(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) throws HttpRequestException;

    @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url) throws HttpRequestException;

    @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull QueryParams queryParams) throws HttpRequestException;

    @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers) throws HttpRequestException;

    @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) throws HttpRequestException;

//    @NotNull CompletableFuture<HttpResponse> requestPost(@NotNull String url, @NotNull String body) throws HttpRequestException;
//
//    @NotNull CompletableFuture<HttpResponse> requestPost(@NotNull String url, @NotNull String body, @NotNull Headers headers) throws HttpRequestException;

    interface Builder {

        @NotNull HttpClient create();

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

        GET("GET"),
        POST("POST");

        private final String name;

    }

}
