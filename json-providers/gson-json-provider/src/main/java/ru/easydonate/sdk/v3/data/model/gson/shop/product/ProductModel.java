package ru.easydonate.sdk.v3.data.model.gson.shop.product;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.gson.shop.AdditionalFieldModel;
import ru.easydonate.sdk.v3.data.model.shop.AdditionalField;
import ru.easydonate.sdk.v3.data.model.shop.ProductType;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;
import ru.easydonate.sdk.v3.json.serialization.deserializer.gson.NonNullListDeserializer;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Implementing(Product.class)
public class ProductModel implements Product {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String typeRaw;
    @SerializedName("price")
    private double price;
    @SerializedName("number")
    private int amount;

    @SerializedName("description")
    private String description;
    @SerializedName("old_price")
    private Double oldPrice;
    @SerializedName("category_id")
    private Integer categoryId;
    @SerializedName("image")
    private String iconImage;
    @SerializedName("is_hidden")
    private boolean hidden;
    @SerializedName("first_delete")
    private boolean oneTimePurchasable;

    @SerializedName("commands")
    private List<String> commands;
    @SerializedName("withdraw_commands")
    @JsonAdapter(NonNullListDeserializer.class)
    private List<String> withdrawCommands;
    @SerializedName("withdraw_commands_days")
    private Integer withdrawCommandsDelay;
    @SerializedName("additional_fields")
    @JsonAdapter(AdditionalFieldModel.ListDeserializer.class)
    private List<AdditionalField> additionalFields;
    @SerializedName("sort_index")
    private int sortIndex;
    @SerializedName("servers")
    private ServersList servers;

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
    public @NotNull OptionalInt getCategoryId() {
        return Wrapper.wrapNullableInt(categoryId);
    }

    @Override
    public @NotNull OptionalInt getWithdrawCommandsDelay() {
        return Wrapper.wrapNullableInt(withdrawCommandsDelay);
    }

    @Override
    public @NotNull Optional<ServersList> getServers() {
        return Wrapper.wrapNullable(servers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModel that = (ProductModel) o;
        return id == that.id &&
                shopId == that.shopId &&
                Double.compare(that.price, price) == 0 &&
                amount == that.amount &&
                hidden == that.hidden &&
                oneTimePurchasable == that.oneTimePurchasable &&
                sortIndex == that.sortIndex &&
                Objects.equals(name, that.name) &&
                Objects.equals(typeRaw, that.typeRaw) &&
                Objects.equals(description, that.description) &&
                Objects.equals(oldPrice, that.oldPrice) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(iconImage, that.iconImage) &&
                Objects.equals(commands, that.commands) &&
                Objects.equals(withdrawCommands, that.withdrawCommands) &&
                Objects.equals(withdrawCommandsDelay, that.withdrawCommandsDelay) &&
                Objects.equals(additionalFields, that.additionalFields) &&
                Objects.equals(servers, that.servers) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, shopId, name, typeRaw, price, amount, description, oldPrice,
                categoryId, iconImage, hidden, oneTimePurchasable, commands, withdrawCommands,
                withdrawCommandsDelay, additionalFields, sortIndex, servers, createdAt, updatedAt
        );
    }

    @Override
    public @NotNull String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", typeRaw='" + typeRaw + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", oldPrice=" + oldPrice +
                ", categoryId=" + categoryId +
                ", iconImage='" + iconImage + '\'' +
                ", hidden=" + hidden +
                ", oneTimePurchasable=" + oneTimePurchasable +
                ", commands=" + commands +
                ", withdrawCommands=" + withdrawCommands +
                ", withdrawCommandsDelay=" + withdrawCommandsDelay +
                ", additionalFields=" + additionalFields +
                ", sortIndex=" + sortIndex +
                ", servers=" + servers +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
