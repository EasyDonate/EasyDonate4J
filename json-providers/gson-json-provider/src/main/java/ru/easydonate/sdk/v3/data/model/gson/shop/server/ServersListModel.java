package ru.easydonate.sdk.v3.data.model.gson.shop.server;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.server.Server;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;

import java.util.ArrayList;

@Implementing(ServersList.class)
public class ServersListModel extends ArrayList<Server> implements ServersList {
}
