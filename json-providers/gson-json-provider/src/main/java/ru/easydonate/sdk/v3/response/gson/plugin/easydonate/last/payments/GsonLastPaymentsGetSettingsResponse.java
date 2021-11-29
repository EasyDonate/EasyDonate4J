package ru.easydonate.sdk.v3.response.gson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPluginSettings;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.last.payments.LastPaymentsGetSettingsResponse;

@Implementing(LastPaymentsGetSettingsResponse.class)
public final class GsonLastPaymentsGetSettingsResponse extends GsonApiResponse<LastPaymentsPluginSettings> implements LastPaymentsGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonLastPaymentsGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
