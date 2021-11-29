package ru.easydonate.sdk.v3.response.jackson.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettings;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetSettingsResponse;

@Implementing(VKCommunityWidgetGetSettingsResponse.class)
public final class JacksonVKCommunityWidgetGetSettingsResponse extends JacksonApiResponse<VKCommunityWidgetPluginSettings> implements VKCommunityWidgetGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonVKCommunityWidgetGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
