package ru.easydonate.easydonate4j.v3.data.model.gson.shop.purchase;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.Discounts;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.FilledAdditionalField;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.PurchasedProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

@Getter
@Implementing(PurchasedProduct.class)
public class PurchasedProductModel implements PurchasedProduct {

    @SerializedName("id")
    private int id;
    @SerializedName("product_id")
    private int productId;
    @SerializedName("payment_id")
    private int paymentId;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String typeRaw;
    @SerializedName("price")
    private double price;
    @SerializedName("number")
    private int defaultAmount;
    @SerializedName("amount")
    private int boughtAmount;

    @SerializedName("description")
    private String description;
    @SerializedName("old_price")
    private Double oldPrice;
    @SerializedName("image")
    private String iconImage;
    @SerializedName("first_delete")
    private boolean oneTimePurchasable;

    @SerializedName("commands")
    private List<String> commands;
    @SerializedName("additional_fields")
    @JsonAdapter(FilledAdditionalFieldModel.ListDeserializer.class)
    private List<FilledAdditionalField> additionalFields;
    @SerializedName("sales")
    private Discounts discounts;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public @NotNull ProductType getType() {
        return ProductType.getByKey(typeRaw);
    }

    @Override
    public @NotNull Optional<String> getDescription() {
        return Wrapper.wrapNullable(description);
    }

    @Override
    public @NotNull OptionalDouble getOldPrice() {
        return Wrapper.wrapNullableDouble(oldPrice);
    }

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
