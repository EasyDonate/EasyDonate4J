package ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.purchase;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.CouponDiscount;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.Discounts;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.MassSaleDiscount;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Optional;

@Implementing(Discounts.class)
public class DiscountsModel implements Discounts {

    @SerializedName("massSale")
    private MassSaleDiscount activeMassSale;
    @SerializedName("coupon")
    private CouponDiscount usedCoupon;

    public static @NotNull DiscountsArrayDeserializer getDeserializer(@NotNull Gson unsafeGsonInstance) {
        return new DiscountsArrayDeserializer(unsafeGsonInstance);
    }

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

    @AllArgsConstructor
    private static final class DiscountsArrayDeserializer implements JsonDeserializer<DiscountsModel> {

        private final Gson unsafeGsonInstance;

        @Override
        public @Nullable DiscountsModel deserialize(
                @Nullable JsonElement json,
                @NotNull Type type,
                @NotNull JsonDeserializationContext context
        ) throws JsonParseException {
            if(json == null || json.isJsonNull() || json.isJsonArray())
                return null;

            return unsafeGsonInstance.fromJson(json, type);
        }

    }

}
