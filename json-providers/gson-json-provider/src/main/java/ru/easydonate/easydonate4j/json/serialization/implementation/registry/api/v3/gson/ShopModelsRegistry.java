package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.ShopModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.coupon.CouponModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.coupon.CouponsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.mass.sale.MassSaleModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.mass.sale.MassSalesListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.payment.PaymentModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.payment.PaymentsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.payment.SentCommandModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.payment.pending.PendingPaymentModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.product.ProductModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.product.ProductsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.purchase.*;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.server.ServerModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.server.ServersListModel;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class ShopModelsRegistry extends AbstractJsonModelsRegistry {

    private static final ShopModelsRegistry SINGLETON = new ShopModelsRegistry();

    public ShopModelsRegistry() {
        super(JsonModelsGroup.API_V3_SHOP_MODELS);
    }

    public static @NotNull ShopModelsRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
                AdditionalFieldModel.class,
                CouponDiscountModel.class,
                CouponModel.class,
                CouponsListModel.class,
                DiscountsModel.class,
                FilledAdditionalFieldModel.class,
                MassSaleDiscountModel.class,
                MassSaleModel.class,
                MassSalesListModel.class,
                PaymentModel.class,
                PaymentsListModel.class,
                PendingPaymentModel.class,
                ProductModel.class,
                ProductsListModel.class,
                PurchasedProductModel.class,
                SentCommandModel.class,
                ServerModel.class,
                ServersListModel.class,
                ShopModel.class
        );
    }

}
