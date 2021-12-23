package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.Optional;

public interface Discounts extends PrettyPrintable {

    @NotNull Optional<MassSaleDiscount> getActiveMassSale();

    @NotNull Optional<CouponDiscount> getUsedCoupon();

}
