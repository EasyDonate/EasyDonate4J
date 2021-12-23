package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;

public interface Plugin {

    @NotNull EasyDonateClient getClient();

    @NotNull PluginType getPluginType();

    @NotNull PluginSettings getSettings() throws HttpRequestException, HttpResponseException;

}
