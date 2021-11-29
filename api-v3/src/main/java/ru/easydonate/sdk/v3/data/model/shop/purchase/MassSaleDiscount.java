package ru.easydonate.sdk.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSale;

public interface MassSaleDiscount extends Discount {

    @NotNull MassSale getMassSale();

}
