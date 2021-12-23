package ru.easydonate.easydonate4j.callback.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SignatureGenerationException extends RuntimeException {

    public SignatureGenerationException(@NotNull String message, @Nullable Object... args) {
        super(String.format(message, args));
    }

    public SignatureGenerationException(@NotNull Throwable cause) {
        super(cause);
    }

}
