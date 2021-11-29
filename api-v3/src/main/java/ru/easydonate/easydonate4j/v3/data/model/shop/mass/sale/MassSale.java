package ru.easydonate.easydonate4j.v3.data.model.shop.mass.sale;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

public interface MassSale extends PrettyPrintable {

    int getId();

    @NotNull OptionalInt getShopId();

    @NotNull String getName();

    double getDiscountPercent();

    @NotNull Optional<ProductsList> getProducts();

    @NotNull Optional<LocalDateTime> getStartsAt();

    @NotNull Optional<LocalDateTime> getExpiresAt();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
