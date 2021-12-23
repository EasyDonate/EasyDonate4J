package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.jackson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonErrorResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.shop.*;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class ShopResponsesRegistry extends AbstractJsonModelsRegistry {

    private static final ShopResponsesRegistry SINGLETON = new ShopResponsesRegistry();

    public ShopResponsesRegistry() {
        super(JsonModelsGroup.API_V3_SHOP_RESPONSES);
    }

    public static @NotNull ShopResponsesRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
                JacksonErrorResponse.class,
                JacksonCreatePaymentResponse.class,
                JacksonGetCouponsListResponse.class,
                JacksonGetMassSalesListResponse.class,
                JacksonGetPaymentResponse.class,
                JacksonGetPaymentsListResponse.class,
                JacksonGetProductResponse.class,
                JacksonGetProductsListResponse.class,
                JacksonGetServerResponse.class,
                JacksonGetServersListResponse.class,
                JacksonGetShopResponse.class
        );
    }

}
