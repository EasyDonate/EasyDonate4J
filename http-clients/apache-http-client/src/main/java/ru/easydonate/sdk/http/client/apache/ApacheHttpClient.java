package ru.easydonate.sdk.http.client.apache;

import lombok.Getter;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleRequestProducer;
import org.apache.hc.client5.http.async.methods.SimpleResponseConsumer;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.http.Headers;
import ru.easydonate.sdk.http.QueryParams;
import ru.easydonate.sdk.http.client.AbstractHttpClient;
import ru.easydonate.sdk.http.response.HttpResponse;
import ru.easydonate.sdk.util.Validate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Getter
public class ApacheHttpClient extends AbstractHttpClient {

    private final CloseableHttpAsyncClient client;

    public ApacheHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        super(userAgent, timeouts);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Math.max(0L, timeouts.getConnectTimeout()), TimeUnit.MILLISECONDS)
                .setResponseTimeout(Math.max(0L, timeouts.getResponseTimeout()), TimeUnit.MILLISECONDS)
                .build();

        this.client = HttpAsyncClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setUserAgent(userAgent)
                .build();

        this.client.start();
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) {
        Validate.notNull(url, "url");
        Validate.notNull(headers, "headers");
        Validate.notNull(queryParams, "queryParams");

        SimpleHttpRequest request = new SimpleHttpRequest(Method.GET.name(), url + queryParams.getAsString());
        headers.getAsMap().forEach(request::setHeader);

        CompletableFuture<HttpResponse> future = new CompletableFuture<>();
        client.execute(SimpleRequestProducer.create(request), SimpleResponseConsumer.create(), new FuturedCallback(future));
        return future;
    }

}
