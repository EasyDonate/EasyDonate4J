package ru.easydonate.easydonate4j.callback.data.model.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

public interface CouponDiscount extends PrettyPrintable {

    @NotNull String getCode();

}
