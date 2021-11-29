package ru.easydonate.easydonate4j.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetPaymentsListResponse;

@Implementing(GetPaymentsListResponse.class)
public final class JacksonGetPaymentsListResponse extends JacksonApiResponse<PaymentsList> implements GetPaymentsListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetPaymentsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
