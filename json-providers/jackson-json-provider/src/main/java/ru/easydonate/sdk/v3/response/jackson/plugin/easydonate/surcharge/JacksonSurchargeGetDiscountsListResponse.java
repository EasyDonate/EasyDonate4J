package ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountsListResponse;

@Implementing(SurchargeGetDiscountsListResponse.class)
public final class JacksonSurchargeGetDiscountsListResponse extends JacksonApiResponse<SurchargeDiscountsList> implements SurchargeGetDiscountsListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonSurchargeGetDiscountsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
