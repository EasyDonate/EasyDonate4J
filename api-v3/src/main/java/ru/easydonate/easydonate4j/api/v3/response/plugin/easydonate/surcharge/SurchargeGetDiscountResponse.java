package ru.easydonate.easydonate4j.api.v3.response.plugin.easydonate.surcharge;

import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.SURCHARGE, apiMethod = "getDiscountFor")
public interface SurchargeGetDiscountResponse extends ApiResponse<SurchargeDiscount> {
}
