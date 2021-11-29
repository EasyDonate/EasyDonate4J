package ru.easydonate.easydonate4j.v3.data.model.plugin.yandex.metrika;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.response.plugin.yandex.metrika.YandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.yandex.metrika.YandexMetrikaGetSettingsResponse;

public final class YandexMetrikaPlugin extends AbstractPlugin {

    public YandexMetrikaPlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.YANDEX_METRIKA);
    }

    @Override
    public @NotNull YandexMetrikaPluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(YandexMetrikaGetSettingsResponse.class, null, null);
    }

    public @NotNull String getEmbed() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(YandexMetrikaGetEmbedResponse.class, null, null);
    }

}
