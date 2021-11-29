package ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_COMMUNITY_WIDGET, apiMethod = "getEmbed")
public interface VKCommunityWidgetGetEmbedResponse extends ApiResponse<String> {
}
