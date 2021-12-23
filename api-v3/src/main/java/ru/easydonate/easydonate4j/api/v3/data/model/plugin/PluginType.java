package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PluginType {

    SURCHARGE("EasyDonate", "Surcharge", "easydonate/surcharge", SurchargePlugin.class),
    LAST_PAYMENTS("EasyDonate", "LastPayments", "easydonate/last-payments", LastPaymentsPlugin.class),
    CUSTOM_MESSAGES("EasyDonate", "CustomMessages", "easydonate/custom-messages", Plugin.class),
    DISCORD_WIDGET("Discord", "Widget", "discord/widget", Plugin.class),
    VK_NEWS("Vkontakte", "News", "vkontakte/news", Plugin.class),
    VK_COMMUNITY_WIDGET("Vkontakte", "Widget", "vkontakte/community-widget", Plugin.class),
    VK_MESSAGES_WIDGET("Vkontakte", "MessagesWidget", "vkontakte/messages-widget", Plugin.class),
    YANDEX_METRIKA("Yandex", "Metrika", "yandex/metrika", YandexMetrikaPlugin.class);

    private final String provider;
    private final String name;
    private final String testingJsonResourceName;
    private final Class<? extends Plugin> pluginClass;

    public @NotNull String getApiName() {
        return String.format("%s.%s", provider, name);
    }

    @Override
    public @NotNull String toString() {
        return "PluginType{" +
                "provider=" + provider +
                ", name='" + name + '\'' +
                ", testingJsonResourceName='" + testingJsonResourceName + '\'' +
                ", pluginClass=" + pluginClass +
                '}';
    }

}
