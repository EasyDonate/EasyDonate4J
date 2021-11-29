package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetPaymentResponse;

@Implementing(GetPaymentResponse.class)
public final class GsonGetPaymentResponse extends GsonApiResponse<Payment> implements GetPaymentResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetPaymentResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
