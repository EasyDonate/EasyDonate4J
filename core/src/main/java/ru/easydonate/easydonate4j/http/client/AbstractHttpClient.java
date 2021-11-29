package ru.easydonate.easydonate4j.http.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.response.HttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Getter
public abstract class AbstractHttpClient implements HttpClient {

    protected final String userAgent;
    protected final Timeouts timeouts;

    public AbstractHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        Validate.notEmpty(userAgent, "userAgent");
        Validate.notNull(timeouts, "timeouts");

        this.userAgent = userAgent;
        this.timeouts = timeouts;
    }

    @Override
    public @NotNull HttpResponse requestGet(@NotNull String url) throws HttpRequestException {
        return requestGet(url, Headers.EMPTY, QueryParams.EMPTY);
    }

    @Override
    public @NotNull HttpResponse requestGet(@NotNull String url, @NotNull QueryParams queryParams) throws HttpRequestException {
        return requestGet(url, Headers.EMPTY, queryParams);
    }

    @Override
    public @NotNull HttpResponse requestGet(@NotNull String url, @NotNull Headers headers) throws HttpRequestException {
        return requestGet(url, headers, QueryParams.EMPTY);
    }

    @Override
    public @NotNull HttpResponse requestGet(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) throws HttpRequestException {
        try {
            return requestGetAsync(url, headers, queryParams).join();
        } catch (CancellationException | CompletionException ex) {
            Throwable cause = ex.getCause();
            if(cause == null)
                throw new HttpRequestException(ex);

            if(cause instanceof HttpRequestException)
                throw (HttpRequestException) cause;
            else
                throw new HttpRequestException(cause);
        }
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url) throws HttpRequestException {
        return requestGetAsync(url, Headers.EMPTY, QueryParams.EMPTY);
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull QueryParams queryParams) throws HttpRequestException {
        return requestGetAsync(url, Headers.EMPTY, queryParams);
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers) throws HttpRequestException {
        return requestGetAsync(url, headers, QueryParams.EMPTY);
    }

}
