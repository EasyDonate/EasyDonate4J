package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.util.Optional;

/**
 * The interface that represents a wrapper for some possible purchase discounts.
 * @see CouponDiscount
 * @see MassSaleDiscount
 * @see PurchasedProduct#getDiscounts()
 * @author soknight
 */
public interface Discounts extends PrettyPrintable {

    /**
     * Get the active mass sale discount.
     * @return The mass sale discount wrapper.
     */
    @NotNull Optional<MassSaleDiscount> getActiveMassSale();

    /**
     * Get the used coupon discount.
     * @return The coupon discount wrapper.
     */
    @NotNull Optional<CouponDiscount> getUsedCoupon();

}
