package ru.easydonate.sdk.v3.data.model.gson.plugin.easydonate.surcharge;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;

import java.util.ArrayList;

@Implementing(SurchargeDiscountsList.class)
public class SurchargeDiscountsListModel extends ArrayList<SurchargeDiscount> implements SurchargeDiscountsList {
}
