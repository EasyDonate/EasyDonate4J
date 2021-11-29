package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetServersListResponse;

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
