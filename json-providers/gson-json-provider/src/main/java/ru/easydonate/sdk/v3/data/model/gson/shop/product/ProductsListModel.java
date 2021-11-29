package ru.easydonate.sdk.v3.data.model.gson.shop.product;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;

import java.util.ArrayList;

@Implementing(ProductsList.class)
public class ProductsListModel extends ArrayList<Product> implements ProductsList {
}
