package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.Payment;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetPaymentResponse;

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
