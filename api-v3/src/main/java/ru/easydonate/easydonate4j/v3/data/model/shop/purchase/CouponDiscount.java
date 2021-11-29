package ru.easydonate.easydonate4j.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

public interface CouponDiscount extends PrettyPrintable {

    @NotNull String getCode();

}
