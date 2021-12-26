package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.news.VKNewsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;

/**
 * The interface that represents a plugin manager for your shop.
 * @author soknight
 */
public interface PluginManager {

    /**
     * Get the used API client instance.
     * @return The API client instance.
     */
    @NotNull EasyDonateClient getClient();

    /**
     * Get the EasyDonate Surcharge plugin instance.
     * @return The Surcharge plugin.
     */
    @NotNull SurchargePlugin getSurchargePlugin();

    /**
     * Get the EasyDonate Last Payments' plugin instance.
     * @return The Last Payments plugin.
     */
    @NotNull LastPaymentsPlugin getLastPaymentsPlugin();

    /**
     * Get the EasyDonate Custom Messages' plugin instance.
     * @return The Custom Messages plugin.
     */
    @NotNull CustomMessagesPlugin getCustomMessagesPlugin();

    /**
     * Get the Discord Widget plugin instance.
     * @return The Discord Widget plugin.
     */
    @NotNull DiscordWidgetPlugin getDiscordWidgetPlugin();

    /**
     * Get the VKontakte Community Widget plugin instance.
     * @return The VK Community Widget plugin.
     */
    @NotNull VKCommunityWidgetPlugin getVKCommunityWidgetPlugin();

    /**
     * Get the VKontakte Messages Widget plugin instance.
     * @return The VK Messages Widget plugin.
     */
    @NotNull VKMessagesWidgetPlugin getVKMessagesWidgetPlugin();

    /**
     * Get the VKontakte News plugin instance.
     * @return The VK News plugin.
     */
    @NotNull VKNewsPlugin getVKNewsPlugin();

    /**
     * Get the Yandex.Metrika plugin instance.
     * @return The Yandex.Metrika plugin.
     */
    @NotNull YandexMetrikaPlugin getYandexMetrikaPlugin();

}
