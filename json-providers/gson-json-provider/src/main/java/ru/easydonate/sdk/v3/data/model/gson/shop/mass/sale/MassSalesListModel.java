package ru.easydonate.sdk.v3.data.model.gson.shop.mass.sale;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSalesList;

import java.util.ArrayList;

@Implementing(MassSalesList.class)
public class MassSalesListModel extends ArrayList<MassSale> implements MassSalesList {
}
