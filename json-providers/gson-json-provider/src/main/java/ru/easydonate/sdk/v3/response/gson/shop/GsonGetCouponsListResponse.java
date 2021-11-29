package ru.easydonate.sdk.v3.response.gson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.sdk.v3.response.gson.GsonApiResponse;
import ru.easydonate.sdk.v3.response.shop.GetCouponsListResponse;

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
