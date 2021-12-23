package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface PurchasedProduct extends PrettyPrintable {

    int getId();

    int getProductId();

    int getPaymentId();

    @NotNull String getName();

    @NotNull ProductType getType();

    @NotNull String getTypeRaw();

    double getPrice();

    int getDefaultAmount();

    int getBoughtAmount();

    @NotNull Optional<String> getDescription();

    @NotNull OptionalDouble getOldPrice();

    @NotNull String getIconImage();

    boolean isOneTimePurchasable();

    @NotNull List<String> getCommands();

    @NotNull List<FilledAdditionalField> getAdditionalFields();

    @NotNull Optional<Discounts> getDiscounts();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
