package ru.easydonate.sdk.v3.data.model.gson.shop.coupon;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

@Getter
@Implementing(Coupon.class)
public class CouponModel implements Coupon {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;

    @SerializedName("sale")
    private double discountPercent;
    @SerializedName("limit")
    private Integer maxUsages;
    @SerializedName("products")
    private ProductsList products;

    @SerializedName("expires_at")
    private LocalDateTime expiresAt;
    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public @NotNull OptionalInt getMaxUsages() {
        return Wrapper.wrapNullableInt(maxUsages);
    }

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
