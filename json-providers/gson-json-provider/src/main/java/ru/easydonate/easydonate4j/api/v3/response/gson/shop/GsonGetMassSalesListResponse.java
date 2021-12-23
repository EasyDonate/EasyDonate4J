package ru.easydonate.easydonate4j.api.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetMassSalesListResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(GetMassSalesListResponse.class)
public final class GsonGetMassSalesListResponse extends GsonApiResponse<MassSalesList> implements GetMassSalesListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetMassSalesListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
