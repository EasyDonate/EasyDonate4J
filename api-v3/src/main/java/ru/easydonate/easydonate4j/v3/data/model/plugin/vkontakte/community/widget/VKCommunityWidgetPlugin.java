package ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.vkontakte.community.widget.VKCommunityWidgetGetSettingsResponse;

public final class VKCommunityWidgetPlugin extends AbstractPlugin {

    public VKCommunityWidgetPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.VK_COMMUNITY_WIDGET);
    }

    @Override
    public @NotNull VKCommunityWidgetPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(VKCommunityWidgetGetSettingsResponse.class, null, null);
    }

    public @NotNull String getEmbed() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(VKCommunityWidgetGetEmbedResponse.class, null, null);
    }

}
