package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetPaymentsListResponse;

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
