package ru.easydonate.sdk.v3.data.model.jackson.shop.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.server.Server;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;

import java.util.ArrayList;

@Implementing(ServersList.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServersListModel extends ArrayList<Server> implements ServersList {
}
