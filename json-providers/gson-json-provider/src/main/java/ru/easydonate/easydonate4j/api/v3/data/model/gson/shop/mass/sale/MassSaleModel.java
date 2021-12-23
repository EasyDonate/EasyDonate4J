package ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.mass.sale;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

@Getter
@Implementing(MassSale.class)
public class MassSaleModel implements MassSale {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private Integer shopId;
    @SerializedName("name")
    private String name;
    @SerializedName("sale")
    private double discountPercent;

    @SerializedName("products")
    private ProductsList products;

    @SerializedName("starts_at")
    private LocalDateTime startsAt;
    @SerializedName("expires_at")
    private LocalDateTime expiresAt;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public @NotNull OptionalInt getShopId() {
        return Wrapper.wrapNullableInt(shopId);
    }

    @Override
    public @NotNull Optional<ProductsList> getProducts() {
        return Wrapper.wrapNullable(products);
    }

    @Override
    public @NotNull Optional<LocalDateTime> getStartsAt() {
        return Wrapper.wrapNullable(startsAt);
    }

    @Override
    public @NotNull Optional<LocalDateTime> getExpiresAt() {
        return Wrapper.wrapNullable(expiresAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MassSaleModel that = (MassSaleModel) o;
        return id == that.id &&
                Double.compare(that.discountPercent, discountPercent) == 0 &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(products, that.products) &&
                Objects.equals(startsAt, that.startsAt) &&
                Objects.equals(expiresAt, that.expiresAt) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopId, name, discountPercent, products, startsAt, expiresAt, createdAt, updatedAt);
    }

    @Override
    public @NotNull String toString() {
        return "MassSaleModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", discountPercent=" + discountPercent +
                ", products=" + products +
                ", startsAt=" + startsAt +
                ", expiresAt=" + expiresAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
