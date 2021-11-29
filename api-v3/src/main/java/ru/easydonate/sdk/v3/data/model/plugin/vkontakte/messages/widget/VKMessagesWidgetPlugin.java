package ru.easydonate.sdk.v3.data.model.plugin.vkontakte.messages.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.v3.client.EasyDonateClient;
import ru.easydonate.sdk.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.sdk.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetEmbedResponse;
import ru.easydonate.sdk.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetSettingsResponse;

public final class VKMessagesWidgetPlugin extends AbstractPlugin {

    public VKMessagesWidgetPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.VK_MESSAGES_WIDGET);
    }

    @Override
    public @NotNull VKMessagesWidgetPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(VKMessagesWidgetGetSettingsResponse.class, null, null);
    }

    public @NotNull String getEmbed() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(VKMessagesWidgetGetEmbedResponse.class, null, null);
    }

}
