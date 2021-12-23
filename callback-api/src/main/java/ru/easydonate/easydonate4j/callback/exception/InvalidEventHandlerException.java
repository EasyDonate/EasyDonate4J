package ru.easydonate.easydonate4j.callback.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;

public final class InvalidEventHandlerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Failed to register %s#%s() as an event handler: %s";

    public InvalidEventHandlerException(@NotNull Method method, @NotNull String message, @Nullable Object... args) {
        super(String.format(MESSAGE_FORMAT, method.getDeclaringClass().getName(), method.getName(), String.format(message, args)));
    }

}
