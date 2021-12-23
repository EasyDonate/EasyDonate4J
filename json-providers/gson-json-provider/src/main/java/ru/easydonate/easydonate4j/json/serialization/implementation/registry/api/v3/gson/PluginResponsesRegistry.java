package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson;

import org.jetbrains.annotations.NotNull;
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
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class PluginResponsesRegistry extends AbstractJsonModelsRegistry {

    private static final PluginResponsesRegistry SINGLETON = new PluginResponsesRegistry();

    public PluginResponsesRegistry() {
        super(JsonModelsGroup.API_V3_PLUGIN_RESPONSES);
    }

    public static @NotNull PluginResponsesRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
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
