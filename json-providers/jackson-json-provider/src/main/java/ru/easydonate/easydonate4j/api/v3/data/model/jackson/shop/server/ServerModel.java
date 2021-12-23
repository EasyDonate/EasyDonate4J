package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.server;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(Server.class)
public class ServerModel implements Server {

    @JsonProperty("id")
    private int id;
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ip")
    private String address;
    @JsonProperty("port")
    private int port;

    @JsonProperty("version")
    private String version;
    @JsonProperty("is_port_hidden")
    private boolean portHidden;
    @JsonProperty("hide_ip")
    private boolean addressHidden;
    @JsonProperty("is_hidden")
    private boolean hidden;
    @JsonProperty("disable_payments")
    private boolean paymentsDisabled;

    @JsonProperty("sort_index")
    private int sortIndex;
    @JsonProperty("products")
    private ProductsList products;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Override
    public @NotNull Optional<ProductsList> getProducts() {
        return Wrapper.wrapNullable(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerModel that = (ServerModel) o;
        return id == that.id &&
                shopId == that.shopId &&
                port == that.port &&
                portHidden == that.portHidden &&
                addressHidden == that.addressHidden &&
                hidden == that.hidden &&
                paymentsDisabled == that.paymentsDisabled &&
                sortIndex == that.sortIndex &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(version, that.version) &&
                Objects.equals(products, that.products) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopId, name, address, port, version, portHidden, addressHidden, hidden, paymentsDisabled, sortIndex, products, createdAt, updatedAt);
    }

    @Override
    public @NotNull String toString() {
        return "ServerModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", port=" + port +
                ", version='" + version + '\'' +
                ", portHidden=" + portHidden +
                ", addressHidden=" + addressHidden +
                ", hidden=" + hidden +
                ", paymentsDisabled=" + paymentsDisabled +
                ", sortIndex=" + sortIndex +
                ", products=" + products +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
