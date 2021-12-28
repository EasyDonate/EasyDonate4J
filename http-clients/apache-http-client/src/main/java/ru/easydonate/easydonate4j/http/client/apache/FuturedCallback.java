package ru.easydonate.easydonate4j.http.client.apache;

import lombok.AllArgsConstructor;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.response.SimpleEasyHttpResponse;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
final class FuturedCallback implements FutureCallback<SimpleHttpResponse> {

    private final CompletableFuture<EasyHttpResponse> future;

    @Override
    public void completed(@NotNull SimpleHttpResponse result) {
        future.complete(parseResponse(result));
    }

    @Override
    public void failed(Exception ex) {
        future.completeExceptionally(new HttpRequestException(ex));
    }

    @Override
    public void cancelled() {
        future.cancel(true);
    }

    private @NotNull EasyHttpResponse parseResponse(@NotNull SimpleHttpResponse apacheResponse) {
        int code = apacheResponse.getCode();
        String message = apacheResponse.getReasonPhrase();
        String content = apacheResponse.getBodyText();
        return new SimpleEasyHttpResponse(code, message, content);
    }

}
