package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;

/**
 * The interface that represents a platform plugin for a shop.
 * <br>
 * Everyone plugin has own implementation of this interface.
 * @author soknight
 */
public interface Plugin {

    /**
     * Get the API client instance that will be used for data requests.
     * @return The API client instance.
     */
    @NotNull EasyDonateClient getClient();

    /**
     * Get the type of this plugin.
     * @return The plugin type.
     * @see PluginType
     */
    @NotNull PluginType getPluginType();

    /**
     * Request the plugin settings from the remote API server.
     * @return The actual plugin settings.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see PluginSettings
     */
    @NotNull PluginSettings getSettings() throws HttpRequestException, HttpResponseException;

}
