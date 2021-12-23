package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.jackson;

import org.jetbrains.annotations.NotNull;
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
