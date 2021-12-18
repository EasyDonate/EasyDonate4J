package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.product;

import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.Product;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;

import java.util.ArrayList;

@Implementing(ProductsList.class)
public class ProductsListModel extends ArrayList<Product> implements ProductsList {
}
