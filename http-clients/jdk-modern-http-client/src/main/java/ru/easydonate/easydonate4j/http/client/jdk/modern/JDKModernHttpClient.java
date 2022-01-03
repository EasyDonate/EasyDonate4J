package ru.easydonate.easydonate4j.http.client.jdk.modern;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.http.response.SimpleEasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class JDKModernHttpClient extends AbstractHttpClient {

    private final HttpClient client;

    public JDKModernHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts, @Nullable String apiEndpoint) {
        super(userAgent, timeouts, apiEndpoint);

        HttpClient.Builder builder = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .version(HttpClient.Version.HTTP_2);

        if(timeouts.getConnectTimeout() > 0L)
            builder.connectTimeout(Duration.ofMillis(timeouts.getConnectTimeout()));

        this.client = builder.build();
    }

    @Override
    public @NotNull CompletableFuture<EasyHttpResponse> executeAsync(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        Validate.notNull(httpRequest, "httpRequest");

        String url = httpRequest.resolveUrl();
        Method method = httpRequest.getMethod();
        Headers headers = httpRequest.getHeaders();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .method(method.getName(), resolveBodyPublisher(method, httpRequest.getBody()))
                .setHeader("User-Agent", Constants.USER_AGENT)
                .uri(URI.create(url));

        if(headers != null)
            headers.getAsMap().forEach(requestBuilder::setHeader);

        if(timeouts.getResponseTimeout() > 0L)
            requestBuilder.timeout(Duration.ofMillis(timeouts.getResponseTimeout()));

        return client.sendAsync(requestBuilder.build(), new ResponseBodyHandler()).thenApply(this::parseResponse);
    }

    private @NotNull HttpRequest.BodyPublisher resolveBodyPublisher(@NotNull Method method, @Nullable String body) {
        if(method.isHasBody() && body != null)
            return HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8);
        else
            return HttpRequest.BodyPublishers.noBody();
    }

    private @NotNull EasyHttpResponse parseResponse(@NotNull HttpResponse<String> httpResponse) {
        int responseCode = httpResponse.statusCode();
        String content = httpResponse.body();
        return new SimpleEasyHttpResponse(responseCode, "<not provided>", content);
    }

}
