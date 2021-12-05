package ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetPaymentsListResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetSettingsResponse;

public final class LastPaymentsPlugin extends AbstractPlugin {

    public LastPaymentsPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.LAST_PAYMENTS);
    }

    @Override
    public @NotNull LastPaymentsPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(LastPaymentsGetSettingsResponse.class, null, null);
    }

    public @NotNull PaymentsList getLastPaymentsList() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(LastPaymentsGetPaymentsListResponse.class, null, null);
    }

}
