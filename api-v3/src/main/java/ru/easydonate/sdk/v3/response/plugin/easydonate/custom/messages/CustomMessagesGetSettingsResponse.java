package ru.easydonate.sdk.v3.response.plugin.easydonate.custom.messages;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPluginSettings;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.CUSTOM_MESSAGES, apiMethod = "getSettings")
public interface CustomMessagesGetSettingsResponse extends ApiResponse<CustomMessagesPluginSettings> {
}
