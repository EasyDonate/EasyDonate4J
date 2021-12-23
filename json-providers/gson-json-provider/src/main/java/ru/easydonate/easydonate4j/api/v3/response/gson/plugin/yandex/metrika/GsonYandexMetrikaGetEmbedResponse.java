package ru.easydonate.easydonate4j.api.v3.response.gson.plugin.yandex.metrika;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.yandex.metrika.YandexMetrikaGetEmbedResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(YandexMetrikaGetEmbedResponse.class)
public final class GsonYandexMetrikaGetEmbedResponse extends GsonApiResponse<String> implements YandexMetrikaGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "GsonYandexMetrikaGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
