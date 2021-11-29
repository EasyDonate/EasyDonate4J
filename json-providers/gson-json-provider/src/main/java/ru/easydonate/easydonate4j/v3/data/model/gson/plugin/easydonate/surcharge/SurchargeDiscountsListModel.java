package ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.surcharge;

import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;

import java.util.ArrayList;

@Implementing(SurchargeDiscountsList.class)
public class SurchargeDiscountsListModel extends ArrayList<SurchargeDiscount> implements SurchargeDiscountsList {
}
