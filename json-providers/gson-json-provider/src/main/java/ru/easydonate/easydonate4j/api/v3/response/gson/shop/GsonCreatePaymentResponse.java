package ru.easydonate.easydonate4j.api.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.CreatePaymentResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

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
