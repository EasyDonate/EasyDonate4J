package ru.easydonate.sdk.v3.response.plugin.vkontakte.messages.widget;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_MESSAGES_WIDGET, apiMethod = "getEmbed")
public interface VKMessagesWidgetGetEmbedResponse extends ApiResponse<String> {
}
