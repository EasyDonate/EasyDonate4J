package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.coupon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

@Getter
@Implementing(Coupon.class)
public class CouponModel implements Coupon {

    @JsonProperty("id")
    private int id;
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;

    @JsonProperty("sale")
    private double discountPercent;
    @JsonProperty("limit")
    private Integer maxUsages;
    @JsonProperty("products")
    private ProductsList products;

    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getMaxUsages() {
        return Wrapper.wrapNullableInt(maxUsages);
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

        CouponModel that = (CouponModel) o;
        return id == that.id && shopId == that.shopId &&
                Double.compare(that.discountPercent, discountPercent) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(maxUsages, that.maxUsages) &&
                Objects.equals(products, that.products) &&
                Objects.equals(expiresAt, that.expiresAt) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopId, name, code, discountPercent, maxUsages, products, expiresAt, createdAt, updatedAt);
    }

    @Override
    public @NotNull String toString() {
        return "CouponModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", discountPercent=" + discountPercent +
                ", maxUsages=" + maxUsages +
                ", products=" + products +
                ", expiresAt=" + expiresAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
