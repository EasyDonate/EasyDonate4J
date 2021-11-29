package ru.easydonate.sdk.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.server.Server;
import ru.easydonate.sdk.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetServerResponse;

@Implementing(GetServerResponse.class)
public final class JacksonGetServerResponse extends JacksonApiResponse<Server> implements GetServerResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetServerResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
