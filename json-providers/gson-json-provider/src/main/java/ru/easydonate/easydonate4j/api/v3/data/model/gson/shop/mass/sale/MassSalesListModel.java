package ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.mass.sale;

import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.ArrayList;

@Implementing(MassSalesList.class)
public class MassSalesListModel extends ArrayList<MassSale> implements MassSalesList {
}
