package ru.easydonate.easydonate4j.http.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Getter
public abstract class AbstractHttpClient implements HttpClient {

    protected final String apiEndpoint;
    protected final String userAgent;
    protected final Timeouts timeouts;

    public AbstractHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts, @Nullable String apiEndpoint) {
        Validate.notEmpty(userAgent, "userAgent");
        Validate.notNull(timeouts, "timeouts");

        this.apiEndpoint = apiEndpoint;
        this.userAgent = userAgent;
        this.timeouts = timeouts;
    }

    @Override
    public @NotNull Optional<String> getApiEndpoint() {
        return Optional.ofNullable(apiEndpoint);
    }

    @Override
    public @NotNull EasyHttpRequest.Builder createRequest(@NotNull Method method) {
        EasyHttpRequest.Builder builder = EasyHttpRequest.builder(this, method);

        if(apiEndpoint != null)
            builder.setApiEndpoint(apiEndpoint);

        return builder;
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
