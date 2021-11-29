package ru.easydonate.easydonate4j.v3.response.plugin.discord.widget;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.DISCORD_WIDGET, apiMethod = "getSettings")
public interface DiscordWidgetGetSettingsResponse extends ApiResponse<DiscordWidgetPluginSettings> {
}
