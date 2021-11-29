package ru.easydonate.easydonate4j.v3.response.gson.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargePluginSettings;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.surcharge.SurchargeGetSettingsResponse;

@Implementing(SurchargeGetSettingsResponse.class)
public final class GsonSurchargeGetSettingsResponse extends GsonApiResponse<SurchargePluginSettings> implements SurchargeGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonSurchargeGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
