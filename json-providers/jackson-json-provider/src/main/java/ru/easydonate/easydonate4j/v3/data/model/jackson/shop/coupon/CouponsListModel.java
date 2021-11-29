package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.coupon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.easydonate4j.v3.data.model.shop.coupon.CouponsList;

import java.util.ArrayList;

@Implementing(CouponsList.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponsListModel extends ArrayList<Coupon> implements CouponsList {
}
