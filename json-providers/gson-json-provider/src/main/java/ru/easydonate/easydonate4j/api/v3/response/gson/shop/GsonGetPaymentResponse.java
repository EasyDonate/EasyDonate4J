package ru.easydonate.easydonate4j.api.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetPaymentResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

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
