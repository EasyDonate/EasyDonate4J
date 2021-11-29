package ru.easydonate.easydonate4j.v3.data.model.plugin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PluginType {

    SURCHARGE("EasyDonate", "Surcharge", SurchargePlugin.class),
    LAST_PAYMENTS("EasyDonate", "LastPayments", LastPaymentsPlugin.class),
    CUSTOM_MESSAGES("EasyDonate", "CustomMessages", Plugin.class),
    DISCORD_WIDGET("Discord", "Widget", Plugin.class),
    VK_NEWS("Vkontakte", "News", Plugin.class),
    VK_COMMUNITY_WIDGET("Vkontakte", "Widget", Plugin.class),
    VK_MESSAGES_WIDGET("Vkontakte", "MessagesWidget", Plugin.class),
    YANDEX_METRIKA("Yandex", "Metrika", YandexMetrikaPlugin.class);

    private final String provider;
    private final String name;
    private final Class<? extends Plugin> pluginClass;

    public @NotNull String getApiName() {
        return provider + "." + name;
    }

    @Override
    public @NotNull String toString() {
        return "PluginType{" +
                "provider=" + provider +
                ", name=" + name +
                ", pluginClass=" + pluginClass +
                '}';
    }

}
