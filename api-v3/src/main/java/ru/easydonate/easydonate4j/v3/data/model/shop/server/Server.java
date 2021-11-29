package ru.easydonate.easydonate4j.v3.data.model.shop.server;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.v3.data.model.Sorted;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;

import java.time.LocalDateTime;
import java.util.Optional;

public interface Server extends Sorted, PrettyPrintable {

    int getId();

    int getShopId();

    @NotNull String getName();

    @NotNull String getAddress();

    int getPort();

    @NotNull String getVersion();

    boolean isAddressHidden();

    boolean isPortHidden();

    boolean isHidden();

    boolean isPaymentsDisabled();

    @NotNull Optional<ProductsList> getProducts();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
