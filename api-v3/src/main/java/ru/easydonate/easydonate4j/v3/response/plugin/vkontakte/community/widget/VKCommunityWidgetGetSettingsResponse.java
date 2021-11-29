package ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettings;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_COMMUNITY_WIDGET, apiMethod = "getSettings")
public interface VKCommunityWidgetGetSettingsResponse extends ApiResponse<VKCommunityWidgetPluginSettings> {
}
