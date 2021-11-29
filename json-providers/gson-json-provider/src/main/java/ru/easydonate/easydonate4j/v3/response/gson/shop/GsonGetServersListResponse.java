package ru.easydonate.easydonate4j.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.GetServersListResponse;

@Implementing(GetServersListResponse.class)
public final class GsonGetServersListResponse extends GsonApiResponse<ServersList> implements GetServersListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetServersListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
