package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonErrorResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.shop.*;
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
                GsonErrorResponse.class,
                GsonCreatePaymentResponse.class,
                GsonGetCouponsListResponse.class,
                GsonGetMassSalesListResponse.class,
                GsonGetPaymentResponse.class,
                GsonGetPaymentsListResponse.class,
                GsonGetProductResponse.class,
                GsonGetProductsListResponse.class,
                GsonGetServerResponse.class,
                GsonGetServersListResponse.class,
                GsonGetShopResponse.class
        );
    }

}
