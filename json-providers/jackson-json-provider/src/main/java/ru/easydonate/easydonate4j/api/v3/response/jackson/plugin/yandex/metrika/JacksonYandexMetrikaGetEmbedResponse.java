package ru.easydonate.easydonate4j.api.v3.response.jackson.plugin.yandex.metrika;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.plugin.yandex.metrika.YandexMetrikaGetEmbedResponse;

@Implementing(YandexMetrikaGetEmbedResponse.class)
public final class JacksonYandexMetrikaGetEmbedResponse extends JacksonApiResponse<String> implements YandexMetrikaGetEmbedResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonYandexMetrikaGetEmbedResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
