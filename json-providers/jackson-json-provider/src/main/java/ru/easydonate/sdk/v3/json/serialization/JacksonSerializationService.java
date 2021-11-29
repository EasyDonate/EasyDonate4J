package ru.easydonate.sdk.v3.json.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.sdk.exception.JsonSerializationException;
import ru.easydonate.sdk.json.serialization.AbstractJsonSerializationService;
import ru.easydonate.sdk.json.serialization.JsonSerializationServiceType;
import ru.easydonate.sdk.module.ModuleAlreadyRegisteredException;
import ru.easydonate.sdk.module.ModuleRegistrator;
import ru.easydonate.sdk.module.ModuleType;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.discord.widget.DiscordWidgetPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.custom.messages.CustomMessagesPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.last.payments.LastPaymentsPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargeDiscountModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargeDiscountsListModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.surcharge.SurchargePluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.vkontakte.news.VKNewsPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.plugin.yandex.metrika.YandexMetrikaPluginSettingsModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.AdditionalFieldModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.ShopModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.coupon.CouponModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.coupon.CouponsListModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.mass.sale.MassSaleModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.mass.sale.MassSalesListModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.payment.PaymentModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.payment.PaymentsListModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.payment.SentCommandModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.payment.pending.PendingPaymentModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.product.ProductModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.product.ProductsListModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.purchase.*;
import ru.easydonate.sdk.v3.data.model.jackson.shop.server.ServerModel;
import ru.easydonate.sdk.v3.data.model.jackson.shop.server.ServersListModel;
import ru.easydonate.sdk.v3.response.jackson.JacksonErrorResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.discord.widget.JacksonDiscordWidgetGetEmbedResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.discord.widget.JacksonDiscordWidgetGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.custom.messages.JacksonCustomMessagesGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.last.payments.JacksonLastPaymentsGetPaymentsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.last.payments.JacksonLastPaymentsGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetDiscountResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetDiscountsListResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge.JacksonSurchargeGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.community.widget.JacksonVKCommunityWidgetGetEmbedResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.community.widget.JacksonVKCommunityWidgetGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.messages.widget.JacksonVKMessagesWidgetGetEmbedResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.messages.widget.JacksonVKMessagesWidgetGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.news.JacksonVKNewsGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.yandex.metrika.JacksonYandexMetrikaGetEmbedResponse;
import ru.easydonate.sdk.v3.response.jackson.plugin.yandex.metrika.JacksonYandexMetrikaGetSettingsResponse;
import ru.easydonate.sdk.v3.response.jackson.shop.*;

public final class JacksonSerializationService extends AbstractJsonSerializationService {

    private final ObjectMapper objectMapper;

    public JacksonSerializationService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.registerModule(new JacksonSerializationModule(this));

        registerShopModels();
        registerShopResponses();

        registerPluginModels();
        registerPluginResponses();
    }

    public static void register() throws ModuleAlreadyRegisteredException {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        ModuleRegistrator.get().registerJsonSerializationService(new JacksonSerializationService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.jsonSerializationServiceRegistered(JacksonSerializationService.class);
    }

    @Override
    public @NotNull JsonSerializationServiceType getType() {
        return JsonSerializationServiceType.JACKSON;
    }

    @Override
    public @Nullable String serialize(@Nullable Object object) throws JsonSerializationException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException {
        try {
            return objectMapper.readValue(rawJson, type);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    private void registerShopModels() {
        registerImplementationAlias(AdditionalFieldModel.class);
        registerImplementationAlias(CouponDiscountModel.class);
        registerImplementationAlias(CouponModel.class);
        registerImplementationAlias(CouponsListModel.class);
        registerImplementationAlias(DiscountsModel.class);
        registerImplementationAlias(FilledAdditionalFieldModel.class);
        registerImplementationAlias(MassSaleDiscountModel.class);
        registerImplementationAlias(MassSaleModel.class);
        registerImplementationAlias(MassSalesListModel.class);
        registerImplementationAlias(PaymentModel.class);
        registerImplementationAlias(PaymentsListModel.class);
        registerImplementationAlias(PendingPaymentModel.class);
        registerImplementationAlias(ProductModel.class);
        registerImplementationAlias(ProductsListModel.class);
        registerImplementationAlias(PurchasedProductModel.class);
        registerImplementationAlias(SentCommandModel.class);
        registerImplementationAlias(ServerModel.class);
        registerImplementationAlias(ServersListModel.class);
        registerImplementationAlias(ShopModel.class);
    }

    private void registerShopResponses() {
        registerImplementationAlias(JacksonErrorResponse.class);
        registerImplementationAlias(JacksonCreatePaymentResponse.class);
        registerImplementationAlias(JacksonGetCouponsListResponse.class);
        registerImplementationAlias(JacksonGetMassSalesListResponse.class);
        registerImplementationAlias(JacksonGetPaymentResponse.class);
        registerImplementationAlias(JacksonGetPaymentsListResponse.class);
        registerImplementationAlias(JacksonGetProductResponse.class);
        registerImplementationAlias(JacksonGetProductsListResponse.class);
        registerImplementationAlias(JacksonGetServerResponse.class);
        registerImplementationAlias(JacksonGetServersListResponse.class);
        registerImplementationAlias(JacksonGetShopResponse.class);
    }

    private void registerPluginModels() {
        // --- surcharge plugin
        registerImplementationAlias(SurchargePluginSettingsModel.class);
        registerImplementationAlias(SurchargeDiscountModel.class);
        registerImplementationAlias(SurchargeDiscountsListModel.class);

        // --- last payments plugin
        registerImplementationAlias(LastPaymentsPluginSettingsModel.class);

        // --- custom messages plugin
        registerImplementationAlias(CustomMessagesPluginSettingsModel.class);

        // --- Discord widget plugin
        registerImplementationAlias(DiscordWidgetPluginSettingsModel.class);

        // --- VK community widget plugin
        registerImplementationAlias(VKCommunityWidgetPluginSettingsModel.class);

        // --- VK messages widget plugin
        registerImplementationAlias(VKMessagesWidgetPluginSettingsModel.class);

        // --- VK news plugin
        registerImplementationAlias(VKNewsPluginSettingsModel.class);

        // --- Yandex metrika plugin
        registerImplementationAlias(YandexMetrikaPluginSettingsModel.class);
    }

    private void registerPluginResponses() {
        // --- surcharge plugin
        registerImplementationAlias(JacksonSurchargeGetSettingsResponse.class);
        registerImplementationAlias(JacksonSurchargeGetDiscountResponse.class);
        registerImplementationAlias(JacksonSurchargeGetDiscountsListResponse.class);

        // --- last payments plugin
        registerImplementationAlias(JacksonLastPaymentsGetSettingsResponse.class);
        registerImplementationAlias(JacksonLastPaymentsGetPaymentsResponse.class);

        // --- custom messages plugin
        registerImplementationAlias(JacksonCustomMessagesGetSettingsResponse.class);

        // --- Discord widget plugin
        registerImplementationAlias(JacksonDiscordWidgetGetSettingsResponse.class);
        registerImplementationAlias(JacksonDiscordWidgetGetEmbedResponse.class);

        // --- VK community widget plugin
        registerImplementationAlias(JacksonVKCommunityWidgetGetSettingsResponse.class);
        registerImplementationAlias(JacksonVKCommunityWidgetGetEmbedResponse.class);

        // --- VK messages widget plugin
        registerImplementationAlias(JacksonVKMessagesWidgetGetSettingsResponse.class);
        registerImplementationAlias(JacksonVKMessagesWidgetGetEmbedResponse.class);

        // --- VK news plugin
        registerImplementationAlias(JacksonVKNewsGetSettingsResponse.class);

        // --- Yandex metrika plugin
        registerImplementationAlias(JacksonYandexMetrikaGetSettingsResponse.class);
        registerImplementationAlias(JacksonYandexMetrikaGetEmbedResponse.class);
    }

}
