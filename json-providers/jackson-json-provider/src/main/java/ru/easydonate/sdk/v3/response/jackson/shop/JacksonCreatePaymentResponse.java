package ru.easydonate.sdk.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.shop.CreatePaymentResponse;

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
