package ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetPaymentsListResponse;

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
