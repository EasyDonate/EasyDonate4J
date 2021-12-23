package ru.easydonate.easydonate4j.callback.event;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.signature.Signature;

public interface Verifiable {

    @NotNull Signature getSignature();

}
