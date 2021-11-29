package ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPluginSettings;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.last.payments.LastPaymentsGetSettingsResponse;

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
