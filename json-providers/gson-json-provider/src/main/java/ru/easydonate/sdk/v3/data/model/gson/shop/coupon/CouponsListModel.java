package ru.easydonate.sdk.v3.data.model.gson.shop.coupon;

import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.sdk.v3.data.model.shop.coupon.CouponsList;

import java.util.ArrayList;

@Implementing(CouponsList.class)
public class CouponsListModel extends ArrayList<Coupon> implements CouponsList {
}
