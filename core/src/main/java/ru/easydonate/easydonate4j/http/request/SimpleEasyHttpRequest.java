package ru.easydonate.easydonate4j.http.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class SimpleEasyHttpRequest implements EasyHttpRequest {

    private final HttpClient client;

    private final HttpClient.Method method;
    private final String apiEndpoint;
    private final String apiPath;
    private final String url;
    private final QueryParams queryParams;
    private final Headers headers;
    private final String body;

    static @NotNull RequestBuilder builder(@NotNull HttpClient client, @NotNull HttpClient.Method method) {
        Validate.notNull(client, "client");
        Validate.notNull(method, "method");
        return new RequestBuilder(client, method);
    }

    @Override
    public @NotNull EasyHttpResponse execute() throws HttpRequestException {
        return client.execute(this);
    }

    @Override
    public @NotNull CompletableFuture<EasyHttpResponse> executeAsync() throws HttpRequestException {
        return client.executeAsync(this);
    }

    @Override
    public boolean hasBody() {
        return body != null;
    }

    @Override
    public @NotNull String resolveUrl() throws HttpRequestException {
        String resolvedUrl;

        if(url != null) {
            resolvedUrl = url;
        } else if(apiEndpoint != null) {
            resolvedUrl = apiEndpoint + (apiPath != null ? apiPath : "");
        } else {
            throw new HttpRequestException("Cannot resolve a request URL with current parameters set!");
        }

        if(queryParams != null && !resolvedUrl.contains("?"))
            resolvedUrl += queryParams.getAsString();

        return resolvedUrl;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    private static final class RequestBuilder implements Builder {

        private final HttpClient client;
        private final HttpClient.Method method;

        private String apiEndpoint;
        private String apiPath;
        private String url;
        private QueryParams queryParams;
        private Headers headers;
        private String body;

        @Override
        public @NotNull EasyHttpRequest build() {
            return new SimpleEasyHttpRequest(client, method, apiEndpoint, apiPath, url, queryParams, headers, body);
        }

        @Override
        public @NotNull Builder setApiEndpoint(@NotNull String apiEndpoint) {
            Validate.notEmpty(apiEndpoint, "apiEndpoint");
            this.apiEndpoint = apiEndpoint;
            return this;
        }

        @Override
        public @NotNull Builder setApiPath(@NotNull String apiPath, @Nullable Object... args) {
            Validate.notNull(apiPath, "apiPath");
            this.apiPath = String.format(apiPath, args);
            return this;
        }

        @Override
        public @NotNull Builder setUrl(@NotNull String url, @Nullable Object... args) {
            Validate.notEmpty(url, "url");
            this.url = String.format(url, args);
            return this;
        }

        @Override
        public @NotNull Builder setQueryParams(@Nullable QueryParams queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        @Override
        public @NotNull Builder setHeaders(@Nullable Headers headers) {
            this.headers = headers;
            return this;
        }

        public @NotNull Builder setBody(@Nullable String postBody) {
            this.body = postBody;
            return this;
        }

    }

}
