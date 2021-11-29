package ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountResponse;

@Implementing(SurchargeGetDiscountResponse.class)
public final class GsonSurchargeGetDiscountResponse extends GsonApiResponse<SurchargeDiscount> implements SurchargeGetDiscountResponse {

    @Override
    public @NotNull String toString() {
        return "GsonSurchargeGetDiscountResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
