package ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.response.plugin.discord.widget.DiscordWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;

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
