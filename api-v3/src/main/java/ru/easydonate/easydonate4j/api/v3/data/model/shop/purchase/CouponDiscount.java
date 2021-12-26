package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;

/**
 * The interface that represents a coupon related
 * discount and used by the {@link Discounts} model.
 * @see Discount
 * @see Discounts
 * @see PurchasedProduct#getDiscounts()
 * @author soknight
 */
public interface CouponDiscount extends Discount {

    /**
     * Get the coupon code.
     * @return The coupon code.
     */
    @NotNull String getCode();

}
