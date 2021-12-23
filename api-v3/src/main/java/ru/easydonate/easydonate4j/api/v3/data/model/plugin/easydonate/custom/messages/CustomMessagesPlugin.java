package ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.response.plugin.easydonate.custom.messages.CustomMessagesGetSettingsResponse;

public final class CustomMessagesPlugin extends AbstractPlugin {

    public CustomMessagesPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.CUSTOM_MESSAGES);
    }

    @Override
    public @NotNull CustomMessagesPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(CustomMessagesGetSettingsResponse.class, null, null);
    }

}
