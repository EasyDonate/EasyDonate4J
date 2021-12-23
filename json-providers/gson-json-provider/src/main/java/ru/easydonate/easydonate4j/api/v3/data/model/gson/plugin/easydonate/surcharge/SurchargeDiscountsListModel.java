package ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.surcharge;

import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.ArrayList;

@Implementing(SurchargeDiscountsList.class)
public class SurchargeDiscountsListModel extends ArrayList<SurchargeDiscount> implements SurchargeDiscountsList {
}
