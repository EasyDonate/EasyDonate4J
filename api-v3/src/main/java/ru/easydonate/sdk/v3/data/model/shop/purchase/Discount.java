package ru.easydonate.sdk.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.data.model.PrettyPrintable;

public interface Discount extends PrettyPrintable {

    double getDiscountValue();

    @NotNull String getDescription();

}
