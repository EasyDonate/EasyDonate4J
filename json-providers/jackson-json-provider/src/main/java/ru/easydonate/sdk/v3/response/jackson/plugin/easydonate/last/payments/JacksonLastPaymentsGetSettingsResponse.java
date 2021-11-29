package ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.last.payments;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPluginSettings;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.last.payments.LastPaymentsGetSettingsResponse;

@Implementing(LastPaymentsGetSettingsResponse.class)
public final class JacksonLastPaymentsGetSettingsResponse extends JacksonApiResponse<LastPaymentsPluginSettings> implements LastPaymentsGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonLastPaymentsGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
