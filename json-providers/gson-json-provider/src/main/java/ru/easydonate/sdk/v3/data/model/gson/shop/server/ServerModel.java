package ru.easydonate.sdk.v3.data.model.gson.shop.server;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;
import ru.easydonate.sdk.v3.data.model.shop.server.Server;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(Server.class)
public class ServerModel implements Server {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("name")
    private String name;
    @SerializedName("ip")
    private String address;
    @SerializedName("port")
    private int port;

    @SerializedName("version")
    private String version;
    @SerializedName("is_port_hidden")
    private boolean portHidden;
    @SerializedName("hide_ip")
    private boolean addressHidden;
    @SerializedName("is_hidden")
    private boolean hidden;
    @SerializedName("disable_payments")
    private boolean paymentsDisabled;

    @SerializedName("sort_index")
    private int sortIndex;
    @SerializedName("products")
    private ProductsList products;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

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
