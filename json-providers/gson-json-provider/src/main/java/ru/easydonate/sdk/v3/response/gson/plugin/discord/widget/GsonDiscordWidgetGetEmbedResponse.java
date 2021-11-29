package ru.easydonate.sdk.v3.response.gson.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.discord.widget.DiscordWidgetGetEmbedResponse;

@Implementing(DiscordWidgetGetEmbedResponse.class)
public final class GsonDiscordWidgetGetEmbedResponse extends GsonApiResponse<String> implements DiscordWidgetGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "GsonDiscordWidgetGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
