package ru.easydonate.easydonate4j.callback.data.model.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.mass.sale.MassSale;

public interface MassSaleDiscount extends Discount {

    @NotNull MassSale getMassSale();

}
