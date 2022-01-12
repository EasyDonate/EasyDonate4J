package ru.easydonate.easydonate4j.json.serialization.implementation.registry.jackson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.discord.widget.DiscordWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.easydonate.custom.messages.CustomMessagesPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.easydonate.last.payments.LastPaymentsPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargeDiscountModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargeDiscountsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargePluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.vkontakte.news.VKNewsPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.yandex.metrika.YandexMetrikaPluginSettingsModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.ShopModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.coupon.CouponModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.coupon.CouponsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.mass.sale.MassSaleModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.mass.sale.MassSalesListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment.PaymentModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment.PaymentsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment.SentCommandModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.payment.pending.PendingPaymentModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.product.ProductModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.product.ProductsListModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase.*;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.server.ServerModel;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.server.ServersListModel;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonErrorResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.discord.widget.JacksonDiscordWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.discord.widget.JacksonDiscordWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.custom.messages.JacksonCustomMessagesGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.last.payments.JacksonLastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.last.payments.JacksonLastPaymentsGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetDiscountResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetDiscountsListResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.community.widget.JacksonVKCommunityWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.community.widget.JacksonVKCommunityWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.messages.widget.JacksonVKMessagesWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.messages.widget.JacksonVKMessagesWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.news.JacksonVKNewsGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.yandex.metrika.JacksonYandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.yandex.metrika.JacksonYandexMetrikaGetSettingsResponse;
import ru.easydonate.easydonate4j.api.v3.response.jackson.shop.*;
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
                JacksonGetShopResponse.class,
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
                JacksonSurchargeGetSettingsResponse.class,
                JacksonSurchargeGetDiscountResponse.class,
                JacksonSurchargeGetDiscountsListResponse.class,
                JacksonLastPaymentsGetSettingsResponse.class,
                JacksonLastPaymentsGetPaymentsListResponse.class,
                JacksonCustomMessagesGetSettingsResponse.class,
                JacksonDiscordWidgetGetSettingsResponse.class,
                JacksonDiscordWidgetGetEmbedResponse.class,
                JacksonVKCommunityWidgetGetSettingsResponse.class,
                JacksonVKCommunityWidgetGetEmbedResponse.class,
                JacksonVKMessagesWidgetGetSettingsResponse.class,
                JacksonVKMessagesWidgetGetEmbedResponse.class,
                JacksonVKNewsGetSettingsResponse.class,
                JacksonYandexMetrikaGetSettingsResponse.class,
                JacksonYandexMetrikaGetEmbedResponse.class
        );
    }

}
