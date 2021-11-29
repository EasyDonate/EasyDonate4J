package ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.surcharge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscountsList;

import java.util.ArrayList;

@Implementing(SurchargeDiscountsList.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurchargeDiscountsListModel extends ArrayList<SurchargeDiscount> implements SurchargeDiscountsList {
}
