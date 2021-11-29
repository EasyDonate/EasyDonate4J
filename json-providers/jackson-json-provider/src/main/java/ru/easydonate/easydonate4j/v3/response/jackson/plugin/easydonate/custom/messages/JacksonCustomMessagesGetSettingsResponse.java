package ru.easydonate.easydonate4j.v3.response.jackson.plugin.easydonate.custom.messages;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPluginSettings;
import ru.easydonate.easydonate4j.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.easydonate.custom.messages.CustomMessagesGetSettingsResponse;

@Implementing(CustomMessagesGetSettingsResponse.class)
public final class JacksonCustomMessagesGetSettingsResponse extends JacksonApiResponse<CustomMessagesPluginSettings> implements CustomMessagesGetSettingsResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonCustomMessagesGetSettingsResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
