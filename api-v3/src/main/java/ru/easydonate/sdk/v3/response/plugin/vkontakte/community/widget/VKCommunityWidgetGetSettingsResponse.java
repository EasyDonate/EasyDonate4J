package ru.easydonate.sdk.v3.response.plugin.vkontakte.community.widget;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettings;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_COMMUNITY_WIDGET, apiMethod = "getSettings")
public interface VKCommunityWidgetGetSettingsResponse extends ApiResponse<VKCommunityWidgetPluginSettings> {
}
