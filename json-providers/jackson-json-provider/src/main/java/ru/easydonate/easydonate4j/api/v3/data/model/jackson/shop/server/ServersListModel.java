package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.server;

import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;

import java.util.ArrayList;

@Implementing(ServersList.class)
public class ServersListModel extends ArrayList<Server> implements ServersList {
}
