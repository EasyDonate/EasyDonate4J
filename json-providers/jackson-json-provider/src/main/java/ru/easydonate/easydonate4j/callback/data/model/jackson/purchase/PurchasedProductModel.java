package ru.easydonate.easydonate4j.callback.data.model.jackson.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.purchase.AdditionalField;
import ru.easydonate.easydonate4j.callback.data.model.purchase.Discounts;
import ru.easydonate.easydonate4j.callback.data.model.purchase.PurchasedProduct;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(PurchasedProduct.class)
public class PurchasedProductModel implements PurchasedProduct {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cost")
    private double price;
    @JsonProperty("count")
    private long boughtAmount;

    @JsonProperty("description")
    private String description;
    @JsonProperty("image")
    private String iconImage;

    @JsonProperty("commands")
    private List<String> commands;
    @JsonProperty("custom_fields")
    @JsonDeserialize(using = AdditionalFieldModel.ListDeserializer.class)
    private List<AdditionalField> additionalFields;
    @JsonProperty("sales")
    private Discounts discounts;

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getDescription() {
        return Wrapper.wrapNullable(description);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<Discounts> getDiscounts() {
        return Wrapper.wrapNullable(discounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchasedProductModel that = (PurchasedProductModel) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                boughtAmount == that.boughtAmount &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(iconImage, that.iconImage) &&
                Objects.equals(commands, that.commands) &&
                Objects.equals(additionalFields, that.additionalFields) &&
                Objects.equals(discounts, that.discounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, name, price, boughtAmount, description,
                iconImage, commands, additionalFields, discounts
        );
    }

    @Override
    public @NotNull String toString() {
        return "PurchasedProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", boughtAmount=" + boughtAmount +
                ", description='" + description + '\'' +
                ", iconImage='" + iconImage + '\'' +
                ", commands=" + commands +
                ", additionalFields=" + additionalFields +
                ", discounts=" + discounts +
                '}';
    }

}
