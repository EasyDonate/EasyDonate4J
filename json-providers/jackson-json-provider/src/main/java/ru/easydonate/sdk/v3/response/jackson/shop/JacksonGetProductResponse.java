package ru.easydonate.sdk.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetProductResponse;

@Implementing(GetProductResponse.class)
public final class JacksonGetProductResponse extends JacksonApiResponse<Product> implements GetProductResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetProductResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
