package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetProductsListResponse;

@Implementing(GetProductsListResponse.class)
public final class GsonGetProductsListResponse extends GsonApiResponse<ProductsList> implements GetProductsListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetProductsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
