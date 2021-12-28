package ru.easydonate.easydonate4j.http.client.apache;

import lombok.Getter;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleRequestProducer;
import org.apache.hc.client5.http.async.methods.SimpleResponseConsumer;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.http.ContentType;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

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
    public @NotNull CompletableFuture<EasyHttpResponse> executeAsync(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        Validate.notNull(httpRequest, "httpRequest");

        String url = httpRequest.resolveUrl();
        Method method = httpRequest.getMethod();
        Headers headers = httpRequest.getHeaders();

        SimpleHttpRequest request = new SimpleHttpRequest(method.getName(), url);
        if(headers != null)
            headers.getAsMap().forEach(request::setHeader);

        if(method.isHasBody() && httpRequest.hasBody())
            request.setBody(httpRequest.getBody(), ContentType.APPLICATION_JSON);

        CompletableFuture<EasyHttpResponse> future = new CompletableFuture<>();
        client.execute(SimpleRequestProducer.create(request), SimpleResponseConsumer.create(), new FuturedCallback(future));
        return future;
    }

}
