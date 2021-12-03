package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.MassSaleDiscount;

import java.util.Objects;

@Getter
@Implementing(MassSaleDiscount.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MassSaleDiscountModel extends DiscountModel implements MassSaleDiscount {

    @JsonProperty("target")
    private MassSale massSale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MassSaleDiscountModel that = (MassSaleDiscountModel) o;
        return Double.compare(that.discountValue, discountValue) == 0 &&
                Objects.equals(description, that.description) &&
                Objects.equals(massSale, that.massSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountValue, description, massSale);
    }

    @Override
    public @NotNull String toString() {
        return "MassSaleDiscountModel{" +
                "discountValue=" + discountValue +
                ", description='" + description + '\'' +
                ", massSale=" + description +
                '}';
    }

}