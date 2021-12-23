package ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.vkontakte.messages.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetSettingsResponse;

@Implementing(VKMessagesWidgetGetSettingsResponse.class)
public final class JacksonVKMessagesWidgetGetSettingsResponse extends JacksonApiResponse<VKMessagesWidgetPluginSettings> implements VKMessagesWidgetGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonVKMessagesWidgetGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
