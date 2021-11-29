package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.CreatePaymentResponse;

@Implementing(CreatePaymentResponse.class)
public final class GsonCreatePaymentResponse extends GsonApiResponse<PendingPayment> implements CreatePaymentResponse {

    @Override
    public @NotNull String toString() {
        return "GsonCreatePaymentResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
