package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.Shop;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetShopResponse;

@Implementing(GetShopResponse.class)
public final class GsonGetShopResponse extends GsonApiResponse<Shop> implements GetShopResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetShopResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
