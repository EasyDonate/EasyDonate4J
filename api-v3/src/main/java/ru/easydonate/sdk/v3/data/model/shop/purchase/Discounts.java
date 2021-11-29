package ru.easydonate.sdk.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.data.model.PrettyPrintable;

import java.util.Optional;

public interface Discounts extends PrettyPrintable {

    @NotNull Optional<MassSaleDiscount> getActiveMassSale();

    @NotNull Optional<CouponDiscount> getUsedCoupon();

}
