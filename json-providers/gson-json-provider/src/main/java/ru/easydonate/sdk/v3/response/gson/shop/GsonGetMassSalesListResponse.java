package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetMassSalesListResponse;

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
