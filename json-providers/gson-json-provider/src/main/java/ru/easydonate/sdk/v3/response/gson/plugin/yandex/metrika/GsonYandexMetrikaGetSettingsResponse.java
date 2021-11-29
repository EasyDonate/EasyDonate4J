package ru.easydonate.sdk.v3.response.gson.plugin.yandex.metrika;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.yandex.metrika.YandexMetrikaPluginSettings;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.yandex.metrika.YandexMetrikaGetSettingsResponse;

@Implementing(YandexMetrikaGetSettingsResponse.class)
public final class GsonYandexMetrikaGetSettingsResponse extends GsonApiResponse<YandexMetrikaPluginSettings> implements YandexMetrikaGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonYandexMetrikaGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
