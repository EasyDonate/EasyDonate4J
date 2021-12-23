package ru.easydonate.easydonate4j.api.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.CreatePaymentResponse;

@Implementing(CreatePaymentResponse.class)
public final class JacksonCreatePaymentResponse extends JacksonApiResponse<PendingPayment> implements CreatePaymentResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonCreatePaymentResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
