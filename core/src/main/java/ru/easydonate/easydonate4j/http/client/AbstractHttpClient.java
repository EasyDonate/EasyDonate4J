package ru.easydonate.easydonate4j.http.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.concurrent.CompletableFuture;

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
    public @NotNull EasyHttpResponse execute(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        return executeAsync(httpRequest).join();
    }

    @Override
    public @NotNull CompletableFuture<EasyHttpResponse> executeAsync(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        CompletableFuture<EasyHttpResponse> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                future.complete(execute(httpRequest));
            } catch (HttpRequestException ex) {
                future.completeExceptionally(ex);
            }
        });

        return future;
    }

}
