package ru.easydonate.easydonate4j.json.serialization.implementation.registry.gson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.discord.widget.DiscordWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.custom.messages.CustomMessagesPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.last.payments.LastPaymentsPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.surcharge.SurchargeDiscountModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.surcharge.SurchargeDiscountsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.surcharge.SurchargePluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.vkontakte.news.VKNewsPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.yandex.metrika.YandexMetrikaPluginSettingsModel;
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
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonErrorResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.discord.widget.GsonDiscordWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.discord.widget.GsonDiscordWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.custom.messages.GsonCustomMessagesGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.last.payments.GsonLastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.last.payments.GsonLastPaymentsGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetDiscountResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetDiscountsListResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.community.widget.GsonVKCommunityWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.community.widget.GsonVKCommunityWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.messages.widget.GsonVKMessagesWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.messages.widget.GsonVKMessagesWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.news.GsonVKNewsGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.yandex.metrika.GsonYandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.plugin.yandex.metrika.GsonYandexMetrikaGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.gson.shop.*;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class ApiV3ModelsRegistry extends AbstractJsonModelsRegistry {

    private static final ApiV3ModelsRegistry SINGLETON = new ApiV3ModelsRegistry();

    public ApiV3ModelsRegistry() {
        super(JsonModelsGroup.API_V3_MODELS);
    }

    public static @NotNull ApiV3ModelsRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
                // --- shop models
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
                ShopModel.class,
                // --- shop responses
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
                GsonGetShopResponse.class,
                // --- plugin models
                SurchargePluginSettingsModel.class,
                SurchargeDiscountModel.class,
                SurchargeDiscountsListModel.class,
                LastPaymentsPluginSettingsModel.class,
                CustomMessagesPluginSettingsModel.class,
                DiscordWidgetPluginSettingsModel.class,
                VKCommunityWidgetPluginSettingsModel.class,
                VKMessagesWidgetPluginSettingsModel.class,
                VKNewsPluginSettingsModel.class,
                YandexMetrikaPluginSettingsModel.class,
                // --- plugin responses
                GsonSurchargeGetSettingsResponse.class,
                GsonSurchargeGetDiscountResponse.class,
                GsonSurchargeGetDiscountsListResponse.class,
                GsonLastPaymentsGetSettingsResponse.class,
                GsonLastPaymentsGetPaymentsListResponse.class,
                GsonCustomMessagesGetSettingsResponse.class,
                GsonDiscordWidgetGetSettingsResponse.class,
                GsonDiscordWidgetGetEmbedResponse.class,
                GsonVKCommunityWidgetGetSettingsResponse.class,
                GsonVKCommunityWidgetGetEmbedResponse.class,
                GsonVKMessagesWidgetGetSettingsResponse.class,
                GsonVKMessagesWidgetGetEmbedResponse.class,
                GsonVKNewsGetSettingsResponse.class,
                GsonYandexMetrikaGetSettingsResponse.class,
                GsonYandexMetrikaGetEmbedResponse.class
        );
    }

}
