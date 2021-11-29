package ru.easydonate.sdk.http.client.jdk.modern;

import org.jetbrains.annotations.NotNull;

import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public final class ResponseBodyHandler implements HttpResponse.BodyHandler<String> {

    @Override
    public @NotNull HttpResponse.BodySubscriber<String> apply(HttpResponse.ResponseInfo responseInfo) {
        return HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);
    }

}
