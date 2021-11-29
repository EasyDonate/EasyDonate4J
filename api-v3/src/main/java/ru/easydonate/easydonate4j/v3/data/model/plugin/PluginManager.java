package ru.easydonate.easydonate4j.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.v3.data.model.plugin.discord.widget.DiscordWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.news.VKNewsPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;

public interface PluginManager {

    @NotNull EasyDonateClient getClient();

    @NotNull SurchargePlugin getSurchargePlugin();

    @NotNull LastPaymentsPlugin getLastPaymentsPlugin();

    @NotNull CustomMessagesPlugin getCustomMessagesPlugin();

    @NotNull DiscordWidgetPlugin getDiscordWidgetPlugin();

    @NotNull VKCommunityWidgetPlugin getVKCommunityWidgetPlugin();

    @NotNull VKMessagesWidgetPlugin getVKMessagesWidgetPlugin();

    @NotNull VKNewsPlugin getVKNewsPlugin();

    @NotNull YandexMetrikaPlugin getYandexMetrikaPlugin();

}
