package ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountResponse;

@Implementing(SurchargeGetDiscountResponse.class)
public final class JacksonSurchargeGetDiscountResponse extends JacksonApiResponse<SurchargeDiscount> implements SurchargeGetDiscountResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonSurchargeGetDiscountResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
