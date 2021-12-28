package ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.news;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.response.plugin.vkontakte.news.VKNewsGetSettingsResponse;

public final class VKNewsPlugin extends AbstractPlugin {

    public VKNewsPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.VK_NEWS);
    }

    @Override
    public @NotNull VKNewsPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(VKNewsGetSettingsResponse.class);
    }

}
