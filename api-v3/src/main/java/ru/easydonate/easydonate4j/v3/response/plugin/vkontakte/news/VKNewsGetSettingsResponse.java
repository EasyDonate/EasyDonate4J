package ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.news;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.news.VKNewsPluginSettings;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.VK_NEWS, apiMethod = "getSettings")
public interface VKNewsGetSettingsResponse extends ApiResponse<VKNewsPluginSettings> {
}
