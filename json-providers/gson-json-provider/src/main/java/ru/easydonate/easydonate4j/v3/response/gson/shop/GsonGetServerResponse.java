package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetServerResponse;

@Implementing(GetServerResponse.class)
public final class GsonGetServerResponse extends GsonApiResponse<Server> implements GetServerResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetServerResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
