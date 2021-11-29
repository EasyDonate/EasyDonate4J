package ru.easydonate.easydonate4j.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetProductsListResponse;

@Implementing(GetProductsListResponse.class)
public final class JacksonGetProductsListResponse extends JacksonApiResponse<ProductsList> implements GetProductsListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetProductsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
