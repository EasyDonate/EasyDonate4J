package ru.easydonate.sdk.v3.data.model.gson.shop.purchase;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.purchase.CouponDiscount;
import ru.easydonate.sdk.v3.data.model.shop.purchase.Discounts;
import ru.easydonate.sdk.v3.data.model.shop.purchase.MassSaleDiscount;

import java.util.Objects;
import java.util.Optional;

@Implementing(Discounts.class)
public class DiscountsModel implements Discounts {

    @SerializedName("massSale")
    private MassSaleDiscount activeMassSale;
    @SerializedName("coupon")
    private CouponDiscount usedCoupon;

    @Override
    public @NotNull Optional<MassSaleDiscount> getActiveMassSale() {
        return Wrapper.wrapNullable(activeMassSale);
    }

    @Override
    public @NotNull Optional<CouponDiscount> getUsedCoupon() {
        return Wrapper.wrapNullable(usedCoupon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountsModel that = (DiscountsModel) o;
        return Objects.equals(activeMassSale, that.activeMassSale) &&
                Objects.equals(usedCoupon, that.usedCoupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeMassSale, usedCoupon);
    }

    @Override
    public @NotNull String toString() {
        return "DiscountsModel{" +
                "activeMassSale=" + activeMassSale +
                ", usedCoupon=" + usedCoupon +
                '}';
    }

}
