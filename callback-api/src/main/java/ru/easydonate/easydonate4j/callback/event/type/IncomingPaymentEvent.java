package ru.easydonate.easydonate4j.callback.event.type;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.callback.client.CallbackApiClient;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.event.Event;
import ru.easydonate.easydonate4j.callback.event.Verifiable;
import ru.easydonate.easydonate4j.callback.signature.Signature;

@Getter
public final class IncomingPaymentEvent extends Event implements Verifiable {

    private final @NotNull Payment payment;
    private final @Nullable Signature signature;

    public IncomingPaymentEvent(
            @NotNull CallbackApiClient client,
            @NotNull Payment payment,
            @Nullable Signature signature
    ) {
        super(client);
        this.payment = payment;
        this.signature = signature;
    }

    @Override
    public @NotNull String toString() {
        return "IncomingPaymentEvent{" +
                "client=" + client +
                ", payment=" + payment +
                '}';
    }

}
