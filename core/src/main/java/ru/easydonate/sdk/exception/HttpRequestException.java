package ru.easydonate.sdk.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HttpRequestException extends Exception {

    public HttpRequestException(@NotNull String message) {
        this(message, null);
    }

    public HttpRequestException(@NotNull Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public HttpRequestException(@NotNull String message, @Nullable Throwable cause) {
        super(message, cause);
    }

}
