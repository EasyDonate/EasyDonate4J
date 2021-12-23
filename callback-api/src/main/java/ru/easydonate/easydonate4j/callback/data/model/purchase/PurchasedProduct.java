package ru.easydonate.easydonate4j.callback.data.model.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.List;
import java.util.Optional;

public interface PurchasedProduct extends PrettyPrintable {

    int getId();

    @NotNull String getName();

    double getPrice();

    int getBoughtAmount();

    @NotNull Optional<String> getDescription();

    @NotNull String getIconImage();

    @NotNull List<String> getCommands();

    @NotNull List<AdditionalField> getAdditionalFields();

    @NotNull Optional<Discounts> getDiscounts();

}
