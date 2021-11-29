package ru.easydonate.easydonate4j.v3.data.model.gson.shop.purchase;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.Discount;

import java.util.Objects;

@Getter
public abstract class DiscountModel implements Discount {

    @SerializedName("value")
    protected double discountValue;
    @SerializedName("description")
    protected String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountModel that = (DiscountModel) o;
        return Double.compare(that.discountValue, discountValue) == 0 &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountValue, description);
    }

    @Override
    public @NotNull String toString() {
        return "DiscountModel{" +
                "discountValue=" + discountValue +
                ", description='" + description + '\'' +
                '}';
    }

}
