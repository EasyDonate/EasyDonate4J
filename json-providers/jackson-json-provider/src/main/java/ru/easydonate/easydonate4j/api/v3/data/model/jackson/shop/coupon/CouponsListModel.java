package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.coupon;

import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.CouponsList;

import java.util.ArrayList;

@Implementing(CouponsList.class)
public class CouponsListModel extends ArrayList<Coupon> implements CouponsList {
}
