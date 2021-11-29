package ru.easydonate.easydonate4j.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.Shop;
import ru.easydonate.easydonate4j.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetShopResponse;

@Implementing(GetShopResponse.class)
public final class JacksonGetShopResponse extends JacksonApiResponse<Shop> implements GetShopResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetShopResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
