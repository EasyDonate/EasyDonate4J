package ru.easydonate.sdk.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.v3.client.EasyDonateClient;

public interface Plugin {

    @NotNull EasyDonateClient getClient();

    @NotNull PluginType getPluginType();

    @NotNull PluginSettings getSettings() throws HttpRequestException, HttpResponseException;

}
