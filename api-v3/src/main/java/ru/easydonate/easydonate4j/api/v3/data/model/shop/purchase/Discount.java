package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

public interface Discount extends PrettyPrintable {

    double getDiscountValue();

    @NotNull String getDescription();

}
