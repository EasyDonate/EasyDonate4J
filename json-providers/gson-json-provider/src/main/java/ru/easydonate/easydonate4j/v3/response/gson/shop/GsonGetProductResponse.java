package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.Product;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetProductResponse;

@Implementing(GetProductResponse.class)
public final class GsonGetProductResponse extends GsonApiResponse<Product> implements GetProductResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetProductResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
