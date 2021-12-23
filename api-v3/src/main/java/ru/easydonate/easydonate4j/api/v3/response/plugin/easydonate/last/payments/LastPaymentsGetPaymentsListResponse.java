package ru.easydonate.easydonate4j.api.v3.response.plugin.easydonate.last.payments;

import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.PluginApiResponse;

@PluginApiResponse(pluginType = PluginType.LAST_PAYMENTS, apiMethod = "getPayments")
public interface LastPaymentsGetPaymentsListResponse extends ApiResponse<PaymentsList> {
}
