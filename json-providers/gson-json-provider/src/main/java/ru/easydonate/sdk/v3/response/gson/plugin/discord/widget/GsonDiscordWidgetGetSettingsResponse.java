package ru.easydonate.sdk.v3.response.gson.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.discord.widget.DiscordWidgetGetSettingsResponse;

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
