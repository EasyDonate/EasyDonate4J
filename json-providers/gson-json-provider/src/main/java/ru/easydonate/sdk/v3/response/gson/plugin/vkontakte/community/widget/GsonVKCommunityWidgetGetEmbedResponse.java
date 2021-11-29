package ru.easydonate.sdk.v3.response.gson.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetEmbedResponse;

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
