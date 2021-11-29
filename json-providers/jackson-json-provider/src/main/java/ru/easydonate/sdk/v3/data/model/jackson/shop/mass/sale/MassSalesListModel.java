package ru.easydonate.sdk.v3.data.model.jackson.shop.mass.sale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSalesList;

import java.util.ArrayList;

@Implementing(MassSalesList.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MassSalesListModel extends ArrayList<MassSale> implements MassSalesList {
}
