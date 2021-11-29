package ru.easydonate.easydonate4j.v3.response.plugin.yandex.metrika;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.YANDEX_METRIKA, apiMethod = "getEmbed")
public interface YandexMetrikaGetEmbedResponse extends ApiResponse<String> {
}
