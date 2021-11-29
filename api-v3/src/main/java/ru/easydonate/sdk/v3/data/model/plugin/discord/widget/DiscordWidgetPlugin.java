package ru.easydonate.sdk.v3.data.model.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.v3.client.EasyDonateClient;
import ru.easydonate.sdk.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.sdk.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.plugin.discord.widget.DiscordWidgetGetEmbedResponse;
import ru.easydonate.sdk.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;

public final class DiscordWidgetPlugin extends AbstractPlugin {

    public DiscordWidgetPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.DISCORD_WIDGET);
    }

    @Override
    public @NotNull DiscordWidgetPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(DiscordWidgetGetSettingsResponse.class, null, null);
    }

    public @NotNull String getEmbed() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(DiscordWidgetGetEmbedResponse.class, null, null);
    }

}
