package ru.easydonate.easydonate4j.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.shop.mass.sale.MassSale;

public interface MassSaleDiscount extends Discount {

    @NotNull MassSale getMassSale();

}
