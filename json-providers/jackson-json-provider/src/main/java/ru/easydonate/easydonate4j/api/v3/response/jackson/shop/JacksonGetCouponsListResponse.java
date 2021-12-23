package ru.easydonate.easydonate4j.api.v3.response.jackson.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.easydonate4j.api.v3.response.jackson.JacksonApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.GetCouponsListResponse;

@Implementing(GetCouponsListResponse.class)
public final class JacksonGetCouponsListResponse extends JacksonApiResponse<CouponsList> implements GetCouponsListResponse {

    @Override
    public @NotNull String toString() {
        return "JacksonGetCouponsListResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
