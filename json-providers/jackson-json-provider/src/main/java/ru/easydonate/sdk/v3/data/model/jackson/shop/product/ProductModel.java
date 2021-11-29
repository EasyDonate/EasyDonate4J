package ru.easydonate.sdk.v3.data.model.jackson.shop.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.shop.AdditionalField;
import ru.easydonate.sdk.v3.data.model.jackson.shop.AdditionalFieldModel;
import ru.easydonate.sdk.v3.data.model.shop.ProductType;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;
import ru.easydonate.sdk.v3.json.serialization.deserializer.jackson.NonNullListDeserializer;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Implementing(Product.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel implements Product {

    @JsonProperty("id")
    private int id;
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String typeRaw;
    @JsonProperty("price")
    private double price;
    @JsonProperty("number")
    private int amount;

    @JsonProperty("description")
    private String description;
    @JsonProperty("old_price")
    private Double oldPrice;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("image")
    private String iconImage;
    @JsonProperty("is_hidden")
    private boolean hidden;
    @JsonProperty("first_delete")
    private boolean oneTimePurchasable;

    @JsonProperty("commands")
    private List<String> commands;
    @JsonProperty("withdraw_commands")
    @JsonDeserialize(using = NonNullListDeserializer.class)
    private List<String> withdrawCommands;
    @JsonProperty("withdraw_commands_days")
    private Integer withdrawCommandsDelay;
    @JsonProperty("additional_fields")
    @JsonDeserialize(using = AdditionalFieldModel.ListDeserializer.class)
    private List<AdditionalField> additionalFields;
    @JsonProperty("sort_index")
    private int sortIndex;
    @JsonProperty("servers")
    private ServersList servers;

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
    public @NotNull OptionalInt getCategoryId() {
        return Wrapper.wrapNullableInt(categoryId);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getWithdrawCommandsDelay() {
        return Wrapper.wrapNullableInt(withdrawCommandsDelay);
    }

    @JsonIgnore
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
