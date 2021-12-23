package ru.easydonate.easydonate4j.api.v3.response.gson.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(DiscordWidgetGetSettingsResponse.class)
public final class GsonDiscordWidgetGetSettingsResponse extends GsonApiResponse<DiscordWidgetPluginSettings> implements DiscordWidgetGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "GsonDiscordWidgetGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
