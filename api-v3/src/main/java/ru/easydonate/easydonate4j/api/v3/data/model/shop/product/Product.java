package ru.easydonate.easydonate4j.api.v3.data.model.shop.product;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.Sorted;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.AdditionalField;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface Product extends Sorted, PrettyPrintable {

    int getId();

    int getShopId();

    @NotNull String getName();

    @NotNull ProductType getType();

    @NotNull String getTypeRaw();

    double getPrice();

    int getAmount();

    @NotNull Optional<String> getDescription();

    @NotNull OptionalDouble getOldPrice();

    @NotNull OptionalInt getCategoryId();

    @NotNull String getIconImage();

    boolean isHidden();

    boolean isOneTimePurchasable();

    @NotNull List<String> getCommands();

    @NotNull List<String> getWithdrawCommands();

    @NotNull OptionalInt getWithdrawCommandsDelay();

    @NotNull List<? extends AdditionalField> getAdditionalFields();

    @NotNull Optional<ServersList> getServers();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
