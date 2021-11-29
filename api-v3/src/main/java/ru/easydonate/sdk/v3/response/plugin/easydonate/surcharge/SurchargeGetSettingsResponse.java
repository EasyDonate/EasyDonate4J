package ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge;

import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargePluginSettings;
import ru.easydonate.sdk.v3.response.ApiResponse;
import ru.easydonate.sdk.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.SURCHARGE, apiMethod = "getSettings")
public interface SurchargeGetSettingsResponse extends ApiResponse<SurchargePluginSettings> {
}
