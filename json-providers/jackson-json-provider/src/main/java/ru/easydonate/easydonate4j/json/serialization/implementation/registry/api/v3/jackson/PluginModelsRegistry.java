package ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.jackson;

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
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class PluginModelsRegistry extends AbstractJsonModelsRegistry {

    private static final PluginModelsRegistry SINGLETON = new PluginModelsRegistry();

    public PluginModelsRegistry() {
        super(JsonModelsGroup.API_V3_PLUGIN_MODELS);
    }

    public static @NotNull PluginModelsRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
                SurchargePluginSettingsModel.class,
                SurchargeDiscountModel.class,
                SurchargeDiscountsListModel.class,
                LastPaymentsPluginSettingsModel.class,
                CustomMessagesPluginSettingsModel.class,
                DiscordWidgetPluginSettingsModel.class,
                VKCommunityWidgetPluginSettingsModel.class,
                VKMessagesWidgetPluginSettingsModel.class,
                VKNewsPluginSettingsModel.class,
                YandexMetrikaPluginSettingsModel.class
        );
    }

}
