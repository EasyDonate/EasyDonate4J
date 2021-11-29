package ru.easydonate.sdk.v3.data.model.shop.coupon;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.data.model.PrettyPrintable;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

public interface Coupon extends PrettyPrintable {

    int getId();

    int getShopId();

    @NotNull String getName();

    @NotNull String getCode();

    double getDiscountPercent();

    @NotNull OptionalInt getMaxUsages();

    @NotNull ProductsList getProducts();

    @NotNull Optional<LocalDateTime> getExpiresAt();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
