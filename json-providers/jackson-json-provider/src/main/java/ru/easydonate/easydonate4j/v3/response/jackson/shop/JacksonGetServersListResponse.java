package ru.easydonate.easydonate4j.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetServersListResponse;

@Implementing(GetServersListResponse.class)
public final class JacksonGetServersListResponse extends JacksonApiResponse<ServersList> implements GetServersListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetServersListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
