package ru.easydonate.sdk.v3.data.model.jackson.shop.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.ProductType;
import ru.easydonate.sdk.v3.data.model.shop.purchase.Discounts;
import ru.easydonate.sdk.v3.data.model.shop.purchase.FilledAdditionalField;
import ru.easydonate.sdk.v3.data.model.shop.purchase.PurchasedProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

@Getter
@Implementing(PurchasedProduct.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchasedProductModel implements PurchasedProduct {

    @JsonProperty("id")
    private int id;
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("payment_id")
    private int paymentId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String typeRaw;
    @JsonProperty("price")
    private double price;
    @JsonProperty("number")
    private int defaultAmount;
    @JsonProperty("amount")
    private int boughtAmount;

    @JsonProperty("description")
    private String description;
    @JsonProperty("old_price")
    private Double oldPrice;
    @JsonProperty("image")
    private String iconImage;
    @JsonProperty("first_delete")
    private boolean oneTimePurchasable;

    @JsonProperty("commands")
    private List<String> commands;
    @JsonProperty("additional_fields")
    @JsonDeserialize(using = FilledAdditionalFieldModel.ListDeserializer.class)
    private List<FilledAdditionalField> additionalFields;
    @JsonProperty("sales")
    private Discounts discounts;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Override
    public @NotNull ProductType getType() {
        return ProductType.getByKey(typeRaw);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getDescription() {
        return Wrapper.wrapNullable(description);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalDouble getOldPrice() {
        return Wrapper.wrapNullableDouble(oldPrice);
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
                productId == that.productId &&
                paymentId == that.paymentId &&
                Double.compare(that.price, price) == 0 &&
                defaultAmount == that.defaultAmount &&
                boughtAmount == that.boughtAmount &&
                oneTimePurchasable == that.oneTimePurchasable &&
                Objects.equals(name, that.name) &&
                Objects.equals(typeRaw, that.typeRaw) &&
                Objects.equals(description, that.description) &&
                Objects.equals(oldPrice, that.oldPrice) &&
                Objects.equals(iconImage, that.iconImage) &&
                Objects.equals(commands, that.commands) &&
                Objects.equals(additionalFields, that.additionalFields) &&
                Objects.equals(discounts, that.discounts) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, productId, paymentId, name, typeRaw, price, defaultAmount, boughtAmount, description,
                oldPrice, iconImage, oneTimePurchasable, commands, additionalFields, discounts, createdAt, updatedAt
        );
    }

    @Override
    public @NotNull String toString() {
        return "PurchasedProductModel{" +
                "id=" + id +
                ", productId=" + productId +
                ", paymentId=" + paymentId +
                ", name='" + name + '\'' +
                ", typeRaw='" + typeRaw + '\'' +
                ", price=" + price +
                ", defaultAmount=" + defaultAmount +
                ", boughtAmount=" + boughtAmount +
                ", description='" + description + '\'' +
                ", oldPrice=" + oldPrice +
                ", iconImage='" + iconImage + '\'' +
                ", oneTimePurchasable=" + oneTimePurchasable +
                ", commands=" + commands +
                ", additionalFields=" + additionalFields +
                ", discounts=" + discounts +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
