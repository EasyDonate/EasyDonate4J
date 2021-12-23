package ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.Discount;

import java.util.Objects;

@Getter
public abstract class DiscountModel implements Discount {

    @JsonProperty("value")
    protected double discountValue;
    @JsonProperty("description")
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
