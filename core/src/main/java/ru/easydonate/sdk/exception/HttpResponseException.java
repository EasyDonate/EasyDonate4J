package ru.easydonate.sdk.exception;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.http.response.HttpResponse;

@Getter
public class HttpResponseException extends Exception {

    protected final HttpResponse response;

    public HttpResponseException(@NotNull HttpResponse response, @NotNull String message) {
        this(response, message, null);
    }

    public HttpResponseException(@NotNull HttpResponse response, @NotNull Throwable cause) {
        this(response, cause.getMessage(), cause);
    }

    public HttpResponseException(@NotNull HttpResponse response, @NotNull String message, @Nullable Throwable cause) {
        super(message, cause);
        this.response = response;
    }

}
