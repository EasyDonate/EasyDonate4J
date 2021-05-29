package ru.soknight.easydonate.sdk.v2.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateSerializer;
import ru.soknight.easydonate.sdk.v2.data.PrettyPrintable;

/**
 * The object which represents any server connected to remote shop.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true, value = { "pivot" })
public class ServerModel implements PrettyPrintable {

    @JsonProperty("id")
    private int serverId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ip")
    private String address;
    @JsonProperty("port")
    private int port;

    @JsonProperty("rcon_ip")
    private String rconAddress;
    @JsonProperty("rcon_port")
    private int rconPort;
    @JsonProperty("rcon_password")
    private String rconPassword;
    
    @JsonProperty("is_port_hidden")
    private boolean portHidden;
    @JsonProperty("hide_ip")
    private boolean addressHidden;
    @JsonProperty("is_hidden")
    private boolean serverHidden;
    
    @JsonProperty("version")
    private String version;
    @JsonProperty("shop_id")
    private int shopId;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
    
    @JsonProperty("products")
    private List<ProductModel> products;

    @Override
    public int hashCode() {
        return Objects.hash(
                address, addressHidden, createdAt, name, port, portHidden, products,
                rconPassword, rconPort, serverHidden, serverId, shopId, updatedAt, version
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        ServerModel other = (ServerModel) obj;
        return Objects.equals(address, other.address) &&
                addressHidden == other.addressHidden &&
                Objects.equals(createdAt, other.createdAt) &&
                Objects.equals(name, other.name) &&
                port == other.port &&
                portHidden == other.portHidden &&
                Objects.equals(products, other.products) &&
                Objects.equals(rconPassword, other.rconPassword) &&
                rconPort == other.rconPort &&
                serverHidden == other.serverHidden &&
                serverId == other.serverId &&
                shopId == other.shopId &&
                Objects.equals(updatedAt, other.updatedAt) &&
                Objects.equals(version, other.version);
    }

    @Override
    public String toString() {
        return "Server{"
                + "serverId=" + serverId
                + ", name='" + name + "'"
                + ", address=" + address
                + ", port=" + port
                + ", rconPort=" + rconPort
                + ", rconPassword=" + rconPassword
                + ", portHidden=" + portHidden
                + ", addressHidden=" + addressHidden
                + ", serverHidden=" + serverHidden
                + ", version='" + version + "'"
                + ", shopId=" + shopId
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", products=" + products
                + "}";
    }
    
}
