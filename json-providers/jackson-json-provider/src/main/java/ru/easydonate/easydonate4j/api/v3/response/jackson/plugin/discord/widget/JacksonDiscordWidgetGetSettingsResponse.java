package ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;

@Implementing(DiscordWidgetGetSettingsResponse.class)
public final class JacksonDiscordWidgetGetSettingsResponse extends JacksonApiResponse<DiscordWidgetPluginSettings> implements DiscordWidgetGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonDiscordWidgetGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
