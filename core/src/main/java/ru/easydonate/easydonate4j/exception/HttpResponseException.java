package ru.easydonate.easydonate4j.exception;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

@Getter
public class HttpResponseException extends Exception {

    protected final EasyHttpResponse response;

    public HttpResponseException(@NotNull EasyHttpResponse response, @NotNull String message) {
        this(response, message, null);
    }

    public HttpResponseException(@NotNull EasyHttpResponse response, @NotNull Throwable cause) {
        this(response, cause.getMessage(), cause);
    }

    public HttpResponseException(@NotNull EasyHttpResponse response, @NotNull String message, @Nullable Throwable cause) {
        super(message, cause);
        this.response = response;
    }

}
