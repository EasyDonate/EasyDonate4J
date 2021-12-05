package ru.easydonate.easydonate4j.v3.json.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.AbstractJsonSerializationService;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationServiceType;
import ru.easydonate.easydonate4j.module.ModuleAlreadyRegisteredException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.module.ModuleType;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.discord.widget.DiscordWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.custom.messages.CustomMessagesPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.last.payments.LastPaymentsPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.surcharge.SurchargeDiscountModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.surcharge.SurchargeDiscountsListModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.surcharge.SurchargePluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.vkontakte.news.VKNewsPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.plugin.yandex.metrika.YandexMetrikaPluginSettingsModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.ShopModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.coupon.CouponModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.coupon.CouponsListModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.mass.sale.MassSaleModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.mass.sale.MassSalesListModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.payment.PaymentModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.payment.PaymentsListModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.payment.SentCommandModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.payment.pending.PendingPaymentModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.product.ProductModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.product.ProductsListModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.purchase.*;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.server.ServerModel;
import ru.easydonate.easydonate4j.v3.data.model.gson.shop.server.ServersListModel;
import ru.easydonate.easydonate4j.v3.json.serialization.deserializer.gson.BooleanIntDeserializer;
import ru.easydonate.easydonate4j.v3.json.serialization.deserializer.gson.LocalDateTimeAdapter;
import ru.easydonate.easydonate4j.v3.json.serialization.exclusion.GsonDeserializationExclusionStrategy;
import ru.easydonate.easydonate4j.v3.json.serialization.exclusion.GsonSerializationExclusionStrategy;
import ru.easydonate.easydonate4j.v3.response.gson.GsonErrorResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.discord.widget.GsonDiscordWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.discord.widget.GsonDiscordWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.custom.messages.GsonCustomMessagesGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.last.payments.GsonLastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.last.payments.GsonLastPaymentsGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetDiscountResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetDiscountsListResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.surcharge.GsonSurchargeGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.community.widget.GsonVKCommunityWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.community.widget.GsonVKCommunityWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.messages.widget.GsonVKMessagesWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.messages.widget.GsonVKMessagesWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.news.GsonVKNewsGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.yandex.metrika.GsonYandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.gson.plugin.yandex.metrika.GsonYandexMetrikaGetSettingsResponse;
import ru.easydonate.easydonate4j.v3.response.gson.shop.*;

import java.time.LocalDateTime;

public final class GsonSerializationService extends AbstractJsonSerializationService {

    private final Gson defaultGson;
    private final Gson prettyGson;

    public GsonSerializationService() {
        TypeAdapterFactory typeAdapterFactory = new GsonTypeAdapterResolver(this);

        this.defaultGson = patchGsonBuilder(typeAdapterFactory, new GsonBuilder()).create();
        this.prettyGson = patchGsonBuilder(typeAdapterFactory, new GsonBuilder()).setPrettyPrinting().create();

        registerShopModels();
        registerShopResponses();

        registerPluginModels();
        registerPluginResponses();
    }

    public static void register() throws ModuleAlreadyRegisteredException {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        ModuleRegistrator.get().registerJsonSerializationService(new GsonSerializationService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.jsonSerializationServiceRegistered(GsonSerializationService.class);
    }

    @Override
    public @NotNull JsonSerializationServiceType getType() {
        return JsonSerializationServiceType.GSON;
    }

    @Override
    public @Nullable String serialize(@Nullable Object object) throws JsonSerializationException {
        try {
            return defaultGson.toJson(object);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException {
        try {
            return defaultGson.fromJson(rawJson, type);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException {
        try {
            return prettyGson.toJson(object);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    private @NotNull GsonBuilder patchGsonBuilder(@NotNull TypeAdapterFactory typeAdapterFactory, @NotNull GsonBuilder gsonBuilder) {
        gsonBuilder.serializeNulls();
        gsonBuilder.disableHtmlEscaping();

        gsonBuilder.addSerializationExclusionStrategy(GsonSerializationExclusionStrategy.getSingleton());
        gsonBuilder.addDeserializationExclusionStrategy(GsonDeserializationExclusionStrategy.getSingleton());

        gsonBuilder.registerTypeAdapter(boolean.class, BooleanIntDeserializer.getSingleton());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, LocalDateTimeAdapter.getSingleton());

        gsonBuilder.registerTypeAdapterFactory(typeAdapterFactory);
        return gsonBuilder;
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
        registerImplementationAlias(GsonErrorResponse.class);
        registerImplementationAlias(GsonCreatePaymentResponse.class);
        registerImplementationAlias(GsonGetCouponsListResponse.class);
        registerImplementationAlias(GsonGetMassSalesListResponse.class);
        registerImplementationAlias(GsonGetPaymentResponse.class);
        registerImplementationAlias(GsonGetPaymentsListResponse.class);
        registerImplementationAlias(GsonGetProductResponse.class);
        registerImplementationAlias(GsonGetProductsListResponse.class);
        registerImplementationAlias(GsonGetServerResponse.class);
        registerImplementationAlias(GsonGetServersListResponse.class);
        registerImplementationAlias(GsonGetShopResponse.class);
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
        registerImplementationAlias(GsonSurchargeGetSettingsResponse.class);
        registerImplementationAlias(GsonSurchargeGetDiscountResponse.class);
        registerImplementationAlias(GsonSurchargeGetDiscountsListResponse.class);

        // --- last payments plugin
        registerImplementationAlias(GsonLastPaymentsGetSettingsResponse.class);
        registerImplementationAlias(GsonLastPaymentsGetPaymentsListResponse.class);

        // --- custom messages plugin
        registerImplementationAlias(GsonCustomMessagesGetSettingsResponse.class);

        // --- Discord widget plugin
        registerImplementationAlias(GsonDiscordWidgetGetSettingsResponse.class);
        registerImplementationAlias(GsonDiscordWidgetGetEmbedResponse.class);

        // --- VK community widget plugin
        registerImplementationAlias(GsonVKCommunityWidgetGetSettingsResponse.class);
        registerImplementationAlias(GsonVKCommunityWidgetGetEmbedResponse.class);

        // --- VK messages widget plugin
        registerImplementationAlias(GsonVKMessagesWidgetGetSettingsResponse.class);
        registerImplementationAlias(GsonVKMessagesWidgetGetEmbedResponse.class);

        // --- VK news plugin
        registerImplementationAlias(GsonVKNewsGetSettingsResponse.class);

        // --- Yandex metrika plugin
        registerImplementationAlias(GsonYandexMetrikaGetSettingsResponse.class);
        registerImplementationAlias(GsonYandexMetrikaGetEmbedResponse.class);
    }

}
