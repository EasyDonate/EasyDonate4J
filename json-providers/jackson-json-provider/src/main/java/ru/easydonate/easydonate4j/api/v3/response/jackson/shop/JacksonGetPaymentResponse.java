package ru.easydonate.easydonate4j.api.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetPaymentResponse;

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
