package ru.easydonate.easydonate4j.callback.data.model.jackson.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.purchase.CouponDiscount;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

import java.util.Objects;

@Getter
@Implementing(CouponDiscount.class)
public class CouponDiscountModel extends DiscountModel implements CouponDiscount {

    @JsonProperty("name")
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouponDiscountModel that = (CouponDiscountModel) o;
        return Double.compare(that.discountValue, discountValue) == 0 &&
                Objects.equals(description, that.description) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountValue, description, code);
    }

    @Override
    public @NotNull String toString() {
        return "CouponDiscountModel{" +
                "discountValue=" + discountValue +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
