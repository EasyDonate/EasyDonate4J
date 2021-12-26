package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSale;

/**
 * The interface that represents a mass sale related
 * discount and used by the {@link Discounts} model.
 * @see Discount
 * @see Discounts
 * @see PurchasedProduct#getDiscounts()
 * @author soknight
 */
public interface MassSaleDiscount extends Discount {

    /**
     * Get the mass sale instance.
     * @return The mass sale instance.
     */
    @NotNull MassSale getMassSale();

}
