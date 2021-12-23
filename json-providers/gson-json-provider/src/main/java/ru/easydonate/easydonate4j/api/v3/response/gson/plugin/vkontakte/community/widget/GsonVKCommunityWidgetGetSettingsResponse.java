package ru.easydonate.easydonate4j.api.v3.response.gson.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetSettingsResponse;

@Implementing(VKCommunityWidgetGetSettingsResponse.class)
public final class GsonVKCommunityWidgetGetSettingsResponse extends GsonApiResponse<VKCommunityWidgetPluginSettings> implements VKCommunityWidgetGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonVKCommunityWidgetGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
