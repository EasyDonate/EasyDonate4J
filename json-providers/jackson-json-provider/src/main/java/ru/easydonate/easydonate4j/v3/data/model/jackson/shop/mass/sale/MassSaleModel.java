package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.mass.sale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

@Getter
@Implementing(MassSale.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MassSaleModel implements MassSale {

    @JsonProperty("id")
    private int id;
    @JsonProperty("shop_id")
    private Integer shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sale")
    private double discountPercent;

    @JsonProperty("products")
    private ProductsList products;

    @JsonProperty("starts_at")
    private LocalDateTime startsAt;
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getShopId() {
        return Wrapper.wrapNullableInt(shopId);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<ProductsList> getProducts() {
        return Wrapper.wrapNullable(products);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<LocalDateTime> getStartsAt() {
        return Wrapper.wrapNullable(startsAt);
    }

    @JsonIgnore
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
