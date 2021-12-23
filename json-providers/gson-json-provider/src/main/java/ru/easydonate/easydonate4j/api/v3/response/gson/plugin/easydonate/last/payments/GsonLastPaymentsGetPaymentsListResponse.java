package ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.easydonate.last.payments.LastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(LastPaymentsGetPaymentsListResponse.class)
public final class GsonLastPaymentsGetPaymentsListResponse extends GsonApiResponse<PaymentsList> implements LastPaymentsGetPaymentsListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonLastPaymentsGetPaymentsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
