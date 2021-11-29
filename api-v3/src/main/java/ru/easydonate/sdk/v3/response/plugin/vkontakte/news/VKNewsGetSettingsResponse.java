package ru.easydonate.sdk.v3.response.plugin.vkontakte.news;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.data.model.plugin.vkontakte.news.VKNewsPluginSettings;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_NEWS, apiMethod = "getSettings")
public interface VKNewsGetSettingsResponse extends ApiResponse<VKNewsPluginSettings> {
}
