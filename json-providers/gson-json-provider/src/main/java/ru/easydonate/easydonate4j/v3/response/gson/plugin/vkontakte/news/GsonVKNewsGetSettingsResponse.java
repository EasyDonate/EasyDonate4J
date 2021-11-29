package ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.news;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.news.VKNewsPluginSettings;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.news.VKNewsGetSettingsResponse;

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
