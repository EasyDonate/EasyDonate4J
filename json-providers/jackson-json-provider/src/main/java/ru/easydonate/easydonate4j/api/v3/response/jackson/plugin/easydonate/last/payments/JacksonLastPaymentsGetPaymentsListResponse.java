package ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.easydonate.last.payments.LastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(LastPaymentsGetPaymentsListResponse.class)
public final class JacksonLastPaymentsGetPaymentsListResponse extends JacksonApiResponse<PaymentsList> implements LastPaymentsGetPaymentsListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonLastPaymentsGetPaymentsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
