package ru.easydonate.easydonate4j.api.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetMassSalesListResponse;

@Implementing(GetMassSalesListResponse.class)
public final class JacksonGetMassSalesListResponse extends JacksonApiResponse<MassSalesList> implements GetMassSalesListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetMassSalesListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
