package ru.easydonate.sdk.v3.response.gson.plugin.vkontakte.news;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.vkontakte.news.VKNewsPluginSettings;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.vkontakte.news.VKNewsGetSettingsResponse;

@Implementing(VKNewsGetSettingsResponse.class)
public final class GsonVKNewsGetSettingsResponse extends GsonApiResponse<VKNewsPluginSettings> implements VKNewsGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonVKNewsGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
