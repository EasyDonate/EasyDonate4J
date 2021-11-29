package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetPaymentsListResponse;

@Implementing(GetPaymentsListResponse.class)
public final class GsonGetPaymentsListResponse extends GsonApiResponse<PaymentsList> implements GetPaymentsListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetPaymentsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
