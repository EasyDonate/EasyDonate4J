package ru.easydonate.easydonate4j.callback.data.model.jackson.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.server.Server;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.Objects;

@Getter
@Implementing(Server.class)
public class ServerModel implements Server {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ip")
    private String address;
    @JsonProperty("port")
    private int port;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerModel that = (ServerModel) o;
        return id == that.id &&
                port == that.port &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, port);
    }

    @Override
    public @NotNull String toString() {
        return "ServerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", port=" + port +
                '}';
    }

}
