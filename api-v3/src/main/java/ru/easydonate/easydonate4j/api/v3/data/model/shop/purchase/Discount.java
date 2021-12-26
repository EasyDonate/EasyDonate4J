package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

/**
 * The interface that represents an abstract product discount.
 * <br>
 * It's maybe a coupon discount or a mass sale discount.
 * @see CouponDiscount
 * @see MassSaleDiscount
 * @see Discounts
 * @see PurchasedProduct#getDiscounts()
 * @author soknight
 */
public interface Discount extends PrettyPrintable {

    /**
     * Get the percent value of this discount.
     * @return The discount percent.
     */
    double getDiscountValue();

    /**
     * Get the displayable description of this discount.
     * @return The discount description.
     */
    @NotNull String getDescription();

}
