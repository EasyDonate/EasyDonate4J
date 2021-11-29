package ru.easydonate.sdk.v3.response.jackson.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargePluginSettings;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetSettingsResponse;

@Implementing(SurchargeGetSettingsResponse.class)
public final class JacksonSurchargeGetSettingsResponse extends JacksonApiResponse<SurchargePluginSettings> implements SurchargeGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonSurchargeGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
