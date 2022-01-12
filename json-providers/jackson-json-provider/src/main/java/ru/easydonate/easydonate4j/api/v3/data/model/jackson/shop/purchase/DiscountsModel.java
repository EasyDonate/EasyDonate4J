package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.CouponDiscount;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.Discounts;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.MassSaleDiscount;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Implementing(Discounts.class)
public class DiscountsModel implements Discounts {

    @JsonProperty("massSale")
    private MassSaleDiscount activeMassSale;
    @JsonProperty("coupon")
    private CouponDiscount usedCoupon;

    @JsonIgnore
    public static @NotNull DiscountsArrayDeserializer getDeserializer(@NotNull ObjectMapper unsafeMapperInstance) {
        return new DiscountsArrayDeserializer(unsafeMapperInstance);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<MassSaleDiscount> getActiveMassSale() {
        return Wrapper.wrapNullable(activeMassSale);
    }

    @JsonIgnore
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
    private static final class DiscountsArrayDeserializer extends JsonDeserializer<DiscountsModel> {

        private final ObjectMapper unsafeMapperInstance;

        @Override
        public @Nullable DiscountsModel deserialize(
                @NotNull JsonParser parser,
                @NotNull DeserializationContext context
        ) throws IOException {
            if(parser.getCurrentToken() == JsonToken.START_ARRAY)
                return null;

            return unsafeMapperInstance.readValue(parser, DiscountsModel.class);
        }

    }

}
