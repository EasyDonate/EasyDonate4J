package ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.discord.widget.DiscordWidgetGetEmbedResponse;

@Implementing(DiscordWidgetGetEmbedResponse.class)
public final class JacksonDiscordWidgetGetEmbedResponse extends JacksonApiResponse<String> implements DiscordWidgetGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonDiscordWidgetGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
