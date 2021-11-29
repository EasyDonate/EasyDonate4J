package ru.easydonate.sdk.http.client.jdk.modern;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.Constants;
import ru.easydonate.sdk.http.Headers;
import ru.easydonate.sdk.http.QueryParams;
import ru.easydonate.sdk.http.client.AbstractHttpClient;
import ru.easydonate.sdk.http.response.EasyHttpResponse;
import ru.easydonate.sdk.http.response.HttpResponse;
import ru.easydonate.sdk.util.Validate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class JDKModernHttpClient extends AbstractHttpClient {

    private final HttpClient client;

    public JDKModernHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        super(userAgent, timeouts);

        HttpClient.Builder builder = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .version(HttpClient.Version.HTTP_2);

        if(timeouts.getConnectTimeout() > 0L)
            builder.connectTimeout(Duration.ofMillis(timeouts.getConnectTimeout()));

        this.client = builder.build();
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) {
        Validate.notNull(url, "url");
        Validate.notNull(headers, "headers");
        Validate.notNull(queryParams, "queryParams");

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .GET()
                .setHeader("User-Agent", Constants.USER_AGENT)
                .uri(URI.create(url + queryParams.getAsString()));

        headers.getAsMap().forEach(requestBuilder::setHeader);

        if(timeouts.getResponseTimeout() > 0L)
            requestBuilder.timeout(Duration.ofMillis(timeouts.getResponseTimeout()));

        return client.sendAsync(requestBuilder.build(), new ResponseBodyHandler()).thenApply(this::parseResponse);
    }

    private @NotNull HttpResponse parseResponse(@NotNull java.net.http.HttpResponse<String> httpResponse) {
        int responseCode = httpResponse.statusCode();
        String content = httpResponse.body();
        System.out.println("Headers: " + httpResponse.headers().map());
        return new EasyHttpResponse(responseCode, "<not provided>", content);
    }

}
