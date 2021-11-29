package ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.SURCHARGE, apiMethod = "getDiscounts")
public interface SurchargeGetDiscountsListResponse extends ApiResponse<SurchargeDiscountsList> {
}
