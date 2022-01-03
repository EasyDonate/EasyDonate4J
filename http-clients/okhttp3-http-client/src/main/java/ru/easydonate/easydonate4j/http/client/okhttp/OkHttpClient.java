package ru.easydonate.easydonate4j.http.client.okhttp;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OkHttpClient extends AbstractHttpClient {

    public static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");

    private final okhttp3.OkHttpClient client;

    public OkHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts, @Nullable String apiEndpoint) {
        super(userAgent, timeouts, apiEndpoint);

        this.client = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(Math.max(0L, timeouts.getConnectTimeout()), TimeUnit.MILLISECONDS)
                .readTimeout(Math.max(0L, timeouts.getReadTimeout()), TimeUnit.MILLISECONDS)
                .writeTimeout(Math.max(0L, timeouts.getWriteTimeout()), TimeUnit.MILLISECONDS)
                .build();
    }

    @Override
    public @NotNull CompletableFuture<EasyHttpResponse> executeAsync(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        Validate.notNull(httpRequest, "httpRequest");

        String url = httpRequest.resolveUrl();
        Method method = httpRequest.getMethod();
        Headers headers = httpRequest.getHeaders();

        Request.Builder requestBuilder = new Request.Builder()
                .method(method.getName(), resolveRequestBody(method, httpRequest.getBody()))
                .header("User-Agent", userAgent)
                .url(url);

        if(headers != null)
            headers.getAsMap().forEach(requestBuilder::header);

        CompletableFuture<EasyHttpResponse> future = new CompletableFuture<>();
        client.newCall(requestBuilder.build()).enqueue(new FuturedCallback(future));
        return future;
    }

    private @Nullable RequestBody resolveRequestBody(@NotNull Method method, @Nullable String body) {
        if(method.isHasBody() && body != null)
            return RequestBody.create(body, MEDIA_TYPE);
        else
            return null;
    }

}
