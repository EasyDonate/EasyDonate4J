package ru.easydonate.easydonate4j.callback.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SignatureVerificationException extends RuntimeException {

    public SignatureVerificationException(@NotNull String message, @Nullable Object... args) {
        super(String.format(message, args));
    }

    public SignatureVerificationException(@NotNull Throwable cause) {
        super(cause);
    }

}
