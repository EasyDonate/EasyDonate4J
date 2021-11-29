package ru.easydonate.easydonate4j.v3.response.gson.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetEmbedResponse;

@Implementing(VKCommunityWidgetGetEmbedResponse.class)
public final class GsonVKCommunityWidgetGetEmbedResponse extends GsonApiResponse<String> implements VKCommunityWidgetGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "GsonVKCommunityWidgetGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
