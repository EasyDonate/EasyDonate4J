package ru.easydonate.sdk.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.data.model.PrettyPrintable;

public interface CouponDiscount extends PrettyPrintable {

    @NotNull String getCode();

}
