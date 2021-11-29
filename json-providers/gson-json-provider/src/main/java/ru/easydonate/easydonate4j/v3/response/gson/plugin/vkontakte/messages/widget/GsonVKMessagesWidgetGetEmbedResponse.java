package ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.messages.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.messages.widget.VKMessagesWidgetGetEmbedResponse;

@Implementing(VKMessagesWidgetGetEmbedResponse.class)
public final class GsonVKMessagesWidgetGetEmbedResponse extends GsonApiResponse<String> implements VKMessagesWidgetGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "GsonVKMessagesWidgetGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
