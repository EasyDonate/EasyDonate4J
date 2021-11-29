package ru.easydonate.sdk.v3.data.model.plugin.easydonate.custom.messages;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.v3.client.EasyDonateClient;
import ru.easydonate.sdk.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.sdk.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.plugin.easydonate.custom.messages.CustomMessagesGetSettingsResponse;

public final class CustomMessagesPlugin extends AbstractPlugin {

    public CustomMessagesPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.CUSTOM_MESSAGES);
    }

    @Override
    public @NotNull CustomMessagesPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(CustomMessagesGetSettingsResponse.class, null, null);
    }

}
