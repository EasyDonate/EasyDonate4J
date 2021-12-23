package ru.easydonate.easydonate4j.api.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.easydonate4j.api.v3.response.gson.GsonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetCouponsListResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Implementing(GetCouponsListResponse.class)
public final class GsonGetCouponsListResponse extends GsonApiResponse<CouponsList> implements GetCouponsListResponse {

    @Override
    public @NotNull String toString() {
        return "GsonGetCouponsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
