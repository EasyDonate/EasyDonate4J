package ru.easydonate.sdk.v3.response.plugin.discord.widget;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.DISCORD_WIDGET, apiMethod = "getEmbed")
public interface DiscordWidgetGetEmbedResponse extends ApiResponse<String> {
}
