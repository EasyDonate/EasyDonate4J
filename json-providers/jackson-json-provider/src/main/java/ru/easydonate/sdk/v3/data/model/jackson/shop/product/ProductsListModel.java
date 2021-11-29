package ru.easydonate.sdk.v3.data.model.jackson.shop.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;

import java.util.ArrayList;

@Implementing(ProductsList.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsListModel extends ArrayList<Product> implements ProductsList {
}
