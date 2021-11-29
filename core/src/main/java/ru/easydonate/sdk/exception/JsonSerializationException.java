package ru.easydonate.sdk.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JsonSerializationException extends Exception {

    public JsonSerializationException(@NotNull String message) {
        this(message, null);
    }

    public JsonSerializationException(@NotNull Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public JsonSerializationException(@NotNull String message, @Nullable Throwable cause) {
        super(message, cause);
    }

}
