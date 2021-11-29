package ru.easydonate.easydonate4j.http.client.okhttp;

import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.response.HttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OkHttpClient extends AbstractHttpClient {

    private final okhttp3.OkHttpClient client;

    public OkHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        super(userAgent, timeouts);

        this.client = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(Math.max(0L, timeouts.getConnectTimeout()), TimeUnit.MILLISECONDS)
                .readTimeout(Math.max(0L, timeouts.getReadTimeout()), TimeUnit.MILLISECONDS)
                .writeTimeout(Math.max(0L, timeouts.getWriteTimeout()), TimeUnit.MILLISECONDS)
                .build();
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(
            @NotNull String url,
            @NotNull Headers headers,
            @NotNull QueryParams queryParams
    ) {
        Validate.notNull(url, "url");
        Validate.notNull(headers, "headers");
        Validate.notNull(queryParams, "queryParams");

        Request.Builder requestBuilder = new Request.Builder()
                .get()
                .header("User-Agent", userAgent)
                .url(url + queryParams.getAsString());

        headers.getAsMap().forEach(requestBuilder::header);

        CompletableFuture<HttpResponse> future = new CompletableFuture<>();
        client.newCall(requestBuilder.build()).enqueue(new FuturedCallback(future));
        return future;
    }

}
