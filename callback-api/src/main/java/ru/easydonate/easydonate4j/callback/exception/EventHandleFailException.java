package ru.easydonate.easydonate4j.callback.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EventHandleFailException extends RuntimeException {

    public EventHandleFailException(@NotNull String message, @Nullable Object... args) {
        super(String.format(message, args));
    }

    public EventHandleFailException(@NotNull Throwable cause) {
        super(cause);
    }

}
