package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.AdditionalField;

/**
 * The interface that represents a filled additional field in purchased product.
 * @see PurchasedProduct#getAdditionalFields()
 * @author soknight
 */
public interface FilledAdditionalField extends AdditionalField {

    /**
     * Get the filled value of this additional field.
     * <br>
     * This value has been specified by a product customer.
     * @return The field value specified by a customer.
     */
    @NotNull String getSpecifiedValue();

}
