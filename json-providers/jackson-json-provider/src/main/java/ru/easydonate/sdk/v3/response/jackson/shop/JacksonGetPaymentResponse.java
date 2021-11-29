package ru.easydonate.sdk.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.Payment;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetPaymentResponse;

@Implementing(GetPaymentResponse.class)
public final class JacksonGetPaymentResponse extends JacksonApiResponse<Payment> implements GetPaymentResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetPaymentResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
