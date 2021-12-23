package ru.easydonate.easydonate4j.api.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetServersListResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

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
